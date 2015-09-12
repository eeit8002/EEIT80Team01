package admin.supporter.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import support.model.SupportBean;
import support.model.SupportDAO;
import support.model.dao.SupportDAOJdbc;

@WebServlet("/admin/manage/listSupporters.jsp")
public class AdminManageSupporterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminManageSupporterServlet() {
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
		String action = request.getParameter("action");

		// list all supporters
		if (action.equals("ListAll")) {
			SupportDAO dao = new SupportDAOJdbc();
			List<SupportBean> supporterlist = dao.select();
			HttpSession session = request.getSession();
			session.setAttribute("supporterlist", supporterlist);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/manage/ManageSupporters.jsp");
			rd.forward(request, response);
			return;
		}

		if (action.equals("Delete")){
			SupportDAO dao = new SupportDAOJdbc();
			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("ErrorMsgs",errorMsgs);
			String employeeid = request.getParameter("employeeid");
			if (employeeid == null || (employeeid.trim().length()==0)){
				errorMsgs.add("請輸入客服編號");
			}
			if (!errorMsgs.isEmpty()){
				RequestDispatcher rd = request.getRequestDispatcher("/admin/manage/ManageSupporters.jsp");
				rd.forward(request, response);
				return;
			}
			
		}
	}

}
