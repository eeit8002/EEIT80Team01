package support.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import support.model.SupportBean;
import support.model.SupportService;

@WebServlet("/support/manage/listMembers.jsp")
public class SupporterListMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SupporterListMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		SupportService service = new SupportService();
		List<SupportBean> list = service.findAllSupporters();
		if (list != null) {
			RequestDispatcher rd = request.getRequestDispatcher("showMembersList.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
			return;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/support/index.jsp");
			rd.forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
