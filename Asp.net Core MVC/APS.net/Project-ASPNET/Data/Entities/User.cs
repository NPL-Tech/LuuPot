using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectDotNetV2.Data.Entities
{
    public class User : IdentityUser
    {
 
        public string FullName { get; set; }
        public DateTime CreatedDate { get; set; }
        public bool Active { get; set; }
        public List<Order> Orders { get; set; }
    }
}
