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
    public class UserController : Controller
    {
        private readonly AppDbContext _context;
        private readonly IAppRepository appRepository;
        public UserController(AppDbContext context, IAppRepository appRepository)
        {
            _context = context;
            this.appRepository = appRepository;
        }
        public IActionResult Index()
        {
            return View();
        }
        public IActionResult GetListUser()
        {
            var listUser = appRepository.GetListUser();
            return Json(listUser);
        }
        public IActionResult ActiveUser(String id)

        {
            appRepository.activeUsers(id);
            return Ok();
        }
    }
}
