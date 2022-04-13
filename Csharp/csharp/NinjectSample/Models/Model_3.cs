
namespace NinjectSample.Models
{
    class Model_3
    {
        private static int count = 0;
        public string Name { get; }
        readonly Model_2 _model_2;
        readonly Model_4 _model;

        public Model_3(string Name, Model_2 Model_2, Model_4 Model)
        {
            System.Console.WriteLine("Model_3 is Create");
            count++;
            this.Name = Name;
            _model_2 = Model_2;
            _model = Model;
        }

        public void Prt()
        {
            System.Console.WriteLine($"{count}. Hi {Name}, your Message:'{_model_2.Message}'");
        }
    }
}
