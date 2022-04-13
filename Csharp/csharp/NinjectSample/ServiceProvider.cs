using NinjectSample.Modules;
using Ninject;

namespace NinjectSample
{
    class ServiceProvider
    {
        public static IKernel Kernel { get; } = new StandardKernel();

        public static T Get<T>() => Kernel.Get<T>();

        public static void LoadModule(IModule Module)
        {
            Kernel.Load(new Binder(Module));
        }
    }
}
