package member.model;

import global.GlobalService;
import member.model.dao.MemberDAOjdbc;

public class MemberService {

	public boolean accountCheck(String username){
		MemberDAO dao = new MemberDAOjdbc();
		MemberBean bean = dao.select(username);

		if(bean!=null && bean.getUserName().equals(username)){
			return false;
		} else {
			return true;
		}		
	}
	public boolean idCheck(String id){
		MemberDAO dao = new MemberDAOjdbc();
		MemberBean bean = dao.selectById(id);

		if(bean!=null && bean.getId().equals(id)){
			return false;
		} else {
			return true;
		}		
	}
	
	public MemberBean register(MemberBean bean){
		MemberDAO dao = new MemberDAOjdbc();
		bean.setPassword(GlobalService.getMD5Endocing(bean.getPassword()));
		MemberBean result = dao.insert(bean);
		return result;
	}
	
	public MemberBean checkIDPassword(String username, String password){
		MemberBean bean = new MemberBean();
		MemberDAO dao = new MemberDAOjdbc();
		bean = dao.select(username);
		if( bean!=null && bean.getUserName().toUpperCase().equals(username) 
				&& bean.getPassword().equals(GlobalService.getMD5Endocing(password))){
			return bean;
		} else {
			return null;
		}
			
	}
	
	
}
