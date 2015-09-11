package member.changedata.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.FindPwService;


@WebServlet("/service/findpassword")
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FindPasswordServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		FindPwService service = new FindPwService();
		if(username!=null && pass!=null){
			if(service.validateData(username, pass)){
				HttpSession session = request.getSession();
				session.setAttribute("EmailChecked", username);
				service.deleteLog(username);			
				RequestDispatcher rd = request.getRequestDispatcher("changePassword.jsp");
				rd.forward(request, response);
				
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("illeagallink.jsp");
				service.deleteLog(username);
				rd.forward(request, response);				
			}
		} else{
			RequestDispatcher rd = request.getRequestDispatcher("illeagallink.jsp");
			rd.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
