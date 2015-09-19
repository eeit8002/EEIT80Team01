package question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.GlobalService;
import member.model.MemberBean;
import question.model.QuestionService;

@WebServlet("/member/question/createQuestion.do")
public class MemberAskQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberAskQuestionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		MemberBean mb = (MemberBean) session.getAttribute(GlobalService.LOGIN_TOKEN);
		String member = mb.getUserName();
		String qmsg = request.getParameter("qmsg");
		String title = request.getParameter("qtitle");
		
		QuestionService service = new QuestionService();
		boolean result = service.memberAskQuestion(member, title, qmsg);
		
		if (result) {
			response.sendRedirect("/member/question/AskQuestionSuccess.jsp");
			return;
		} else {
			response.sendRedirect("/member/question/AskQuestionFailed.jsp");
			return;
		}
		
	}

}
