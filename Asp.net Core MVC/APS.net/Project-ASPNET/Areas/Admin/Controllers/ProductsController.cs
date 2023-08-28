using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using ProjectDotNetV2.Data;
using ProjectDotNetV2.Data.Entities;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Http;

namespace ProjectDotNetV2.Areas.Admin.Controllers
{
    [Area("Admin")]
    [Authorize(Roles = "Admin")]
    public class ProductsController : Controller
    {
        private readonly AppDbContext _context;
        private readonly IAppRepository appRepository;
        public ProductsController(AppDbContext context, IAppRepository appRepository)
        {
            _context = context;
            this.appRepository = appRepository;
        }

        [HttpPost]
        public IActionResult MultipleFiles(IEnumerable<IFormFile> files)
        {
            int i = 0;
            string _dir = "";
            foreach (var file in files)
            {
                using (var fileStream = new FileStream(Path.Combine(_dir, $"file{i++}.png"), FileMode.Create, FileAccess.Write))
                {
                    file.CopyTo(fileStream);
                }
            }

            return RedirectToAction("Index");
        }
        // GET: Admin/Products
        public  IActionResult Index()
        {
            List<SelectListItem> countries = _context.Categories.AsNoTracking()
                   .OrderBy(n => n.CategoryId)
                       .Select(n =>
                       new SelectListItem
                       {
                           Value = n.CategoryId.ToString(),
                           Text = n.ProductCategory
                       }).ToList();
            var countrytip = new SelectListItem()
            {
                Value = null,
                Text = "--- select country ---"
            };
            countries.Insert(0, countrytip);

            ViewBag.Categoris = countries;
            return View();
        }
        public IActionResult GetListProducts()
        {
            var listProducts = appRepository.GetAllProducts();
            return Json(listProducts);
        }
        // GET: Admin/Products/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var product = await _context.Products
                .Include(p => p.Category)
                .FirstOrDefaultAsync(m => m.Id == id);
            if (product == null)
            {
                return NotFound();
            }

            return View(product);
        }

        // GET: Admin/Products/Create
        public IActionResult Create()
        {
            ViewData["CategoryId"] = new SelectList(_context.Categories, "CategoryId", "CategoryId");
            return View();
        }

        // POST: Admin/Products/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> CreateProduct([Bind("Id,Name,ShortDescription,Description,Price,Color,Quantity,ProductFirstImage,ProductSecondImage,ProductThirdImage,CategoryId,Gender,AddedDate")] Product product, List<IFormFile> files)
        {
            var pro = new Product { Name = product.Name, AddedDate = product.AddedDate, Price = product.Price, Description = product.Description, Category = product.Category, Color = product.Color, CategoryId = product.CategoryId, Gender = product.Gender, Quantity = product.Quantity, ShortDescription = product.ShortDescription, ProductFirstImage = "ao-dai-tay-nam-aristino-ASW007W7-09.jpg", ProductSecondImage = "ao-dai-tay-nam-aristino-ASW007W7-11.jpg", ProductThirdImage = "ao-dai-tay-nam-aristino-ASW007W7-09.jpg" };
            if (!ModelState.IsValid)
            {
                _context.Add(pro);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
              
            }
            _context.Add(pro);
            await _context.SaveChangesAsync();
            return Ok();
        }

        // GET: Admin/Products/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var product = await _context.Products.FindAsync(id);
            if (product == null)
            {
                return NotFound();
            }
            List<SelectListItem> countries = _context.Categories.AsNoTracking()
                 .OrderBy(n => n.CategoryId)
                     .Select(n =>
                     new SelectListItem
                     {
                         Value = n.CategoryId.ToString(),
                         Text = n.ProductCategory
                     }).ToList();
            var countrytip = new SelectListItem()
            {
                Value = null,
                Text = "--- select country ---"
            };
            countries.Insert(0, countrytip);
            ViewBag.Categoris = countries;
            return View(product);
        }

        // POST: Admin/Products/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,Name,ShortDescription,Description,Price,Color,Quantity,ProductFirstImage,ProductSecondImage,ProductThirdImage,CategoryId,Gender,AddedDate")] Product product)
        {
            if (id != product.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(product);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!ProductExists(product.Id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            ViewData["CategoryId"] = new SelectList(_context.Categories, "CategoryId", "CategoryId", product.CategoryId);
            return View(product);
        }

        // GET: Admin/Products/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var product = await _context.Products
                .Include(p => p.Category)
                .FirstOrDefaultAsync(m => m.Id == id);
            _context.Products.Remove(product);
            await _context.SaveChangesAsync(); 
            if (product == null)
            {
                return NotFound();
            }

            return View(product);
        }

        // POST: Admin/Products/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var product = await _context.Products.FindAsync(id);
            _context.Products.Remove(product);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool ProductExists(int id)
        {
            return _context.Products.Any(e => e.Id == id);
        }
    }
}
