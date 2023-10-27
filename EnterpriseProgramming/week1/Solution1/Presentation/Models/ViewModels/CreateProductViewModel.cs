using DataAccess.Repositories;
using Domain.Models;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Presentation.Models.ViewModels
{
    public class CreateProductViewModel
    {
        
        public CreateProductViewModel(CategoriesRepository categoriesRepository)
        {
            Categories = categoriesRepository.GetCategories().ToList();
        }

        [Required]
        public string Name { get; set; }
        public string Description { get; set; }

        public double Price { get; set; }

        public int Stock { get; set; }

        //public string? Image { get; set; }
         
        public List<Category> Categories { get; set; }


        public int CategoryFK { get; set; } //foreign key property


        public double WholesalePrice { get; set; }

        public string? Supplier { get; set; }
    }
}
