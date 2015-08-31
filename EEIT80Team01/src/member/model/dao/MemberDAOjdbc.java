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
		}		
    }
	
	@Override
	public MemberBean select(String userName) {
		
		
		return null;
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
				bean.setPassword(rset.getString("password"));
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
			"insert into member (username, password, id, fname, lname, email, gender, birthday, access, certified) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	@Override
	public MemberBean insert(MemberBean bean) {
	
		return null;
	}

	@Override
	public MemberBean update(MemberBean bean) {
	
		return null;
	}

	@Override
	public boolean delete(String userName) {

		return false;
	}

}
