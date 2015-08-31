package member.model.dao;

import global.GlobalService;

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

	@Override
	public List<MemberBean> select() {
	
		return null;
	}

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
