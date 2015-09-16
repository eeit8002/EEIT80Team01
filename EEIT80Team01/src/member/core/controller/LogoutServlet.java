package member.core.controller;

import global.GlobalService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.MemberBean;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/login/logout.jsp")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LogoutServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberBean bean = (MemberBean)session.getAttribute(GlobalService.LOGIN_TOKEN);
		session.removeAttribute(GlobalService.LOGIN_TOKEN);
		session.removeAttribute("ShoppingCart");
		session.setAttribute("Logout", bean);
		response.sendRedirect(request.getContextPath()+"/login/login.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberBean bean = (MemberBean)session.getAttribute(GlobalService.LOGIN_TOKEN);
		session.removeAttribute(GlobalService.LOGIN_TOKEN);
		session.removeAttribute("ShoppingCart");
		session.setAttribute("Logout", bean);
		response.sendRedirect(request.getContextPath()+"/login/login.jsp");
	}

}
