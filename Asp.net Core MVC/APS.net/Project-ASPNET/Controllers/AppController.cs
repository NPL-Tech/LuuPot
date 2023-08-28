using Microsoft.AspNetCore.Mvc;
using ProjectDotNetV2.Data;
using ProjectDotNetV2.Data.Entities;
using ProjectDotNetV2.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectDotNetV2.Controllers
{
    public class AppController : Controller
    {
        private readonly IAppRepository repository;

        public AppController(IAppRepository repository)
        {
            this.repository = repository;
        }
       
        public IActionResult Index()
        {
            ShopViewModel shopViewModel = new ShopViewModel();
            shopViewModel.NewProducts = repository.GetProductByGenderForHome("Male");
            shopViewModel.FeaturedProducts = repository.GetProductByGenderForHome("Female");
            return View(shopViewModel);
        }

        [Route("app/shop")]
        [HttpGet("shop")]
        public ActionResult Shop(string categoryName, string gender, string sortOrder, string selectedIndex, int? pageNumber)
        {

            var products = repository.GetAllProducts();
            ViewBag.Title = "Shop";

            if (categoryName != null)
            {
                products = repository.GetProductByCategory(categoryName, gender);
                ViewBag.Title = categoryName;
            }
            if (pageNumber == null)
            {
                pageNumber = 1;

            }
            int pageSize = 9;
            ViewBag.selectedIndex = selectedIndex;
            //ViewData["PriceSortParmAsc"] = String.IsNullOrEmpty(sortOrder) ? "priceAsc" : "";
            //ViewData["PriceSortParmDesc"] = String.IsNullOrEmpty(sortOrder) ? "priceDesc" : "";
            //ViewData["NameSortParmAsc"] = String.IsNullOrEmpty(sortOrder) ? "nameAsc" : "";
            //ViewData["NameSortParmAsc"] = String.IsNullOrEmpty(sortOrder) ? "nameDesc" : "";


            switch (sortOrder)
            {
                case "priceAsc":
                    products = products.OrderByDescending(p => p.Price);
                    break;
                case "priceDesc":
                    products = products.OrderBy(p => p.Price);
                    break;
                case "nameAsc":
                    products = products.OrderBy(p => p.Name);
                    break;
                case "nameDesc":
                    products = products.OrderByDescending(p => p.Name);
                    break;
                default:               
                    break;
            }

          
            //var shopViewModel = new ShopViewModel
            //{
            //    Products = products,
                
            //};

           

            return View(PaginatedList<Product>.Create(products, pageNumber ?? 1, pageSize));
        }

        [Route("app/singleproduct")]
        [HttpGet("single-product")]
        public IActionResult SingleProduct(int id)
        {
            ViewBag.Title = "Single Product";
            var product = repository.GetProductById(id);
            if(product == null)
            {
                return NotFound();
            }
            return View(product);
        }
        //[Route("app/cart")]
        //[HttpGet("cart")]
        //public IActionResult Cart()
        //{
        //    ViewBag.Title = "Cart";
        //    return View();
        //}

        //[HttpGet("login")]
        //public IActionResult Login()
        //{
        //    ViewBag.Title = "Login";
        //    return View();
        //}
        [Route("app/about")]
        [HttpGet("about")]
        public IActionResult About()
        {
            ViewBag.Title = "About us";
            return View();
        }
        [Route("app/checkout")]
        [HttpGet("checkout")]
        public IActionResult Checkout()
        {
            ViewBag.Title = "Checkout";
            return View();
        }
        [HttpGet("contact")]
        [Route("app/contactus")]
        public IActionResult Contact()
        {
            ViewBag.Title = "Contact Us";
            return View();
        }
        [Route("app/pagenotfound")]
        [HttpGet("pagenotfound")]
        public IActionResult PageNotFound()
        {
            ViewBag.Title = "Page not found";
            return View();
        }


        //public IActionResult Category(string category)
        //{
        //    var products = repository.GetProductByCategory(category);
        //    ViewBag.Title = category;
        //    return View(products);
        //}

       
    }

    
}
