package member.changedata.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberBean;
import member.model.MemberService;


@WebServlet("/service/resetPassword")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ResetPasswordServlet() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		MemberService service = new MemberService();
		String username = request.getParameter("username").toLowerCase();
		MemberBean bean = service.findMemberData(username);		
		String password = request.getParameter("password");
		boolean result = false;
		if(password!=null && password.length() >= 5){
			result = service.changePassword(username, password);
		}
		
		
		
		if(result){
			RequestDispatcher rd = request.getRequestDispatcher("/service/finished.jsp");
			request.setAttribute("message", "密碼變更完成");
			rd.forward(request,response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/service/finished.jsp");
			request.setAttribute("message", "密碼變更失敗");
			rd.forward(request,response);
		}
		
	}
	

}
