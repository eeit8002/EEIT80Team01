package member.model;

import global.GlobalService;
import member.model.dao.MemberDAOjdbc;

public class MemberService {
	
	public MemberService(){
		
	}
	
	public boolean accountCheck(String username){
		MemberDAO dao = new MemberDAOjdbc();
		MemberBean bean = dao.select(username);

		if(bean!=null && bean.getUserName().equals(username)){
			return false;
		} else {
			return true;
		}		
	}
	
	public MemberBean register(MemberBean bean){
		MemberDAO dao = new MemberDAOjdbc();
		bean.setPassword(GlobalService.getMD5Encoding(bean.getPassword()));
		MemberBean result = dao.insert(bean);
		return result;
	}
	
	public MemberBean checkPasswordWithUsername(String username, String password){
		MemberBean bean = new MemberBean();
		MemberDAO dao = new MemberDAOjdbc();
		bean = dao.select(username);
		if( bean!=null && bean.getUserName().toLowerCase().equals(username) 
				&& bean.getPassword().equals(GlobalService.getMD5Encoding(password))){
			return bean;
		} else {
			return null;
		}
			
	}
	
	public MemberBean changeMemberData(MemberBean bean){
		MemberDAO dao = new MemberDAOjdbc();
		bean.setPassword(GlobalService.getMD5Encoding(bean.getPassword()));
		bean = dao.update(bean);
			
		return bean;
	}
	
	public MemberBean findMemberData(String username){
		MemberDAO dao = new MemberDAOjdbc();
		MemberBean bean = dao.select(username);
		
		return bean;
	}
	
}
