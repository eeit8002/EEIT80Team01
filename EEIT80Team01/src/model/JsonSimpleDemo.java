package search.model;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.sql.*;
/**
 * 
 * Servlet implementation class JsonSimpleDemo
 */
@WebServlet("/JsonSimpleDemo")
public class JsonSimpleDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonSimpleDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("application/json");
		// Get the printwriter object from response to write the required json object to the output stream      
		PrintWriter out = response.getWriter();
		// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=EEIT80TEAM01";  //DatabaseName=?  原Northwind
		String query = "select * from MEMBER where USERNAME like ?";//select CustomerID from Customers where CustomerID like ?
							//USERNAME       搬了1 
		String keyword = request.getParameter("keyword");
		keyword = keyword + "%";
		try{
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			conn = DriverManager.getConnection(url, "sa", "passw0rd");
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, keyword);
			
			rs = stmt.executeQuery();
			JSONArray list = new JSONArray();
			 while (rs.next())
			 {
				 list.add(rs.getString(1));
			 }
			 out.print(list);
			
		}
		catch(SQLException e){
			out.println("Error:" + e.getMessage());
		}
		finally{
			//if(rs != null){
			//   rs.close();
			//}
			//if(stmt != null){
			// stmt.close();
			//}
			//if(conn != null){
			//}
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

}
