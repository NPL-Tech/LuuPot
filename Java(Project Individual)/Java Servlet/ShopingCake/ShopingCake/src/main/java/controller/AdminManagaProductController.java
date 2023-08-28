package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import BO.CategoryBO;
import BO.ProductsBO;
import dao.ProductDetailDAO;
import model.Category;
import model.Products;
import model.ProductsDetail;

/**
 * Servlet implementation class AdminManagaProductController
 */
@WebServlet("/AdminManagaProductController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AdminManagaProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminManagaProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		ProductsBO p = new ProductsBO();
		CategoryBO c = new CategoryBO();

		ArrayList<Products> listP = p.getListProducts();
		ArrayList<Category> listB = c.getListBrand();
		ArrayList<Category> listC = c.getListCategory();

		request.setAttribute("listB", listB);
		request.setAttribute("listC", listC);
		Gson gson = new GsonBuilder().create();
		JsonArray jarray = gson.toJsonTree(listP).getAsJsonArray();
		var jsonObject = new JsonObject();
		jsonObject.add("products", jarray);
		request.setAttribute("jsonProducts", jarray);

		RequestDispatcher rd = request.getRequestDispatcher("admin\\managaproduct.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		ProductDetailDAO dao = new ProductDetailDAO();
		ProductsBO pBo = new ProductsBO();
		HttpSession session = request.getSession();
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
		int sl=Integer.parseInt(amount);
		
		Products products = new Products(idb, IdC, productname, dependency, null, price, dis, idb, idb, sdate, endate, style, sl, address);

		Part filePart = request.getPart("file");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString().trim();
		InputStream fileContent = filePart.getInputStream();
		long time=System.currentTimeMillis();

		String empty = new String();
		if (!fileName.equals(empty)) {
			String appPath = request.getServletContext().getRealPath("");
			appPath = appPath.replace('\\', '/');
			String fullSavePath = null;
			String name=time+fileName;
			if (appPath.endsWith("/")) {
				fullSavePath = appPath + "viewroot/img/shop/product/";
			} else {
				fullSavePath = appPath + "/" + "viewroot/img/shop/product/";
			}
			File file = new File(fullSavePath, name);
			try {
				Files.copy(fileContent, file.toPath());
			} catch (Exception e) {

			}
		}
		products.setAnhChinh(time+fileName);
		pBo.addProducts(products);
		response.sendRedirect("AdminManagaProductController");
	}
	

}
