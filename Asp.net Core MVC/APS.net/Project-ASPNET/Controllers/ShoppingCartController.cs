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
    public class ShoppingCartController : Controller
    {
        private readonly IAppRepository appRepository;
        private readonly ShoppingCart shoppingCart;

        public ShoppingCartController(IAppRepository appRepository, ShoppingCart shoppingCart)
        {
            this.appRepository = appRepository;
            this.shoppingCart = shoppingCart;
        }

        public IActionResult Index()
        {
            var items = shoppingCart.GetShoppingCartItems();
            shoppingCart.ShoppingCartItems = items;

            var shoppingCartViewModel = new ShoppingCartViewModel
            {
                ShoppingCart = shoppingCart,
                ShoppingCartTotal = shoppingCart.GetShoppingCartTotal()
            };

            return View(shoppingCartViewModel);
        }

        public RedirectToActionResult AddToShoppingCart(int id)
        {
            var selectedProduct = appRepository.AllProducts.FirstOrDefault(p => p.Id == id);

            if(selectedProduct != null)
            {
                shoppingCart.AddToCart(selectedProduct, 1);
            }
            return RedirectToAction("Index");
        }

        public RedirectToActionResult RemoveFromShoppingCart(int id)
        {
            var selectedProduct = appRepository.AllProducts.FirstOrDefault(p => p.Id == id);

            if(selectedProduct != null)
            {
                shoppingCart.RemoveFromCart(selectedProduct);
            }
            return RedirectToAction("Index");
        }
    }
}
