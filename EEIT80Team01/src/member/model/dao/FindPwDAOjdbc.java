package member.model.dao;

import global.GlobalService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import member.model.FindPwBean;
import member.model.FindPwDAO;

public class FindPwDAOjdbc implements FindPwDAO {
	
	private DataSource ds = null;
	
	public FindPwDAOjdbc() {
  
        Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	
		} catch (NamingException e) {
		}		
    }
	
	private static final String SELECT_BY_USERNAME =
			"select * from findpw where username=?";
	@Override
	public FindPwBean select(String userName) {
		FindPwBean bean = null;
		ResultSet rset = null;
		
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_USERNAME);){
				stmt.setString(1, userName);
				rset = stmt.executeQuery();
				if(rset.next()) {
					bean = new FindPwBean();
					bean.setUserName(rset.getString("username"));
					bean.setRequestTime(rset.getLong("REQUEST_TIME"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rset!=null) {
					try {
						rset.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}		
		return bean;
	}
	
	private static final String SELECT_ALL = "select * from findpw";
	@Override
	public List<FindPwBean> select() {
		List<FindPwBean> beans = null;
		
		try(Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();){
				beans = new ArrayList<FindPwBean>();
				
				while(rset.next()){
					FindPwBean bean = new FindPwBean();
					bean.setUserName(rset.getString("username"));
					bean.setRequestTime(rset.getLong("REQUEST_TIME"));
					beans.add(bean);				
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return beans;
	}
	
	private static final String INSERT =
			"insert into findpw (username, REQUEST_TIME) values (?, ?)";


	@Override
	public FindPwBean insert(FindPwBean bean) {
		FindPwBean result = null;
		try(Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT);){
					if(bean!=null) {
						stmt.setString(1, bean.getUserName());
						stmt.setLong(2, bean.getRequestTime());							
						int i = stmt.executeUpdate();
						if(i==1) {
							result = bean;
						}
					}				
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return result;
	}
	private static final String UPDATE =
			"update findpw set REQUEST_TIME=? where username=?";
	
	@Override
	public FindPwBean update(FindPwBean bean) {
		FindPwBean result = null;
		try(Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {			
				stmt.setLong(1, bean.getRequestTime());
				stmt.setString(2, bean.getUserName());
				int i = stmt.executeUpdate();
				if(i==1) {
					result = bean;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}				
				
		return result;
	}
	private static final String DELETE =
			"delete from findpw where username=?";
	@Override
	public boolean delete(String userName) {
		try(Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {			
				stmt.setString(1, userName);
				int i = stmt.executeUpdate();
				if(i==1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

}
