using ProjectDotNetV2.Data.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectDotNetV2.ViewModels
{
    public class ShopViewModel
    {
        
        public IEnumerable<Product> NewProducts { get; set; }
        public IEnumerable<Product> FeaturedProducts { get; set; }

    }
}
