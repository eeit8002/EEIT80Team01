package member.model;

import member.model.dao.MemberDAOjdbc;

public class MemberService {

	public boolean accountCheck(String userName){
		MemberDAO dao = new MemberDAOjdbc();
		MemberBean bean = dao.select(userName);

		if(bean!=null && bean.getUserName().equals(userName)){
			return false;
		} else {
			return true;
		}		
	}
	public void register(MemberBean bean){
		
		
	}
	
	
}
