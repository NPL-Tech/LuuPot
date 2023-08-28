package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dao.CategoryDAO;
import model.Category;

/**
 * Servlet implementation class AdminMangageBrandController
 */
@WebServlet("/AdminMangageBrandController")
public class AdminMangageBrandController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMangageBrandController() {
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
		CategoryDAO dao = new CategoryDAO();
		ArrayList<Category>	listC = dao.getListBrand();
		 Gson  gson = new GsonBuilder().create();
		JsonArray jarray = gson.toJsonTree(listC).getAsJsonArray();
	        var jsonObject = new JsonObject();
	        jsonObject.add("products", jarray);
	        request.setAttribute("jsonBrand", jarray);
	        
		RequestDispatcher rd = request.getRequestDispatcher("admin\\managebrand.jsp");
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String brand= request.getParameter("val-brand");
		CategoryDAO dao = new CategoryDAO();
		Category ca = new Category();
		ca.setTenLoaiSanPham(brand);
		ca.setTheloai("true");
		dao.addCategory(ca);
		response.sendRedirect("AdminMangageBrandController");
		
	}

}
