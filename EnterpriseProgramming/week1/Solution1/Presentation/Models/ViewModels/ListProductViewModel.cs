namespace Presentation.Models.ViewModels
{
    public class ListProductViewModel
    {
        public Guid Id { get; set; }

        public string Name { get; set; }
        public string Description { get; set; }

        public double Price { get; set; }

        public int Stock {  get; set; }

        public string? Image {  get; set; }

        public string CategoryName { get; set; }

    }
}
