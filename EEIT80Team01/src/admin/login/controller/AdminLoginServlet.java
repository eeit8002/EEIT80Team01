package admin.login.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.AdminBean;
import admin.model.AdminService;

//@WebServlet("/admin/login/login.do")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// String rm = request.getParameter("rememberMe");
		String requestURI = (String) session.getAttribute("requestURI");

		if (username == null || username.trim().length() == 0) {
			errorMsgMap.put("AccountEmptyError", "帳號為必填欄位");
		}
		if (password == null || password.trim().length() == 0) {
			errorMsgMap.put("PasswordEmptyError", "密碼為必填欄位");
		}

		if (!errorMsgMap.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
		AdminService service = new AdminService();
		AdminBean ab = service.adminCheckUsernamePassword(username.toLowerCase(), password);
		if (ab != null) {
			session.setAttribute("LoginOK", ab);
		} else {
			errorMsgMap.put("LoginError", "帳號不存在或密碼錯誤");
		}
		if (errorMsgMap.isEmpty()) {
			if (requestURI != null) {
				requestURI = (requestURI.length() == 0 ? request.getContextPath() : requestURI);
				response.sendRedirect(response.encodeRedirectURL(requestURI));
				return;
			} else {
				response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/admin/index.jsp"));
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
	}
}