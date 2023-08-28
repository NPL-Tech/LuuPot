using Microsoft.EntityFrameworkCore;
using ProjectDotNetV2.Data.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectDotNetV2.Data
{
    public class AppRepository : IAppRepository
    {
        private readonly AppDbContext context;

        public AppRepository(AppDbContext context)
        {
            this.context = context;
        }

        public IEnumerable<Product> AllProducts
        {
            get
            {
                return context.Products.ToList();
            }
        }

        public void activeUsers(String id)
        {
            Boolean setActive = true;
            User user = context.Users.Find(id);
            if (user.Active)
            {
                setActive = false;
            }
           
                User update = new User
                {
                    Id = user.Id,
                    AccessFailedCount = user.AccessFailedCount,
                    Active = setActive,
                    ConcurrencyStamp = user.ConcurrencyStamp,
                    CreatedDate = user.CreatedDate,
                    TwoFactorEnabled = user.TwoFactorEnabled,
                    UserName = user.UserName,
                    EmailConfirmed = user.EmailConfirmed,
                    FullName = user.FullName,
                    LockoutEnd = user.LockoutEnd,
                    Email = user.Email,
                    LockoutEnabled = user.LockoutEnabled,
                    NormalizedUserName = user.NormalizedUserName,
                    NormalizedEmail = user.NormalizedEmail,
                    Orders = user.Orders,
                    PasswordHash = user.PasswordHash,
                    PhoneNumber = user.PhoneNumber,
                    PhoneNumberConfirmed = user.PhoneNumberConfirmed,
                    SecurityStamp = user.SecurityStamp
                };
                context.Users.Update(update);
                context.SaveChanges();

            }


        

        public void AddCategory(Category category)
        {
            context.Categories.Add(category);
        }

        public void AddProduct(Product product)
        {
            context.Products.Add(product);
        }

        public void DeleteCategory(int categoryId)
        {
            throw new NotImplementedException();
        }

        public void DeleteOrder(int OrderId)
        {
            Order order = context.Orders.Find(OrderId);
            context.Orders.Remove(order);
        }

        public void DeleteProduct(int productId)
        {
            Product product = context.Products.Find(productId);
            context.Products.Remove(product);

        }

        public IEnumerable<Bill> GetAllBills()
        {
            return context.Bill.ToList();
        }

        public IEnumerable<Category> GetAllCategories()
        {
            return context.Categories.ToList();
        }

        public IEnumerable<Order> GetAllOrders()
        {
            return context.Orders.ToList();
        }

        public IEnumerable<Product> GetAllProducts()
        {
            return context.Products.Include(p => p.Category)
                //.OrderBy(p => p.Name)
                .ToList();
        }

        public IEnumerable<Transport> GetALLTransport()
        {
            return context.Transport.ToList();

        }

        public Category GetCategoryById(int id)
        {
            return context.Categories.FirstOrDefault(c => c.CategoryId == id);
        }

        public Category GetCategoryByName(string name)
        {
            return context.Categories.FirstOrDefault(c => c.ProductCategory == name);

        }

        public IEnumerable<User> GetListUser()
        {
            return context.Users.ToList();
        }

        public IEnumerable<Product> GetProductByCategory(string categoryName, string gender)
        {
            var category = context.Categories
                .Where(c => c.ProductCategory == categoryName && c.Gender == gender).First();


            return context.Products.Where(p => p.CategoryId == category.CategoryId);
        }

        public IEnumerable<Product> GetProductByGenderForHome(string gender)
        {

            var categoryFirstId = context.Categories.Where(c => c.ProductCategory == "Jacket").FirstOrDefault().CategoryId;
            var categorySecondId = context.Categories.Where(c => c.ProductCategory == "Sweater").FirstOrDefault().CategoryId;
            if (gender == "Female")
            {
                categoryFirstId = context.Categories.Where(c => c.ProductCategory == "Jacket and Coat").FirstOrDefault().CategoryId;
                categorySecondId = context.Categories.Where(c => c.ProductCategory == "Dress").FirstOrDefault().CategoryId;

            }
            return context.Products.Where(p => p.CategoryId == categoryFirstId || p.CategoryId == categorySecondId).OrderBy(p => Guid.NewGuid()).Take(8);
        }

        public Product GetProductById(int productId)
        {
            return context.Products.Find(productId);
        }

        public IEnumerable<Product> GetRandomProducts()
        {
            return context.Products.OrderBy(p => Guid.NewGuid()).Take(8);
        }

        public void Save()
        {
            context.SaveChanges();
        }

        public void UpdateCategory(Category category)
        {
        }

        public void UpdateProduct(Product product)
        {
            context.Entry(product).State = EntityState.Modified;
        }
    }
}
