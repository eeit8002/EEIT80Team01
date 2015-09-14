package admin.support.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import support.model.SupportBean;
import support.model.SupportService;

@WebServlet("/admin/manage/modifySupporter.do")
public class AdminModifySupporterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminModifySupporterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if (request.getAttribute("supporterInfo") != null) {
			request.removeAttribute("supporterInfo");
		}
		String supportername = request.getParameter("supportername");
		SupportService service = new SupportService();
		request.setAttribute("supporterInfo", service.select(supportername));
		RequestDispatcher rd = request.getRequestDispatcher("/admin/manage/modifySupporter.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String supportername = (String) request.getAttribute("supportername");
		String password = (String) request.getAttribute("password");
		String employeeid = (String) request.getAttribute("employeeid");
		String firstname = (String) request.getAttribute("firstname");
		String lastname = (String) request.getAttribute("lastname");
		SupportBean bean = new SupportBean();
		bean.setSupportername(supportername);
		bean.setPassword(password);
		bean.setEmployeeid(employeeid);
		bean.setFirstname(firstname);
		bean.setLastname(lastname);
		SupportService service = new SupportService();
		if (service.updateSupporterAccountInfo(bean)) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/manage/showSupportersList.jsp");
			rd.forward(request, response);
			return;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/index.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
