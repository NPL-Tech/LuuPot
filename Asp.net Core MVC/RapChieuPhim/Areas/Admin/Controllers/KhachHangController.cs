﻿using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using RapChieuPhim.Models;

namespace RapChieuPhim.Areas.Admin.Controllers
{
    public class KhachHangController : BaseController
    {
        private DBcontext db = new DBcontext();

        // GET: Admin/KhachHang
        public ActionResult Index()
        {
            var taiKhoans = db.TaiKhoans.Include(t => t.ThongTin);
            return View(taiKhoans.ToList());
        }
        // POST: Admin/KhachHang/GetJsonResult
        [HttpPost]
        public JsonResult GetJsonResult()
        {
            List<TaiKhoan> taiKhoans = db.TaiKhoans.Include(t => t.ThongTin).Where(tk => tk.PhanQuyen == "USER").ToList();
            var jsonKhachHang = taiKhoans.Select(tk => new
            {
                MaKH = tk.Id,
                TenKH = tk.ThongTin.TenNguoiDung,
                DiaChi = tk.ThongTin.DiaChi,
                NgaySinh = tk.ThongTin.NgaySinh,
                GioiTinh = tk.ThongTin.GioiTinh,
                NgayDK = tk.NgayDangKy,
                PhanQuyen = tk.PhanQuyen,
                TrinhTrang = tk.TinhTrang,
            });
            return Json(jsonKhachHang, behavior: JsonRequestBehavior.AllowGet);
        }
        // POST: Admin/KhachHang/ActivityUser
        [HttpPost]
        public bool ActivityUser(int? id)
        {
            TaiKhoan taiKhoan = db.TaiKhoans.Find(id);
            try
            {
                if (taiKhoan.TinhTrang)
                {
                    taiKhoan.TinhTrang = false;

                }
                else
                {
                    taiKhoan.TinhTrang = true;
                }
                db.Entry(taiKhoan).State = EntityState.Modified;
                db.SaveChanges();
            }
            catch
            {
                return false;
            }
            return true;
        }
        // POST: Admin/KhachHang/changeRole
        [HttpPost]
        public bool changeRole(int? id)
        {
            TaiKhoan taiKhoan = db.TaiKhoans.Find(id);
            try
            {


                if (taiKhoan.PhanQuyen == "USER")
                {
                    taiKhoan.PhanQuyen = "MANAGA";

                }
                else
                {
                    taiKhoan.PhanQuyen = "MANAGA";
                }
                db.Entry(taiKhoan).State = EntityState.Modified;
                db.SaveChanges();
            }
            catch
            {
                return false;
            }
            return true;
        }
        // GET: Admin/KhachHang/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            TaiKhoan taiKhoan = db.TaiKhoans.Find(id);
            if (taiKhoan == null)
            {
                return HttpNotFound();
            }
            return View(taiKhoan);
        }

        // GET: Admin/KhachHang/Create
        public ActionResult Create()
        {
            ViewBag.id_ThongTin = new SelectList(db.ThongTins, "ThongTin_id", "TenNguoiDung");
            return View();
        }

        // POST: Admin/KhachHang/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,TenDangNhap,MatKhau,NgayDangKy,TinhTrang,PhanQuyen,id_ThongTin")] TaiKhoan taiKhoan)
        {
            if (ModelState.IsValid)
            {
                db.TaiKhoans.Add(taiKhoan);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.id_ThongTin = new SelectList(db.ThongTins, "ThongTin_id", "TenNguoiDung", taiKhoan.id_ThongTin);
            return View(taiKhoan);
        }

        // GET: Admin/KhachHang/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            TaiKhoan taiKhoan = db.TaiKhoans.Find(id);
            if (taiKhoan == null)
            {
                return HttpNotFound();
            }
            ViewBag.id_ThongTin = new SelectList(db.ThongTins, "ThongTin_id", "TenNguoiDung", taiKhoan.id_ThongTin);
            return View(taiKhoan);
        }

        // POST: Admin/KhachHang/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,TenDangNhap,MatKhau,NgayDangKy,TinhTrang,PhanQuyen,id_ThongTin")] TaiKhoan taiKhoan)
        {
            if (ModelState.IsValid)
            {
                db.Entry(taiKhoan).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.id_ThongTin = new SelectList(db.ThongTins, "ThongTin_id", "TenNguoiDung", taiKhoan.id_ThongTin);
            return View(taiKhoan);
        }

        // GET: Admin/KhachHang/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            TaiKhoan taiKhoan = db.TaiKhoans.Find(id);
            if (taiKhoan == null)
            {
                return HttpNotFound();
            }
            db.TaiKhoans.Remove(taiKhoan);
            db.SaveChanges();
            return View(taiKhoan);
        }

        // POST: Admin/KhachHang/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            TaiKhoan taiKhoan = db.TaiKhoans.Find(id);
            db.TaiKhoans.Remove(taiKhoan);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
