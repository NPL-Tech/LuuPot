package controller;

import java.io.File;
import java.io.IOException;
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
import dao.ProductsDAO;
import model.Category;
import model.Products;
import model.ProductsDetail;

/**
 * Servlet implementation class AdminProductDetailsController
 */
@WebServlet("/AdminProductDetailsController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AdminProductDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminProductDetailsController() {
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
		String idPD = request.getParameter("id");
		long id = Long.parseLong(idPD);
		ProductsBO productsBO = new ProductsBO();
		HttpSession session = request.getSession();
		List<ProductsDetail> listP = productsBO.getListProductsDetails(id);
		session.setAttribute("idP", id);
		Gson gson = new GsonBuilder().create();
		JsonArray jarray = gson.toJsonTree(listP).getAsJsonArray();
		var jsonObject = new JsonObject();
		jsonObject.add("products", jarray);
		request.setAttribute("jsonProductsD", jarray);
		RequestDispatcher rd = request.getRequestDispatcher("admin\\managadetails.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		ProductDetailDAO dao = new ProductDetailDAO();
		HttpSession session = request.getSession();
		ProductsDAO dao2 = new ProductsDAO();
		Long id_sanpham = (Long) session.getAttribute("idP");

		if (ServletFileUpload.isMultipartContent(request)) {
			List<FileItem> formItems = null;
			try {
				formItems = new ServletFileUpload(new DiskFileItemFactory())
						.parseRequest(new ServletRequestContext(request));
			} catch (FileUploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (formItems != null && formItems.size() > 0) {
				for (FileItem item : formItems) {
					if (!item.isFormField()) {
						// Đường dẫn tuyệt đối tới thư mục gốc của web app.
						String appPath = request.getServletContext().getRealPath("");
						appPath = appPath.replace('\\', '/');
						long time= System.currentTimeMillis();
						
						String fullSavePath = null;
						if (appPath.endsWith("/")) {
							fullSavePath = appPath + "viewroot/img/shop/DetailProduct/";
						} else {
							fullSavePath = appPath + "/" + "viewroot/img/shop/DetailProduct/";
						}
						String fileName = time+ new File(item.getName()).getName();
						File file = new File(fullSavePath, fileName);
						try {
							item.write(file);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ProductsDetail productsDetail = new ProductsDetail();
						productsDetail.setAnhChiTiet(fileName);
						productsDetail.setId_sanPham(id_sanpham);
						dao.addDetailProducts(productsDetail);

					}
				}
				Products p = dao2.getProductsByID(id_sanpham);
				session.removeAttribute("idSanPham");
				ArrayList<ProductsDetail> lstPd = dao.getProductDetailByProductID(id_sanpham);
				request.setAttribute("lstProductDetail", lstPd);
				request.setAttribute("product", p);
				String url="AdminProductDetailsController?id="+id_sanpham;
				response.sendRedirect(url);
			}
		}
	}

}
