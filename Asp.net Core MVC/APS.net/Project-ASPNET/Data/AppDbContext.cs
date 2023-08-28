using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using ProjectDotNetV2.Data.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectDotNetV2.Data
{
    public class AppDbContext : IdentityDbContext<User>
    {
        public AppDbContext(DbContextOptions<AppDbContext> options) : base(options)
        {

        }
        public DbSet<Product> Products { get; set; }
        public DbSet<Category> Categories { get; set; }
        public DbSet<ShoppingCartItem> ShoppingCartItems { get; set; }
        public DbSet<Order> Orders { get; set; }
        public DbSet<Transport> Transport { get; set; }
        public DbSet<Bill> Bill { get; set; }


        public DbSet<OrderDetail> OrderDetails { get; set; }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<Category>().HasData(new Category { CategoryId = 1, ProductCategory = "Jacket", Gender = "Men" });
            modelBuilder.Entity<Category>().HasData(new Category { CategoryId = 2, ProductCategory = "Jean", Gender = "Men" });
            modelBuilder.Entity<Category>().HasData(new Category { CategoryId = 3, ProductCategory = "Pant", Gender = "Men" });
            modelBuilder.Entity<Category>().HasData(new Category { CategoryId = 4, ProductCategory = "Shirt", Gender = "Men" });
            modelBuilder.Entity<Category>().HasData(new Category { CategoryId = 5, ProductCategory = "Sneaker", Gender = "Men" });
            modelBuilder.Entity<Category>().HasData(new Category { CategoryId = 6, ProductCategory = "Sweater", Gender = "Men" });
            modelBuilder.Entity<Category>().HasData(new Category { CategoryId = 7, ProductCategory = "T-Shirt", Gender = "Men" });
            modelBuilder.Entity<Category>().HasData(new Category { CategoryId = 8, ProductCategory = "Dress", Gender = "Women" });
            modelBuilder.Entity<Category>().HasData(new Category { CategoryId = 9, ProductCategory = "Footwear", Gender = "Women" });
            modelBuilder.Entity<Category>().HasData(new Category { CategoryId = 10, ProductCategory = "Jacket and Coat", Gender = "Women" });
            modelBuilder.Entity<Category>().HasData(new Category { CategoryId = 11, ProductCategory = "Jean", Gender = "Women" });
            modelBuilder.Entity<Category>().HasData(new Category { CategoryId = 12, ProductCategory = "Shirt", Gender = "Women" });
            modelBuilder.Entity<Category>().HasData(new Category { CategoryId = 13, ProductCategory = "Skirt", Gender = "Women" });
            modelBuilder.Entity<Category>().HasData(new Category { CategoryId = 14, ProductCategory = "T-Shirt", Gender = "Women" });

            modelBuilder.Entity<Product>().Property(p => p.AddedDate).HasDefaultValueSql("getdate()");

            modelBuilder.Entity<User>().Property(b => b.CreatedDate).HasDefaultValueSql("getdate()");
            modelBuilder.Entity<User>().Property("Active").HasDefaultValue(true);


        }
    }
   
}

