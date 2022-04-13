using NinjectSample.Models;

namespace NinjectSample.Modules
{
    class Module_1 : IModule
    {

        public void OnLoad(IBinder Binder)
        {
            System.Console.WriteLine("Module_1 -> OnLoad");

            Binder.BindSingleton<Model_1>();
            Binder.Bind(() => Binder.Get<Model_1>().Name, false);
            Binder.Bind(() => Binder.Get<Model_1>().Model);

            Binder.BindSingleton<Model_2>();
            Binder.BindSingleton<Model_3>(false);
        }

    }
}
