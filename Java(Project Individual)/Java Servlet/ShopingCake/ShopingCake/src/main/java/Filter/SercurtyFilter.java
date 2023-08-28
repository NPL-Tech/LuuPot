package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Users;

import javax.servlet.http.*;

public class SercurtyFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		String servletPath = request.getServletPath();
		boolean isStaticResource = request.getRequestURI().startsWith("/viewroot/");
		boolean isAdmin = request.getRequestURI().startsWith("/admin/viewroot/");
		HttpServletRequest wrapRequest = request;

		String url = request.getRequestURI();
		if (!ErrorServlet(request, response, response.getStatus())) {
			response.sendRedirect("login.jsp");
			filterChain.doFilter(wrapRequest, response);
			return;
		}
		if (url.indexOf("/viewroot") > 0 || url.indexOf("/admin/viewroot/") > 0) {
			filterChain.doFilter(request, response);
		}

		String[] listpath = { "/Home", "/HomeProductsServlet", "/blog.jsp", "/contact.jsp", "/login.jsp",
				"/UsersLoginServlet", "/shoping-cart.jsp","/HomeCartServlet" ,"/HomeSearchProduct","/UsersRegisterServlet","/HomeProductsDetail"};
		String[] listpathUser = { "/HomeUserProfileServlet", "/UserEditAvata", "/HomeProfileServlet","/account.jsp",
				"/checkout.jsp","/HomeCheckoutServlet", "/HomeBillServlet","/UsersLogoutServlet"};
		String[] listPathAdmin = { "/AdminAddCategory","/AdminAddDetailProduct","/AdminBillsController","/AdminChangeRoleController","/AdminController","/AdminEditProductController",
				"/AdminDeleteCategory","/AdminDeleteProductDetail","/AdminDeleteProducts","/AdminDeleteUser","/AdminEditProductController","/AdminManagaBillController"
				,"/AdminManagaCategoryController","/AdminManagaProductController","/AdminManagaTransportController","/AdminManagaUserController","/AdminManageOrderController","/AdminMangageBrandController",
				"/AdminOrderController","/AdminProductDetailsController","/AdminProfileController","/AdminTransportController","/UsersLogoutServlet","/AdminOrderCancelController"};
		for (String path : listpath) {
			if (servletPath.equals(path)) {
				filterChain.doFilter(request, response);
				break;
			}
		}
		Users loginedUser = (Users) session.getAttribute("uslogin");
		if (loginedUser != null) {
			if (loginedUser.getPhanQuyen().equals("0")) {
				for (String pathUser : listpathUser) {
					if (servletPath.equals(pathUser)) {
						filterChain.doFilter(request, response);
						break;
					}

				}
			} else if (loginedUser.getPhanQuyen().equals("1")) {
				for (String pathAdmin : listPathAdmin) {
					if (servletPath.equals(pathAdmin)) {
						filterChain.doFilter(request, response);
						break;

					}
				}
			} else {
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.sendRedirect("/login.jsp");
			}
		} else {
		}

	}

	public boolean ErrorServlet(HttpServletRequest request, HttpServletResponse response, int statusCode) {
		HttpSession session = request.getSession();
		if (statusCode > 0) {
			String error = "";
			String codeError = "";
			if (statusCode == 404) {
				error = "Lỗi 404 Not Found là  bạn cố gắng truy cập vào một trang web (đường link ) đã không còn tồn tại.";
				session.setAttribute("msgerror", error);
				codeError = "404";
				session.setAttribute("codeError", codeError);
				return false;
			} else if (statusCode == 500) {
				error = "Lỗi 500 Internal Server Error:Tạm thời không truy cập được trang web";
				session.setAttribute("msgerror", error);
				codeError = "500";

				session.setAttribute("codeError", codeError);
				return false;
			} else if (statusCode == 405) {
				error = "HTTP Error 405 Method Not Allowed:Request method không được hỗ trợ cho các tài nguyên được yêu cầu";
				session.setAttribute("msgerror", error);
				codeError = "405 ";
				session.setAttribute("codeError", codeError);
				return false;
			} else if (statusCode == 415) {
				error = "HTTP 415 Unsupported Media Type:Server sẽ không chấp nhận Request, bởi vì kiểu phương tiện không được hỗ trợ.";
				session.setAttribute("msgerror", error);
				codeError = "415 ";
				session.setAttribute("codeError", codeError);
				return false;

			}

		}
		return true;
	}

	@Override
	public void destroy() {

	}
}
