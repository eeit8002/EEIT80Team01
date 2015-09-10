package admin.changepassword.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.AdminBean;
import admin.model.AdminService;
import global.GlobalService;

@WebServlet("/admin/password/adminChangePassword.do")
public class adminChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public adminChangePassword() {
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
		AdminBean bean = (AdminBean) session.getAttribute("LoginOK");
		String adminname = request.getParameter("adminname");
		String oldpassword = request.getParameter("oldpassword");
		String password = request.getParameter("password");
		if (password != null && password.length() >= 5) {
			bean.setPasswd(GlobalService.getMD5Endocing(password));
		}
		
		AdminBean ab = new AdminBean();
		AdminService service = new AdminService();
		ab = service.adminCheckadminnamePassword(adminname, oldpassword);
		
		service.changeAdminPassword(bean);

		if (bean != null && ab != null) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/admin/password/success.jsp");
			session.removeAttribute("LoginOK");
			session.setAttribute("LoginOK", bean);
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/index.jsp");
			rd.forward(request, response);
		}
	}

}
