using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
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
    public class OrderController : Controller
    {
        private readonly IOrderRepository orderRepository;
        private readonly ShoppingCart shoppingCart;
        private readonly UserManager<User> userManager;

        public OrderController(IOrderRepository orderRepository, ShoppingCart shoppingCart, UserManager<User> userManager)
        {
            this.orderRepository = orderRepository;
            this.shoppingCart = shoppingCart;
            this.userManager = userManager;
        }

        public IActionResult Checkout()
        {
            var items = shoppingCart.GetShoppingCartItems();
            shoppingCart.ShoppingCartItems = items;

            var checkoutViewModel = new CheckoutViewModel
            {
                ShoppingCart = shoppingCart
            };
            //var vm = new CheckoutViewModel();
            //vm.ListCountries = new List<SelectListItem>
            //{
            //    new SelectListItem { Value="1", Text = "Australia"},
            //    new SelectListItem { Value="2", Text = "Canada"},
            //    new SelectListItem { Value="3", Text = "Indonesia"},
            //    new SelectListItem { Value="4", Text = "Japan"},
            //    new SelectListItem { Value="5", Text = "Philippines"},
            //    new SelectListItem { Value="6", Text = "Russia"},
            //    new SelectListItem { Value="7", Text = "Singapore"},
            //    new SelectListItem { Value="8", Text = "Thailand"},
            //    new SelectListItem { Value="9", Text = "United Kingdom"},
            //    new SelectListItem { Value="10", Text = "United States"},
            //    new SelectListItem { Value="11", Text = "Vietnam"},
            //};

            if(this.User.Identity.IsAuthenticated)
            {
               
                return View(checkoutViewModel);

            } else
            {
                return Redirect("~/Identity/Account/Login");
            }

        }

        [HttpPost]
        public IActionResult Checkout(CheckoutViewModel viewModel)
        {
            var items = shoppingCart.GetShoppingCartItems();
            shoppingCart.ShoppingCartItems = items;

            var user = userManager.FindByNameAsync(User.Identity.Name).Result;
            viewModel.order.UserId = user.Id;

            if(shoppingCart.ShoppingCartItems.Count == 0)
            {
                ModelState.AddModelError("", "Your cart is empty, add some products first");
            }
            viewModel.ShoppingCart = shoppingCart;
            if(ModelState.IsValid)
            {
                orderRepository.CreateOrder(viewModel.order);
                shoppingCart.ClearCart();
                return RedirectToAction("CheckoutComplete");
            }
            return View(viewModel);
        }

        public IActionResult CheckoutComplete()
        {


            ViewBag.Title = "Order successed! Thank you for your order!";
            return View();
        }
    }
}
