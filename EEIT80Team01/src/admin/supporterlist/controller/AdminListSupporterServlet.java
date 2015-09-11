package admin.supporterlist.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import support.model.SupportBean;
import support.model.SupportDAO;
import support.model.dao.SupportDAOJdbc;

@WebServlet("/EEIT80Team01/admin/manage/listSupporters.jsp")
public class AdminListSupporterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminListSupporterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SupportBean> supporterlist = new ArrayList<SupportBean>();
		SupportDAO dao = new SupportDAOJdbc();
		supporterlist = dao.select();
		request.setAttribute("supporterlist", supporterlist);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/manage/ManageSupporters.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
