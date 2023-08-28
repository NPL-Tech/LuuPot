
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using ProjectDotNetV2.Data;
using ProjectDotNetV2.Data.Entities;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;

namespace ProjectDotNetV2.Areas.Admin.Controllers
{
    [Area("Admin")]
    [Authorize(Roles = "Admin")]
    public class HomeController : Controller
    {
        private readonly AppDbContext _context;
        private readonly IAppRepository appRepositor;
        public HomeController(AppDbContext context, IAppRepository appRepository)
        {
            _context = context;
            this.appRepositor = appRepository;
        }
        public async Task<IActionResult> Index()
        {
            var listBils = appRepositor.GetAllBills();
            double total = 0;
            foreach (var bills in listBils)
            {
                total = total + bills.price;
            }
            ViewData["allBills"] = total;
            ViewData["allcategory"] = appRepositor.GetAllCategories().Count();
            ViewData["allorder"] = appRepositor.GetAllOrders().Count();
            ViewData["allproduct"] = appRepositor.GetAllProducts().Count();
            ViewData["alltransport"] = appRepositor.GetALLTransport().Count();


            var appDbContext = _context.Orders.Include(o => o.User);
            return View(await appDbContext.ToListAsync());
        }
    }
}
