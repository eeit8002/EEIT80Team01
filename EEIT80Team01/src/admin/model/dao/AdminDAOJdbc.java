package admin.model.dao;

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

import admin.model.AdminBean;
import admin.model.AdminDAO;
import global.GlobalService;

public class AdminDAOJdbc implements AdminDAO {
	
	private DataSource ds = null;
	
	public AdminDAOJdbc() {
		Context context = null;
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup(GlobalService.JNDI_DB_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	private static final String SELECT_BY_USERNAME_ADMIN = "SELECT USERNAME,PASSWD FROM ADMINS WHERE USERNAME=?";
	@Override
	public AdminBean select(String userName) {
		AdminBean result = null;
		ResultSet rs = null;
		try (
				Connection connection = ds.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_USERNAME_ADMIN);
				) {
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new AdminBean();
				result.setUserName(rs.getString("USERNAME"));
				result.setPasswd(rs.getString("PASSWD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	
	
	
	
	private static final String SELECT_ALL_ADMIN = "SELECT USERNAME,PASSWD FROM ADMINS";
	@Override
	public List<AdminBean> select() {
		List<AdminBean> beans = null;
		try (
				Connection connection = ds.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_ADMIN);
				ResultSet rs = pstmt.executeQuery();
				) {
			beans = new ArrayList<AdminBean>();
			while(rs.next()){
				AdminBean bean = new AdminBean();
				bean.setUserName(rs.getString("USERNAME"));
				bean.setPasswd(rs.getString("PASSWD"));
				beans.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beans;
	}
	
	
	
	
	
	private static final String INSERT_ADMIN = "INSERT INTO ADMINS USERNAME,PASSWD VALUES (?,?,?)";
	@Override
	public AdminBean insert(AdminBean bean) {
		AdminBean result = null;
		try (				
				Connection connection = ds.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT_ADMIN);
				) {
			if (bean != null) {
				pstmt.setString(1, bean.getUserName());
				pstmt.setString(2, bean.getPasswd());
			}
			int i = pstmt.executeUpdate();
			if(i==1){
				result=bean;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	private static final String UPDATE_ADMIN = "UPDATE ADMINS SET PASSWD=? WHERE USERNAME=?";
	@Override
	public AdminBean update(AdminBean bean) {
		AdminBean result = null;
		try (
				Connection connection = ds.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_ADMIN);
				){
			pstmt.setString(1, bean.getPasswd());
			pstmt.setString(2, bean.getUserName());
			int i = pstmt.executeUpdate();
			if (i == 1) {
				result = bean;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	private static final String DELETE_ADMIN = "DELETE FROM ADMINS WHERE USERNAME=?";
	@Override
	public boolean delete(String userName) {
		try (
				Connection connection = ds.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(DELETE_ADMIN);
				) {
			pstmt.setString(1, userName);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}