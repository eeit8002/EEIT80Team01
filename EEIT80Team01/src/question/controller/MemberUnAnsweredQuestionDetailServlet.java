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

@WebServlet("/member/question/memberUnAnsweredQuestionDetailServlet.do")
public class MemberUnAnsweredQuestionDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUnAnsweredQuestionDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		if (request.getAttribute("questionDetail") != null) {
			request.removeAttribute("questionDetail");
		}
		
		int qno = Integer.parseInt(request.getParameter("qno"));
		String member = request.getParameter("member");
		QuestionService service = new QuestionService();
		QuestionBean qb = service.memberUnansweredQuestionDetail(member, qno);
		if (qb.getQmsg() != null || qb.getQmsg().trim().length() != 0) {
			request.setAttribute("questionDetail", qb);
			RequestDispatcher rd = request.getRequestDispatcher("UnAnsweredQuestionDetail.jsp");
			rd.forward(request, response);
			return;
		} else {
			response.sendRedirect("/support/index.jsp");
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
