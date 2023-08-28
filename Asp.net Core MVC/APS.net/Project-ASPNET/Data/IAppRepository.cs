using ProjectDotNetV2.Data.Entities;
using System.Collections.Generic;

namespace ProjectDotNetV2.Data
{
    public interface IAppRepository
    {

        void AddProduct(Product product);
        void DeleteProduct(int productId);
        void UpdateProduct(Product product);
        void Save();
        IEnumerable<Product> AllProducts { get; }
        IEnumerable<Product> GetAllProducts();
        IEnumerable<Product> GetProductByGenderForHome(string gender);
        IEnumerable<Product> GetProductByCategory(string categoryName, string gender);
        Category GetCategoryById(int id);
        Category GetCategoryByName(string name);
        IEnumerable<Category> GetAllCategories();
        void AddCategory(Category category);
        void DeleteCategory(int categoryId);
        void UpdateCategory(Category category);

        IEnumerable<Order> GetAllOrders();
        void DeleteOrder(int OrderId);
        IEnumerable<User> GetListUser();
        IEnumerable<Product> GetRandomProducts();
        IEnumerable<Bill> GetAllBills();
        Product GetProductById(int productId);
        IEnumerable<Transport> GetALLTransport();
        void activeUsers(string id);
       
    }
}