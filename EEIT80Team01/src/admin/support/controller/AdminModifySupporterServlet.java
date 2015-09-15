package admin.support.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

		String supportername = request.getParameter("supportername");
		String password = request.getParameter("password");
		String passwordCheck = request.getParameter("passwordCheck");
		String employeeid = request.getParameter("employeeid");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");

		SupportBean bean = new SupportBean();
		Map<String, String> errorMsgs = new HashMap<String, String>();
		SupportService service = new SupportService();

		if (supportername == null || supportername.trim().length() == 0) {
			errorMsgs.put("supporternameError", "請輸入帳號");
		} else if (service.checkSupporterAccountExist(supportername)) {
			errorMsgs.put("supporternameError", "帳號名稱重複");
		}
		if (password == null || password.trim().length() == 0) {
			errorMsgs.put("passwordError", "請輸入密碼");
		} else if (password.trim().length() < 5) {
			errorMsgs.put("passwordError", "密碼長度不足5");
		} else if (!password.equals(passwordCheck)) {
			errorMsgs.put("passwordError", "密碼不一致");
		}
		if (employeeid == null || employeeid.trim().length() == 0) {
			errorMsgs.put("employeeidError", "請輸入客服編號");
		} else if (service.checkEmployeeIDExist(employeeid)) {
			errorMsgs.put("employeeidError", "客服編號重複");
		}
		if (firstname == null || firstname.trim().length() == 0) {
			errorMsgs.put("firstnameError", "請輸入名字");
		}
		if (lastname == null || lastname.trim().length() == 0) {
			errorMsgs.put("lastnameError", "請輸入姓氏");
		}

		if (errorMsgs.isEmpty()) {
			bean.setSupportername(supportername);
			bean.setPassword(password);
			bean.setEmployeeid(employeeid);
			bean.setFirstname(firstname);
			bean.setLastname(lastname);
			if (service.updateSupporterAccountInfo(bean)) {
				RequestDispatcher rd = request.getRequestDispatcher("/admin/manage/listSupporters.jsp");
				// call AdminListSupporterServlet.java to reload supporter list
				// again
				rd.forward(request, response);
				return;
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/admin/manage/modifySupporterFailed.jsp");
				rd.forward(request, response);
				return;
			}
		} else {
			request.setAttribute("ErrorMsgs", errorMsgs);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/manage/modifySupporter.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
