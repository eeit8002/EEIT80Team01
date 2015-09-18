package question.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.GlobalService;
import member.model.MemberBean;
import question.model.QuestionBean;
import question.model.QuestionService;

@WebServlet("/member/question/memberListUnAnsweredQuestionServlet.jsp")
public class MemberListUnAnsweredQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberListUnAnsweredQuestionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberBean mb = (MemberBean) session.getAttribute(GlobalService.LOGIN_TOKEN);
		if (mb != null) {
			String member = mb.getUserName();
			QuestionService service = new QuestionService();
			List<QuestionBean> list = service.memberListUnAnsweredQuestions(member);
			request.setAttribute("UnAnsweredQuestions", list);
			RequestDispatcher rd = request.getRequestDispatcher("/member/question/UnAnsweredQuestions.jsp");
			rd.forward(request, response);
			return;
		} else {
			response.sendRedirect("/index.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
