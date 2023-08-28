package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.CategoryBO;
import BO.ProductsBO;
import model.Products;

/**
 * Servlet implementation class HomeSearchProduct
 */
public class HomeSearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeSearchProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		ProductsBO p = new ProductsBO();
		CategoryBO c = new CategoryBO();

		String search = request.getParameter("search");
		String key = request.getParameter("key");
		ArrayList<Products> lstP = new ArrayList<Products>();

		if (key != null) {
			lstP = p.getProductsByName(key);
		}
		ArrayList<Products> lstallProduct= p.getListProducts();
		request.setAttribute("listsC", lstallProduct);
		ArrayList<Integer> list = p.getPage();
		request.setAttribute("page", list);
		request.setAttribute("lstCategory", c.getListCategory());
		request.setAttribute("lstProducts", lstP);
		RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
