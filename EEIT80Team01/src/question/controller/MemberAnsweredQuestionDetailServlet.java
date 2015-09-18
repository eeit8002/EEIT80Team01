package question.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import question.model.QuestionBean;
import question.model.QuestionService;

@WebServlet("/member/question/memberAnsweredQuestionDetailServlet.do")
public class MemberAnsweredQuestionDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberAnsweredQuestionDetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		int qno = Integer.parseInt(request.getParameter("qno"));
		String member = request.getParameter("member");
		QuestionService service = new QuestionService();
		QuestionBean qb = service.memberAnsweredQuestionDetail(member, qno);
		if (request.getAttribute("AnsweredQuestion") != null) {
			request.removeAttribute("AnsweredQuestion");
		}
		if (qb != null) {
			request.setAttribute("AnsweredQuestion", qb);
			RequestDispatcher rd = request.getRequestDispatcher("AnsweredQuestionDetail.jsp");
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
