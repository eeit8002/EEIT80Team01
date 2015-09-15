package member.core.controller;

import global.GlobalService;
import global.XSSValidate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import support.model.ReportBean;
import support.model.ReportService;
import member.model.MemberBean;
import member.model.MemberService;


@WebServlet("/member/report/report")
public class ReportMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReportMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		MemberBean bean = (MemberBean) session.getAttribute(GlobalService.LOGIN_TOKEN);
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		String username = request.getParameter("username");
		MemberService ms = new MemberService();
		if(ms.accountCheck(username)){
			errorMsgMap.put("username", "查無此人");
		}
		ReportBean rb = new ReportBean();
		rb.setUsername(username);
		rb.setProsecutor(bean.getUserName());
		XSSValidate xss = new XSSValidate();
		String url = request.getParameter("url");
		if(url==null || url.length()==0|| xss.validate(url)){
			errorMsgMap.put("url", "無效的網址");
		}		
		rb.setUrl(url);
		String reason = request.getParameter("reason");
		if(reason==null || reason.length()==0){
			errorMsgMap.put("reason", "需要檢舉理由");
		} else if(xss.validate(reason)){
			errorMsgMap.put("reason", "內容有非法字元");
		}		
		rb.setReason(reason);;
		
		if(!errorMsgMap.isEmpty()){
			request.setAttribute("ErrorMsgKey", errorMsgMap);
			RequestDispatcher rd =  request.getRequestDispatcher("report.jsp");
			rd.forward(request, response);
			return;			
		}
		
		ReportService rs = new ReportService();
		if(rs.Report(rb)){
			request.setAttribute("success", "你的檢舉已發出");
			RequestDispatcher rd =  request.getRequestDispatcher("report.jsp");
			rd.forward(request, response);
			return;				
		}
	
	}

}
