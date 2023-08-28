using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectDotNetV2.Data.Entities
{
    public class Category
    {
        public int CategoryId { get; set; }
        public string ProductCategory { get; set; }
        public string Gender { get; set; }
        public IEnumerable<Product> Products { get; set; }
    }
}
