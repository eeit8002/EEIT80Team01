package member.changedata.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.changedata.SendEmail;
import member.model.FindPwBean;
import member.model.FindPwService;
import member.model.MemberBean;
import member.model.MemberService;


@WebServlet("/service/forgetpassword")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ForgetPasswordServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username").toLowerCase();
		String email = request.getParameter("email");
		if(username!=null && email!=null){
			MemberService ms = new MemberService();
			MemberBean mb = ms.findMemberData(username);
			if(mb!=null && email.equals(mb.getEmail())){
				FindPwService fs = new FindPwService();
				FindPwBean fb = fs.writeLog(username);
				StringBuilder sb = new StringBuilder();
				sb.append(request.getScheme());
				sb.append("://");
				sb.append(request.getServerName());
				if(request.getServerPort()!=80){
					sb.append(":");
					sb.append(request.getServerPort());
				}
				sb.append(request.getContextPath());
				String url = fs.bulidUrl(sb.toString(), fb);//將url以信件送出
				boolean result = SendEmail.sendemail(email, url);
				if(result==true){
					RequestDispatcher rd = request.getRequestDispatcher("/service/forgetpassword.jsp");
					request.setAttribute("message", "您的重設信件已送出，請置電子郵件信箱查看");
					rd.forward(request,response);
					return;
				}
				
			}
		}
			RequestDispatcher rd = request.getRequestDispatcher("/service/forgetpassword.jsp");
			request.setAttribute("message", "信件無法送出，請確認您的帳號以及電子郵件信箱");
			rd.forward(request,response);
		
	}

}
