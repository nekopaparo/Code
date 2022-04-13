using NinjectSample.Modules;
using Ninject.Modules;
using System;

namespace NinjectSample
{
    public interface IBinder
    {
        void BindSingleton<T>(bool Singleton = true);
        void Bind<TFrom, TTarget>(bool Singleton = true) where TTarget : TFrom;
        void Bind<T>(Func<T> Function, bool Singleton = true);

        T Get<T>();
    }
    class Binder : NinjectModule, IBinder
    {
        readonly IModule _module;

        public Binder(IModule Module)
        {
            _module = Module;
        }

        public override void Load()
        {
            _module.OnLoad(this);
        }

        public void BindSingleton<T>(bool Singleton = true)
        {
            var binding = Bind<T>().ToSelf();

            if (Singleton)
                binding.InSingletonScope();
        }

        public void Bind<T>(Func<T> Function, bool Singleton = true)
        {
            var binding = Bind<T>().ToMethod(M => Function());

            if (Singleton)
                binding.InSingletonScope();
        }

        public void Bind<TFrom, TTarget>(bool Singleton = true) where TTarget : TFrom
        {
            var binding = Bind<TFrom>().To<TTarget>();
            if (Singleton)
                binding.InSingletonScope();
        }

        public T Get<T>() => ServiceProvider.Get<T>();
    }
}
