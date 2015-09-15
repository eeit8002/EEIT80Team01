package admin.support.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import support.model.SupportService;

@WebServlet("/admin/manage/deleteSupporterAccounts.jsp")
public class AdminDeleteSupporterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminDeleteSupporterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/admin/index.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String[] supportaccounts = request.getParameterValues("supporterChecked"); // ParameterValues from <input type="checkbox" name="supporterChecked" value="${item.supportername}">
		SupportService service = new SupportService();
		if(supportaccounts!=null && supportaccounts.length>0){
			service.deleteSupporterAccounts(supportaccounts);
		}
		response.sendRedirect("listSupporters.jsp"); //reload AdminListSupporterServlet.java again to get new supporter account list
	}

}
