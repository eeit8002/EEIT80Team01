package admin.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.AdminBean;
import admin.model.AdminDAO;
import admin.model.dao.AdminDAOJdbc;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("Don't try attack this server !!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		response.setContentType("text/html");
		String userName = request.getParameter("UserName");
		String passwd = request.getParameter("Password");

		AdminDAO adminDAO = new AdminDAOJdbc();
		AdminBean bean = adminDAO.select(userName);
		String userNameFromSQL = bean.getUserName();
		String passwdFromSQL = bean.getPasswd();
		if (userName.equals(userNameFromSQL) && passwd.equals(passwdFromSQL)) {
			int permission = bean.getPermission();
			if (permission == 1) {
				Cookie adminCookie = new Cookie("adminCookie", userName);
				adminCookie.setMaxAge(60 * 60 * 24);
				response.addCookie(adminCookie);
				response.sendRedirect("input a jsp page here"); // <-- admin login success, redirect to system manage page.
			} else if (permission == 0) {
				Cookie supportCookie = new Cookie("supportCookie",userName);
				supportCookie.setMaxAge(60 * 60 * 24);
				response.addCookie(supportCookie);
				response.sendRedirect("input a jsp page here"); // <-- supporter login success, redirect to memeber manage page.
			}
		}
	}
}
/*
 * http://www.java2s.com/Tutorial/Java/0400__Servlet/ServletLogin.htm
 * http://crunchify.com/how-to-do-java-servlet-session-management-using-cookies/
 */