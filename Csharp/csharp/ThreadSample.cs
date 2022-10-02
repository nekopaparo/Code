// lock https://learn.microsoft.com/zh-tw/dotnet/csharp/language-reference/statements/lock

using System;
using System.Threading;
using System.Threading.Tasks;
using Tools;

class Example
{
    private static readonly object balanceLock = new object();

    static void Start(string str)
    {
        lock (balanceLock)
        {
            Console.WriteLine("{0} Task={1}, Thread={2}, Test={3} start", DateTime.Now.ToString(), Task.CurrentId, Thread.CurrentThread.ManagedThreadId, str);
            Thread.Sleep(1000);
        }
    }

    static void Test()
    {
        Start("Test1");
        Thread.Sleep(1000);
        Console.WriteLine("Task={0} 結束", Task.CurrentId);
    }
    static void Test2()
    {
        Start("Test2"); Thread.Sleep(3000);
        Console.WriteLine("Task={0} 結束", Task.CurrentId);
    }
    static void Test3()
    {
        Start("Test3");
        Thread.Sleep(5000);
        Console.WriteLine("Task={0} 結束", Task.CurrentId);
    }
    static void Test4()
    {
        Start("Test4"); 
        Thread.Sleep(10000);
        Console.WriteLine("Task={0} 結束", Task.CurrentId);
    }
    static void Main()
    {
        MyTaskScheduler myTaskScheduler = new MyTaskScheduler(2);

        myTaskScheduler.AddSchedule(Test);
        myTaskScheduler.AddSchedule(Test2);
        myTaskScheduler.AddSchedule(Test4);
        myTaskScheduler.AddSchedule(Test);
        myTaskScheduler.AddSchedule(Test3);
        myTaskScheduler.AddSchedule(Test2);
        myTaskScheduler.AddSchedule(Test4);
        myTaskScheduler.AddSchedule(Test);
        myTaskScheduler.AddSchedule(Test3);
        myTaskScheduler.AddSchedule(Test2);

        myTaskScheduler.Run();
        myTaskScheduler.Run();

        Console.WriteLine("\n\nSuccessful completion.");
        Console.Read();
    }
}

// 執行緒介紹 https://www.796t.com/article.php?id=161403
// Task https://learn.microsoft.com/zh-tw/dotnet/api/system.threading.tasks.task?view=net-6.0
// Action https://www.delftstack.com/zh-tw/howto/csharp/pass-function-as-parameter-inside-another-function-in-csharp/


using System;
using System.Collections.Generic;
using System.Threading;
using System.Threading.Tasks;

namespace Tools
{
    class MyTaskScheduler
    {
        private readonly TaskFactory factory;
        private readonly List<Action> actions;
        private readonly List<Task> tasks;

        public MyTaskScheduler(int maxDegreeOfTask)
        {
            factory = new TaskFactory(new LimitedConcurrencyLevelTaskScheduler(maxDegreeOfTask));
            actions = new List<Action>();
            tasks = new List<Task>();
        }

        public void AddSchedule(Action action)
        {
            actions.Add(action);
        }

        public void ClearSchedule()
        {
            actions.Clear();
        }

        public void Run()
        {
            CancellationTokenSource cts = new CancellationTokenSource();

            foreach (Action action in actions)
            {
                tasks.Add(factory.StartNew(action, cts.Token));
            }

            Task.WaitAll(tasks.ToArray());

            cts.Dispose();
            tasks.Clear();
        }
    }
    // TaskScheduler https://learn.microsoft.com/zh-tw/dotnet/api/system.threading.tasks.taskscheduler?view=net-6.0
    // Provides a task scheduler that ensures a maximum concurrency level while
    // running on top of the thread pool.
    public class LimitedConcurrencyLevelTaskScheduler : TaskScheduler
    {
        // Indicates whether the current thread is processing work items.
        [ThreadStatic]
        private static bool _currentThreadIsProcessingItems;

        // The list of tasks to be executed
        private readonly LinkedList<Task> _tasks = new LinkedList<Task>(); // protected by lock(_tasks)

        // The maximum concurrency level allowed by this scheduler.
        private readonly int _maxDegreeOfParallelism;

        // Indicates whether the scheduler is currently processing work items.
        private int _delegatesQueuedOrRunning = 0;

        // Creates a new instance with the specified degree of parallelism.
        public LimitedConcurrencyLevelTaskScheduler(int maxDegreeOfParallelism)
        {
            if (maxDegreeOfParallelism < 1) throw new ArgumentOutOfRangeException("maxDegreeOfParallelism");
            _maxDegreeOfParallelism = maxDegreeOfParallelism;
        }

        // Queues a task to the scheduler.
        protected sealed override void QueueTask(Task task)
        {
            // Add the task to the list of tasks to be processed.  If there aren't enough
            // delegates currently queued or running to process tasks, schedule another.
            lock (_tasks)
            {
                _tasks.AddLast(task);
                if (_delegatesQueuedOrRunning < _maxDegreeOfParallelism)
                {
                    ++_delegatesQueuedOrRunning;
                    NotifyThreadPoolOfPendingWork();
                }
            }
        }

        // Inform the ThreadPool that there's work to be executed for this scheduler.
        private void NotifyThreadPoolOfPendingWork()
        {
            ThreadPool.UnsafeQueueUserWorkItem(_ =>
            {
                // Note that the current thread is now processing work items.
                // This is necessary to enable inlining of tasks into this thread.
                _currentThreadIsProcessingItems = true;
                try
                {
                    // Process all available items in the queue.
                    while (true)
                    {
                        Task item;
                        lock (_tasks)
                        {
                            // When there are no more items to be processed,
                            // note that we're done processing, and get out.
                            if (_tasks.Count == 0)
                            {
                                --_delegatesQueuedOrRunning;
                                break;
                            }

                            // Get the next item from the queue
                            item = _tasks.First.Value;
                            _tasks.RemoveFirst();
                        }

                        // Execute the task we pulled out of the queue
                        base.TryExecuteTask(item);
                    }
                }
                // We're done processing items on the current thread
                finally { _currentThreadIsProcessingItems = false; }
            }, null);
        }

        // Attempts to execute the specified task on the current thread.
        protected sealed override bool TryExecuteTaskInline(Task task, bool taskWasPreviouslyQueued)
        {
            // If this thread isn't already processing a task, we don't support inlining
            if (!_currentThreadIsProcessingItems) return false;

            // If the task was previously queued, remove it from the queue
            if (taskWasPreviouslyQueued)
                // Try to run the task.
                if (TryDequeue(task))
                    return base.TryExecuteTask(task);
                else
                    return false;
            else
                return base.TryExecuteTask(task);
        }

        // Attempt to remove a previously scheduled task from the scheduler.
        protected sealed override bool TryDequeue(Task task)
        {
            lock (_tasks) return _tasks.Remove(task);
        }

        // Gets the maximum concurrency level supported by this scheduler.
        public sealed override int MaximumConcurrencyLevel { get { return _maxDegreeOfParallelism; } }

        // Gets an enumerable of the tasks currently scheduled on this scheduler.
        protected sealed override IEnumerable<Task> GetScheduledTasks()
        {
            bool lockTaken = false;
            try
            {
                Monitor.TryEnter(_tasks, ref lockTaken);
                if (lockTaken) return _tasks;
                else throw new NotSupportedException();
            }
            finally
            {
                if (lockTaken) Monitor.Exit(_tasks);
            }
        }
    }
}
