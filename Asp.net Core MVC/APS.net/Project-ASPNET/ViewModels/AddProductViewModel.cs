using Microsoft.AspNetCore.Http;
using ProjectDotNetV2.Data.Entities;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectDotNetV2.ViewModels
{
    public class AddProductViewModel
    {
        [Required(ErrorMessage = "Please choose image")]
        [Display(Name = "Choose image")]
        public IFormFile ProductFirstImage { get; set; }

        [Required(ErrorMessage = "Please enter product's name")]
        [Display(Name = "Product Name")]
        public string Name { get; set; }

        [Required(ErrorMessage = "Please enter category name")]
        [Display(Name = "Category Name")]
        public string CategoryName { get; set; }

        [Required(ErrorMessage = "Please enter Price")]
        [Display(Name = "Price")]

        public decimal Price { get; set; }

        [Required(ErrorMessage = "Please enter Description")]
        [Display(Name = "Description")]

        public string Description { get; set; }

        [Required(ErrorMessage = "Please enter quantity")]
        [Display(Name = "Quantity")]

        public string Quantity { get; set; }

        public PaginatedList<Product> Products { get; set; }
    }
}
