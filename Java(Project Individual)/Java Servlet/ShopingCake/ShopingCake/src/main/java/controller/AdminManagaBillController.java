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

import dao.BillsDAO;
import dao.BillsDetailDAO;
import model.BillDetailsFull;
import model.Bills;

/**
 * Servlet implementation class AdminManagaOrderController
 */
@WebServlet("/AdminManagaBillController")
public class AdminManagaBillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminManagaBillController() {
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
		BillsDAO b = new BillsDAO();
		BillsDetailDAO bill=new BillsDetailDAO();
		ArrayList<Bills>	listB = b.getBills();
		 Gson  gson = new GsonBuilder().create();
		JsonArray jarray = gson.toJsonTree(listB).getAsJsonArray();

	        var jsonObject = new JsonObject();
	        jsonObject.add("products", jarray);

	        request.setAttribute("jsonBills", jarray);
	        
		RequestDispatcher rd = request.getRequestDispatcher("admin\\managabills.jsp");
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
