package question.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.GlobalService;
import question.model.QuestionService;
import support.model.SupportBean;

@WebServlet("/support/manage/question/supporterAnswerQuestion.do")
public class SupporterAnswerQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SupporterAnswerQuestionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		SupportBean sb = (SupportBean) session.getAttribute(GlobalService.LOGIN_TOKEN_SUPPORT);
		String supporter = sb.getSupportername();
		String amsg = request.getParameter("answer");
		int qno = Integer.parseInt(request.getParameter("hiddenqno"));
		
		QuestionService service = new QuestionService();
		boolean result = service.supporterAnswerQuestion(qno, supporter, amsg);
		if (result){
			RequestDispatcher rd = request.getRequestDispatcher("/support/manage/question/listUnansweredQuestionsServlet.jsp");
			rd.forward(request, response);
			return;
		} else {
			response.sendRedirect("/support/index.jsp");
			return;
		}
	}

}
