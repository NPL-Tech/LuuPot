package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import BO.CategoryBO;
import BO.ProductsBO;
import dao.ProductDetailDAO;
import dao.ProductsDAO;
import model.Category;
import model.Products;

/**
 * Servlet implementation class AdminEditProductController
 */
@WebServlet("/AdminEditProductController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 50, // 50MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AdminEditProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String idx=request.getParameter("id");
		HttpSession session = request.getSession();
		long id=Long.parseLong(idx);
		CategoryBO c = new CategoryBO();
		ArrayList<Category> listB = c.getListBrand();
		ArrayList<Category> listC = c.getListCategory();
		ProductsDAO productsDAO= new ProductsDAO();
		Products p=productsDAO.getProductsByID(id);
		session.setAttribute("editproduct", p);
		request.setAttribute("listB", listB);
		request.setAttribute("listC", listC);
		request.setAttribute("productedit",p);
		RequestDispatcher resd= request.getRequestDispatcher("admin\\editproducts.jsp");
		resd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		ProductDetailDAO dao = new ProductDetailDAO();
		ProductsBO pBo = new ProductsBO();
		HttpSession session = request.getSession();
		Products sProducts =(Products) session.getAttribute("editproduct");
		String productname = request.getParameter("username");
		String style = request.getParameter("val-style");
		String brand = request.getParameter("val-brand");
		String address = request.getParameter("val-address");
		String status = request.getParameter("var-status");
		String dependency = request.getParameter("val-dependency");
		String category = request.getParameter("val-category");
		String current = request.getParameter("val-currency");
		String discount = request.getParameter("val-discount");
		String amount = request.getParameter("val-amount");
		String sdate = request.getParameter("val-sdate");
		String endate = request.getParameter("val-enddate");
		long IdC = Long.parseLong(category);
		int idb = Integer.parseInt(brand);
		int dis = Integer.parseInt(discount);
		double price = Double.parseDouble(current);
		
		int sl =Integer.parseInt(amount);
		Products products = new Products(sProducts.getId(), IdC, productname, dependency, null, price, dis, idb, idb, sdate, endate, style, sl, address);


		Part filePart = request.getPart("file");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString().trim();
		InputStream fileContent = filePart.getInputStream();
		products.setAnhChinh(fileName);
		pBo.editProduct(products);
		String empty = new String();
		if (!fileName.equals(empty)) {
			String appPath = request.getServletContext().getRealPath("");
			appPath = appPath.replace('\\', '/');
			String fullSavePath = null;
			if (appPath.endsWith("/")) {
				fullSavePath = appPath + "viewroot/img/shop/product/";
			} else {
				fullSavePath = appPath + "/" + "viewroot/img/shop/product/";
			}
			File file = new File(fullSavePath, fileName);
			try {
				Files.copy(fileContent, file.toPath());
			} catch (Exception e) {

			}
		}
		if(fileName==null) {
			products.setAnhChinh(sProducts.getAnhChinh());
		}else {
			products.setAnhChinh(fileName);
		}
		pBo.editProduct(products);
		response.sendRedirect("AdminEditProductController?id="+sProducts.getId());

	}
	

}
