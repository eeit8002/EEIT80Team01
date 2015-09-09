package member.register.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import member.model.MemberBean;
import member.model.MemberService;
import member.register.DateValidator;
import member.register.EmailValidator;
import member.register.IDChecker;


@WebServlet("/register/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RegisterServlet() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		MemberBean bean = new MemberBean();
		MemberService service = new MemberService();
		String username = request.getParameter("username");
		if(username!=null && service.accountCheck(username)){
			bean.setUserName(username.toUpperCase());
			String password = request.getParameter("password");
			if(password!=null && password.length()>=5){
				bean.setPassword(password);
				String id = request.getParameter("id");
				IDChecker check = new IDChecker(id);
				if(id!=null && check.CheakID() && service.idCheck(id)){
					bean.setId(id);
					String firstName = request.getParameter("firstName");
					if(firstName!=null){
						bean.setFirstName(firstName);
						String lastName = request.getParameter("lastName");
						if(lastName!=null){
							bean.setLastName(lastName);
							String email = request.getParameter("email");
							EmailValidator emailcheck = new EmailValidator();
							if(email!=null && emailcheck.validate(email));{
								bean.setEmail(email);
								String birthDay = request.getParameter("birthDay");
								SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
								DateValidator datecheck = new DateValidator();
								if(birthDay!=null && datecheck.validate(birthDay)){
									try {
										bean.setBirthDay(sdf.parse(birthDay));
									} catch (ParseException e) {
										e.printStackTrace();
									}
									
									int gender = Integer.parseInt(request.getParameter("gender"));
									if(gender==0 || gender==1){
										bean.setGender(gender);
										bean.setAccess(0);
										bean.setCertified(0);
										MemberBean result = service.register(bean);
										if(result!=null && result.getUserName().toUpperCase().equals(bean.getUserName().toUpperCase())){
											RequestDispatcher rd = request.getRequestDispatcher("/register/success.jsp");									
											rd.forward(request,response);
										}							
									}									
								}								
							}							
						}						
					}					
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("/register/register.jsp");
				rd.forward(request,response);
				return;
				
			}
			
		};
		
	}

}
