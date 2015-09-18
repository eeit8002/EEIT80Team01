package support.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.GlobalService;
import support.model.SupportBean;
import support.model.SupportService;

@WebServlet("/support/password/supportChangePassword.do")
public class SupportChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SupportChangePasswordServlet() {
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
		SupportBean bean = (SupportBean) session.getAttribute(GlobalService.LOGIN_TOKEN_SUPPORT);
		String supportername = request.getParameter("username");
		String oldpassword = request.getParameter("oldpassword");
		String password = request.getParameter("password");
		if (password != null && password.length()>=5){
			bean.setPassword(GlobalService.getMD5Encoding(password));
		}
		
		SupportBean sb = new SupportBean();
		SupportService service = new SupportService();
		sb = service.supporterCheckSupporterNamePassword(supportername, oldpassword);
		
		if(bean != null && sb != null){
			service.changeSupporterPassword(bean);
			RequestDispatcher rd = request.getRequestDispatcher("/support/password/success.jsp");
			session.removeAttribute(GlobalService.LOGIN_TOKEN_SUPPORT);
			session.setAttribute(GlobalService.LOGIN_TOKEN_SUPPORT, bean);
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/support/index.jsp");
			rd.forward(request, response);
		}
	}
}
