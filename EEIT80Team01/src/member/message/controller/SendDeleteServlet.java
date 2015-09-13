package member.message.controller;

import global.GlobalService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.MemberBean;
import member.model.MessageBean;
import member.model.MessageService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/member/message/senddelete")
public class SendDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SendDeleteServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd =  request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberBean bean = (MemberBean)session.getAttribute(GlobalService.LOGIN_TOKEN);
		String sender = bean.getUserName();
		
		String[] messageNumbers = request.getParameterValues("messageNumber");
		MessageService service = new MessageService();
		for(String Number: messageNumbers){
			Long messageNumber = Long.parseLong(Number);
			MessageBean mb = service.findMessageByMessageno(messageNumber);
			if(mb.getSender().equals(sender)){
				int visibiblty = mb.getVisibility()|2;
				service.changeVisibility(visibiblty, messageNumber);
			}
		}
		
		response.sendRedirect("send");
	}

}
