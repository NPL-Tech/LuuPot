package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.CategoryBO;
import BO.ProductDetailBO;
import BO.ProductsBO;
import model.Category;
import model.Products;
import model.ProductsDetail;

/**
 * Servlet implementation class HomeProductsDetail
 */
@WebServlet("/HomeProductsDetail")
public class HomeProductsDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeProductsDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		 long id = Long.parseLong(request.getParameter("id"));

			ProductsBO productControl = new ProductsBO();
			ProductDetailBO productDetailBO = new ProductDetailBO();
			ArrayList<ProductsDetail> list= productDetailBO.getProductDetailByProductID(id);
			Products product = productControl.getProductsByID(id);

			request.setAttribute("product", product);
			request.setAttribute("listDetails", list);


			CategoryBO categoryControl = new CategoryBO();
			ArrayList<Category> listCategory = categoryControl.getListCategory();
			request.setAttribute("listCategory", listCategory);
			ProductsBO p= new ProductsBO();
			ArrayList<Products> lstallProduct= p.getListProducts();
			request.setAttribute("listp", lstallProduct);


		RequestDispatcher dispatcher = request.getRequestDispatcher("product-details.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
