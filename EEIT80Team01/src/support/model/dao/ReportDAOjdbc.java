package support.model.dao;

import global.GlobalService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import member.model.MemberBean;
import support.model.ReportBean;
import support.model.ReportDAO;

public class ReportDAOjdbc implements ReportDAO {
	
	private DataSource ds = null;
	
	public ReportDAOjdbc() {
  
        Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	
		} catch (NamingException e) {
		}		
    }
	
	private static final String SELECT_BY_LEGAL =
			"select * from report where legal=?";

	public ReportBean select(int legal) {
		ReportBean bean = null;
		ResultSet rset = null;
		
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_LEGAL);){
				stmt.setInt(1, legal);
				rset = stmt.executeQuery();
				if(rset.next()) {
					bean = new ReportBean();
					bean.setLegal(rset.getInt("legal"));
					bean.setProsecutor(rset.getString("prosecutor"));
					bean.setUsername(rset.getString("username"));
					bean.setUrl(rset.getString("url"));
					bean.setReason(rset.getString("reason"));
					bean.setStatus(rset.getInt("statu"));
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

	private static final String SELECT_ALL =
			"select * from report";
	
	public List<ReportBean> select() {
		List<ReportBean> beans = null;
		
		try(Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();){
				beans = new ArrayList<ReportBean>();
				
				while(rset.next()){
					ReportBean bean = new ReportBean();
					bean.setLegal(rset.getInt("legal"));
					bean.setProsecutor(rset.getString("prosecutor"));
					bean.setUsername(rset.getString("username"));
					bean.setUrl(rset.getString("url"));
					bean.setReason(rset.getString("reason"));
					bean.setStatus(rset.getInt("statu"));
					beans.add(bean);				
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return beans;
	}

	private static final String INSERT =
			"insert into report (prosecutor, username, url, reason, statu) values (?, ?, ?, ?, ?)";

	public ReportBean insert(ReportBean bean) {
		ReportBean result = null;
		
		try(Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(INSERT);){
			if(bean!=null) {
				stmt.setString(1, bean.getProsecutor());
				stmt.setString(2, bean.getUsername());
				stmt.setString(3, bean.getUrl());
				stmt.setString(4, bean.getReason());
				stmt.setInt(5, 0);
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
			"update report set prosecutor=?, username=?, url=?, reason=?, statu=? where legal=?";

	public ReportBean update(ReportBean bean) {
		ReportBean result = null;
		try(Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(1, bean.getProsecutor());
			stmt.setString(2, bean.getUsername());
			stmt.setString(3, bean.getUrl());
			stmt.setString(4, bean.getReason());
			stmt.setInt(5, bean.getStatus());
			stmt.setInt(6, bean.getLegal());
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
			"delete from report where legal=?";

	public boolean delete(int legal) {
		
		try(Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {			
				stmt.setInt(1, legal);
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
