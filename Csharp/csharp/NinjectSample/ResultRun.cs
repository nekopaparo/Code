using NinjectSample.Models;
using NinjectSample.Modules;
using Ninject;

namespace NinjectSample
{
    class ResultRun
    {
        public ResultRun()
        {
            ServiceProvider.Kernel.Load(new Binder(new Module_1()));

            Model_1 Model_1 = ServiceProvider.Kernel.Get<Model_1>();

            Model_1.Name = "Jack";
            ServiceProvider.Kernel.Get<Model_2>().Message = "Hello World";
            ServiceProvider.Kernel.Get<Model_3>().Prt();

            Model_1.Name = "Gura";
            ServiceProvider.Kernel.Get<Model_2>().Message = "Peko Peko";
            ServiceProvider.Kernel.Get<Model_3>().Prt();
        }
    }
}
