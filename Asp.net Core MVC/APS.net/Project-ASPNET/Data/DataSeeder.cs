using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Identity;
using ProjectDotNetV2.Data.Entities;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace ProjectDotNetV2.Data
{
    public class DataSeeder
    {
        private readonly AppDbContext appDbContext;
        private readonly IWebHostEnvironment env;
        private readonly UserManager<User> userManager;
        private readonly RoleManager<IdentityRole> roleManager;

        public DataSeeder(AppDbContext appDbContext, IWebHostEnvironment env, UserManager<User> userManager, RoleManager<IdentityRole> roleManager)
        {
            this.appDbContext = appDbContext;
            this.env = env;
            this.userManager = userManager;
            this.roleManager = roleManager;
        }
        public async Task SeedAsync()
        {
            appDbContext.Database.EnsureCreated();

            if(!roleManager.RoleExistsAsync("User").Result)
            {
                IdentityRole role = new IdentityRole();
                role.Name = "User";
                IdentityResult roleResult = roleManager.CreateAsync(role).Result;
            }

            if (!roleManager.RoleExistsAsync("Admin").Result)
            {
                IdentityRole role = new IdentityRole();
                role.Name = "Admin";
                IdentityResult roleResult = roleManager.CreateAsync(role).Result;
            }

            if (userManager.FindByNameAsync("admin@gmail.com").Result == null)
            {
                User user = new User();
                user.UserName = "admin@gmail.com";
                user.Email = "admin@gmail.com";

                IdentityResult result = userManager.CreateAsync(user, "P@ssw0rd!").Result;

                if(result.Succeeded)
                {
                    userManager.AddToRoleAsync(user, "Admin").Wait();
                }
            }

            if (userManager.FindByNameAsync("user@gmail.com").Result == null)
            {
                User user = new User();
                user.UserName = "user@gmail.com";
                user.Email = "user@gmail.com";

                IdentityResult result = userManager.CreateAsync(user, "P@ssw0rd!").Result;

                if (result.Succeeded)
                {
                    userManager.AddToRoleAsync(user, "User").Wait();
                }
            }

            if (!appDbContext.Products.Any())
            {
               

                var productFilePath = Path.Combine(env.ContentRootPath, "Data/products.json");
                var productJson = File.ReadAllText(productFilePath);
                var products = JsonSerializer.Deserialize<IEnumerable<Product>>(productJson);
                appDbContext.Products.AddRange(products);
                appDbContext.SaveChanges();
            }
        }
    }
}
