
namespace NinjectSample.Models
{
    class Model_1
    {
        public string Name { get; set; }
        public Model_4 Model { get; } = new Model_4();

        public Model_1()
        {
            System.Console.WriteLine("Model_1 is Create");
        }
    }
}
