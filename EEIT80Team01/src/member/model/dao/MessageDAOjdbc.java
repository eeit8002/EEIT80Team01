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
import member.model.MessageBean;
import member.model.MessageDAO;

public class MessageDAOjdbc implements MessageDAO {

	private DataSource ds = null;
	
	public MessageDAOjdbc() {
  
        Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	
		} catch (NamingException e) {
		}		
    }

	
	private static final String SELECT_BY_MESSAGENUMBER =
			"select * from MSO where MSGNOr=?";
	
	public MessageBean select(long messageNumber) {
		MessageBean bean = null;
		ResultSet rset = null;
		try(Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_MESSAGENUMBER);){
			stmt.setLong(1, messageNumber);
			rset = stmt.executeQuery();
			if(rset.next()){
				bean = new MessageBean();
				bean.setSender(rset.getString("sender"));
				bean.setReceiver(rset.getString("receiver"));
				bean.setMessageTitle(rset.getString("msg_title"));
				bean.setMessageBody(rset.getString("msg_body"));
				bean.setMessageTime(new Date(rset.getDate("msg_time").getTime()));
				bean.setMessageNumber(rset.getLong("msgno"));
			}
		} catch (SQLException e) {
			
		} finally{
			if(rset!=null){
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
		return bean;
	}

	private static final String SELECT_BY_SENDER =
			"select * from MSO where SENDER=?";

	public List<MessageBean> findBySender(String sender) {
		List<MessageBean> result = new ArrayList<MessageBean>();
		ResultSet rset = null;
		try(Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_SENDER);){
			stmt.setString(1, sender);
			rset = stmt.executeQuery();
			if(rset.next()){				
				MessageBean bean = new MessageBean();
				bean.setSender(rset.getString("sender"));
				bean.setReceiver(rset.getString("receiver"));
				bean.setMessageTitle(rset.getString("msg_title"));
				bean.setMessageBody(rset.getString("msg_body"));
				bean.setMessageTime(new Date(rset.getDate("msg_time").getTime()));
				bean.setMessageNumber(rset.getLong("msgno"));
				result.add(bean);
			}
		} catch (SQLException e) {
			
		} finally{
			if(rset!=null){
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}			
		return result;
	}

	private static final String SELECT_BY_RECEIVER =
			"select * from MSO where RECEIVER=?";
	
	public List<MessageBean> findByReceiver(String receiver) {
		List<MessageBean> result = new ArrayList<MessageBean>();
		ResultSet rset = null;
		try(Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_RECEIVER);){
			stmt.setString(1, receiver);
			rset = stmt.executeQuery();
			if(rset.next()){				
				MessageBean bean = new MessageBean();
				bean.setSender(rset.getString("sender"));
				bean.setReceiver(rset.getString("receiver"));
				bean.setMessageTitle(rset.getString("msg_title"));
				bean.setMessageBody(rset.getString("msg_body"));
				bean.setMessageTime(new Date(rset.getDate("msg_time").getTime()));
				bean.setMessageNumber(rset.getLong("msgno"));
				result.add(bean);
			}
		} catch (SQLException e) {
			
		} finally{
			if(rset!=null){
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}			
		return result;
	}
	
	private static final String INSERT =
			"insert into MSG (sender, receiver, msg_title, msg_body, msg_time) values (?, ?, ? ,? ,?)";

	public MessageBean insert(MessageBean bean) {
		MessageBean result = null;
		try(Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT);){
					if(bean!=null) {
						stmt.setString(1, bean.getSender());
						stmt.setString(2, bean.getReceiver());
						stmt.setString(3, bean.getMessageTitle());
						stmt.setString(4, bean.getMessageBody());
						java.util.Date messageTime = bean.getMessageTime();
						if(messageTime!=null) {
							long time = messageTime.getTime();
							stmt.setDate(5, new java.sql.Date(time));
						} else {
							stmt.setDate(5, null);				
						}				
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
			"update member set sender=?, receiver=?, msg_title=?, msg_body=?, msg_time=? where msgno=?";


	public MessageBean update(MessageBean bean) {
		MessageBean result = null;
		try(Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(1, bean.getSender());
			stmt.setString(2, bean.getReceiver());
			stmt.setString(3, bean.getMessageTitle());
			stmt.setString(4, bean.getMessageBody());
			java.util.Date messageTime = bean.getMessageTime();
			if(messageTime!=null) {
				long time = messageTime.getTime();
				stmt.setDate(5, new java.sql.Date(time));
			} else {
				stmt.setDate(5, null);				
			}
			stmt.setLong(6, bean.getMessageNumber());
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
			"delete from member where msgno=?";

	public boolean delete(long messageNumber) {
		try(Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DELETE);) {			
			stmt.setLong(1, messageNumber);
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
