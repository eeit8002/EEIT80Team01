package member.message.controller;

import global.GlobalService;

import java.io.IOException;
import java.util.List;

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


@WebServlet("/member/message/receive")
public class ReceiverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReceiverServlet() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberBean mb = (MemberBean)session.getAttribute(GlobalService.LOGIN_TOKEN);
		String receiver = mb.getUserName();
		MessageService service = new MessageService();
		List<MessageBean> list = service.findByReceiver(receiver);
		if(list!=null){
			RequestDispatcher rd =  request.getRequestDispatcher("receive.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
			return;
		} else {
			RequestDispatcher rd =  request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd =  request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		return;	
	}

}
