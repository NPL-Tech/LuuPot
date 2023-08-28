using ProjectDotNetV2.Data.Entities;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectDotNetV2.ViewModels
{
    public class CategoryViewModel
    {
        public int CategoryId { get; set; }

        [Required(ErrorMessage = "Please enter category name")]
        public string CategoryName { get; set; }

        [Required(ErrorMessage = "Please enter gender")]
        public string Gender { get; set; }
        public string Note { get; set; }

        public IEnumerable<Category> Categories { get; set; }

    }
}
