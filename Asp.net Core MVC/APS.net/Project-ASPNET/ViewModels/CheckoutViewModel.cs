using Microsoft.AspNetCore.Mvc.Rendering;
using ProjectDotNetV2.Data.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectDotNetV2.ViewModels
{
    public class CheckoutViewModel
    {
        public Order order { get; set; }
        public ShoppingCart ShoppingCart { get; set; }
        public List<SelectListItem> ListCountries { get; set; }
    }
}
