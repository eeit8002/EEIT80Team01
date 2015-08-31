package member.model.dao;

import global.GlobalService;

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
	
	@Override
	public FindPwBean select(String userName) {

		return null;
	}

	@Override
	public List<FindPwBean> select() {

		return null;
	}

	@Override
	public FindPwBean insert(FindPwBean bean) {

		return null;
	}

	@Override
	public FindPwBean update(FindPwBean bean) {

		return null;
	}

	@Override
	public boolean delete(String userName) {

		return false;
	}

}
