package member.model.dao;

import global.GlobalService;

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

	public MessageBean select(long messageNumber) {

		
		return null;
	}


	public List<MessageBean> findBySender(String sender) {

		return null;
	}


	public List<MessageBean> findByReceiver(String receiver) {

		return null;
	}


	public MessageBean insert(MessageBean bean) {

		return null;
	}


	public MessageBean update(MessageBean bean) {
		
		return null;
	}


	public boolean delete(long messageNumber) {
		
		return false;
	}


	public boolean delete(List<MessageBean> beans) {

		return false;
	}

}
