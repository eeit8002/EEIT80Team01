package search.model;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.naming.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;
@WebServlet("/search/queryAllMembers.do")//ch04/ex04/queryAllMembers.do
public class RegisterService extends HttpServlet{
	private static final long serialVersionUID = 1L;//加的
	
	
	
	static private List<String> memberIDList = new ArrayList<String>();
	Context ctx;
		public RegisterService() throws IOException {
		
			super();//加的
		try {
			ctx = new InitialContext();
		} catch (NamingException e) {
			// TODO 自動產生 catch 區塊
			e.printStackTrace();
		}
	}
		Connection conn = null;
		Collection<Member> allMembers = new ArrayList<Member>();
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String keyword = request.getParameter("keyword");
			String option = request.getParameter("option");//取下拉值
			getAllMembers(keyword,option);//傳keyword,option 給getAllMembers
			System.out.println(keyword);
//			getAllMembers(keyword);
			
			
			//String keyword="";//因為 RegisterService 第40行 所以才加的
			RegisterService  rs = new RegisterService();   //呼叫JDBC的Class
		     	Collection<Member>  coll = rs.getAllMembers(keyword,option) ;//呼叫JDBC的Class裡的方法  ,keyword加的
		     	request.setAttribute("AllMembers", coll);//把呼叫JDBC的Class裡的方法變成識別字串
			RequestDispatcher rd = request.getRequestDispatcher("showAllMembers.jsp");//呼叫showAllMembers.jsp頁面
			rd.forward(request, response);
		}//修改
			
			
			//String keyword
		public Collection<Member> getAllMembers(String keyword,String option)  {
		try {
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eeit80team01");
			conn = ds.getConnection();
			String sql=null;
			if(option==""){
				sql="select * from ITEMS where TITLE like ?";
			}else{		
				sql="select * from ITEMS where ITEM_CATEGORY ="+option+" and title like ?";			
			}
			PreparedStatement stmt = conn.prepareStatement(sql);//改1  MEMBER      USERNAME
			//String keyword = request.getParameter("keyword");
			keyword = keyword + "%";
			if(option==""){
				stmt.setString(1,keyword );
			}else{
				stmt.setString(1,keyword );
			}			
//			stmt.setString(1,keyword );
			ResultSet rs = stmt.executeQuery();//原來的
			System.out.println(rs);
			System.out.println(keyword);
			Member mem = null;
//			while (rs.next()) {
//				mem = new Member(rs.getString(2), rs.getString(3), rs//數字表示sql欄位
//						.getString(4), rs.getString(5), rs.getString(6), rs
//						.getInt(7));
//				allMembers.add(mem);
//			}
			
			while (rs.next()) {
			mem = new Member(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
					rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)
					);//,rs.getString(12)
			allMembers.add(mem);
		}
			
			return allMembers;
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自動產生 catch 區塊
					e.printStackTrace();
				}
			}
		}
		return null;
	}
		
}
