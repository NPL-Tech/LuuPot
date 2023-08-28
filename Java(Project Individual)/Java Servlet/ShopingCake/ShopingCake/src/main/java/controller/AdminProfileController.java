package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import dao.UsersDAO;
import model.Users;

/**
 * Servlet implementation class AdminProfileController
 */
@WebServlet("/AdminProfileController")
public class AdminProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProfileController() {
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
		RequestDispatcher rd = request.getRequestDispatcher("admin\\adminprofile.jsp");
		rd.forward(request, response);	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("uslogin");
		UsersDAO dao= new UsersDAO();
		String username = request.getParameter("username");
		String passold = request.getParameter("pass-old");
		String passnew = request.getParameter("pass-new");
		if(user.getTenTaiKhoan().equals(username)&&user.getMatKhau().equals(passold)) {
			user.setMatKhau(passnew);
			user.setTenTaiKhoan(username);
			try {
				dao.updateUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("mess", "thảy đổi thành công ");

			
		}else {
			session.setAttribute("mess", "thông báo lỗi");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("admin\\adminprofile.jsp");
		rd.forward(request, response);	
	}

}
