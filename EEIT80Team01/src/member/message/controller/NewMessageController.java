package member.message.controller;

import global.XSSValidate;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.MemberBean;
import member.model.MemberService;
import member.model.MessageBean;
import member.model.MessageService;



@WebServlet("/member/message/newmessage")
public class NewMessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NewMessageController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		HttpSession session = request.getSession();
		MemberBean bean = (MemberBean)session.getAttribute("LoginOK");
		if(bean==null){
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("errorMessage", "您尚未登入");
			rd.forward(request, response);
			return;
		} 
		
			MemberService ms = new MemberService();
			MessageBean mb = new MessageBean();
			mb.setSender(bean.getUserName());
			String receiver = request.getParameter("receiver");
			if(receiver==null || ms.findMemberData(receiver)==null){
				errorMsgMap.put("receiver", "查無此帳號");
			}
			mb.setReceiver(receiver);
			String messageTitle = request.getParameter("messagetitle");
			XSSValidate xss = new XSSValidate();
			if(messageTitle==null){
				errorMsgMap.put("title", "標題不得為空");			
			} else if(xss.validate(messageTitle)){
				errorMsgMap.put("title", "標題內不得有script語法");	
			} else {
				mb.setMessageTitle(messageTitle);
			}
			
			String messageBody = request.getParameter("messagebody");
			if(messageBody==null){
				errorMsgMap.put("body", "內文不得為空");			
			} else if(xss.validate(messageBody)){
				errorMsgMap.put("body", "內文中不得有script語法");	
			} else {
				mb.setMessageTitle(messageBody);
			}
			
			if(!errorMsgMap.isEmpty()){
				RequestDispatcher rd =  request.getRequestDispatcher("send.jsp");
				rd.forward(request, response);
				return;
			}
			Date date = new Date();
			mb.setMessageTime(date);
			MessageService service = new MessageService();
			mb = service.addNewMessage(mb);
			if(mb!=null){
				RequestDispatcher rd =  request.getRequestDispatcher("sandmessage.jsp");
				request.setAttribute("successMessage", "訊息傳送成功");
				rd.forward(request, response);
				return;	
			} else {
				RequestDispatcher rd =  request.getRequestDispatcher("sandmessage.jsp");
				request.setAttribute("errorMessage", "訊息傳送失敗");
				rd.forward(request, response);
			}
			
			
			
			
		
		
	}

}
