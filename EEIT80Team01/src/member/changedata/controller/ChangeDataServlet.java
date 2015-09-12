package member.changedata.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.core.EmailValidator;
import member.model.MemberBean;
import member.model.MemberService;


@WebServlet("/member/changeData")
public class ChangeDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ChangeDataServlet() {
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
		MemberBean bean = (MemberBean) session.getAttribute("LoginOK");
		String firstName = request.getParameter("fistName");
		if(firstName!=null){
			bean.setFirstName(firstName);
		}
		String lastName = request.getParameter("lastName");
		if(lastName!=null){
			bean.setLastName(lastName);
		}
		String email = request.getParameter("email");
		EmailValidator emailcheck = new EmailValidator();
		if(email!=null && emailcheck.validate(email)){
			bean.setEmail(email);
		}
		MemberService service = new MemberService();
		service.changeMemberData(bean);
		
		if(bean!=null){
			RequestDispatcher rd = request.getRequestDispatcher("/member/finished.jsp");
			session.removeAttribute("LoginOK");
			session.setAttribute("LoginOK", bean);
			rd.forward(request,response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/member/changeMemberData.jsp");
			rd.forward(request,response);
		}
		
	}

}
