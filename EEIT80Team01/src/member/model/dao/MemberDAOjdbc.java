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

import member.model.MemberBean;
import member.model.MemberDAO;


public class MemberDAOjdbc implements MemberDAO {
	private DataSource ds = null;
	public MemberDAOjdbc() {
		
        Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		
		} catch (NamingException e) {
			e.printStackTrace();
		}		
    }
	
	
	private static final String SELECT_BY_USERNAME =
			"select * from member where username=?";
	
	@Override
	public MemberBean select(String userName) {
		MemberBean result = null;
		ResultSet rset = null;
		
		try (Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_USERNAME);){
			stmt.setString(1, userName);
			rset = stmt.executeQuery();
			if(rset.next()) {
				result = new MemberBean();
				result.setUserName(rset.getString("username"));
				result.setPassword(rset.getString("passwd"));
				result.setId(rset.getString("id"));
				result.setFirstName(rset.getString("fname"));
				result.setLastName(rset.getString("lname"));
				result.setEmail(rset.getString("email"));
				result.setGender(rset.getInt("gender"));
				result.setBirthDay(new Date(rset.getDate("birthday").getTime()));
				result.setAccess(rset.getInt("access"));
				result.setCertified(rset.getInt("certified"));
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
		return result;
	}
	
	private static final String SELECT_ALL = "select * from member";
	
	@Override
	public List<MemberBean> select() {
		List<MemberBean> beans = null;
		
		try(Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = stmt.executeQuery();){
			beans = new ArrayList<MemberBean>();
			
			while(rset.next()){
				MemberBean bean = new MemberBean();
				bean.setUserName(rset.getString("username"));
				bean.setPassword(rset.getString("passwd"));
				bean.setId(rset.getString("id"));
				bean.setFirstName(rset.getString("fname"));
				bean.setLastName(rset.getString("lname"));
				bean.setEmail(rset.getString("email"));
				bean.setGender(rset.getInt("gender"));
				bean.setBirthDay(new Date(rset.getDate("birthday").getTime()));
				bean.setAccess(rset.getInt("access"));
				bean.setCertified(rset.getInt("certified"));
				beans.add(bean);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return beans;
	}
	private static final String INSERT =
			"insert into member (username, passwd, id, fname, lname, email, gender, birthday, access, certified) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	@Override
	public MemberBean insert(MemberBean bean) {
		MemberBean result = null;
		
		try(Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(INSERT);){
			if(bean!=null) {
				stmt.setString(1, bean.getUserName());
				stmt.setString(2, bean.getPassword());
				stmt.setString(3, bean.getId());
				stmt.setString(4, bean.getFirstName());
				stmt.setString(5, bean.getLastName());
				stmt.setString(6, bean.getEmail());
				stmt.setInt(7, bean.getGender());
				java.util.Date birthday = bean.getBirthDay();
				if(birthday!=null) {
					long time = birthday.getTime();
					stmt.setDate(8, new java.sql.Date(time));
				} else {
					stmt.setDate(8, null);				
				}
				stmt.setInt(9, bean.getAccess());
				stmt.setInt(10, bean.getCertified());				
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
			"update member set passwd=?, id=?, fname=?, lname=?, email=?, gender=?, birthday=?, access=?, certified=? where username=?";
	@Override
	public MemberBean update(MemberBean bean) {
		MemberBean result = null;
		try(Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(1, bean.getPassword());
			stmt.setString(2, bean.getId());
			stmt.setString(3, bean.getFirstName());
			stmt.setString(4, bean.getLastName());
			stmt.setString(5, bean.getEmail());
			stmt.setInt(6, bean.getGender());
			java.util.Date birthday = bean.getBirthDay();
			if(birthday!=null) {
				long time = birthday.getTime();
				stmt.setDate(7, new java.sql.Date(time));
			} else {
				stmt.setDate(7, null);				
			}
			stmt.setInt(8, bean.getAccess());
			stmt.setInt(9, bean.getCertified());	
			stmt.setString(10, bean.getUserName());
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
			"delete from member where username=?";
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
	
	private static final String SELECT_BY_ID =
			"select * from member where id=?";
	
	@Override
	public MemberBean selectById(String userName) {

		MemberBean result = null;
		ResultSet rset = null;
		
		try (Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);){
			stmt.setString(1, userName);
			rset = stmt.executeQuery();
			if(rset.next()) {
				result = new MemberBean();
				result.setUserName(rset.getString("username"));
				result.setPassword(rset.getString("passwd"));
				result.setId(rset.getString("id"));
				result.setFirstName(rset.getString("fname"));
				result.setLastName(rset.getString("lname"));
				result.setEmail(rset.getString("email"));
				result.setGender(rset.getInt("gender"));
				result.setBirthDay(new Date(rset.getDate("birthday").getTime()));
				result.setAccess(rset.getInt("access"));
				result.setCertified(rset.getInt("certified"));
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
		return result;
	}

}
