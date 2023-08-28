package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.CategoryBO;
import BO.ProductsBO;
import model.Products;

/**
 * Servlet implementation class HomeProductsServlet
 */
public class HomeProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeProductsServlet() {
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
		String idLoaiSp = request.getParameter("id_category");
		String search = request.getParameter("search");
		String page = request.getParameter("page");
		String key = request.getParameter("key");
		ArrayList<Products> lstP = null;
		lstP = p.getListProducts();
		if (idLoaiSp != null) {
			lstP = p.getProductsByCategory(idLoaiSp);
		}
		if (search != null) {
			lstP = p.getProductsByName(key);
		}
		if (page != null) {
			int number = Integer.parseInt(page);
			lstP = p.getProductPage(number);
		}else if(idLoaiSp==null) {
			int number = 0;
			lstP = p.getProductPage(number);
		}
		ArrayList<Products> lstallProduct= p.getListProducts();
		ArrayList<Integer> list = p.getPage();
		request.setAttribute("page", list);
		request.setAttribute("lstProducts", lstP);
		request.setAttribute("listsC", lstallProduct);

		request.setAttribute("lstCategory", c.getListCategory());
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
