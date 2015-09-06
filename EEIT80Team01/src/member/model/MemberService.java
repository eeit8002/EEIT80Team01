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
	public MemberBean register(MemberBean bean){
		MemberDAO dao = new MemberDAOjdbc();
		bean.setPassword(GlobalService.getMD5Endocing(bean.getPassword()));
		MemberBean result = dao.insert(bean);
		return result;
	}
	
	
}
