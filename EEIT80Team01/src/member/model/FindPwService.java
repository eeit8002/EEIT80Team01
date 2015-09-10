package member.model;

import java.util.Date;

import member.changedata.TOTP;
import member.model.dao.FindPwDAOjdbc;

public class FindPwService {

	public FindPwBean writeLog(String username){
		FindPwBean bean = null;
		FindPwDAO dao = new FindPwDAOjdbc();
		bean = dao.select(username);
		if(bean != null){

			long date = new Date().getTime();
			bean.setUserName(username);
			bean.setRequestTime(date);
			bean = dao.update(bean);
			
		} else {
			bean = new FindPwBean();
			long date = new Date().getTime();
			bean.setUserName(username);
			bean.setRequestTime(date);
			bean = dao.insert(bean);
		}		
		return bean;
	}
	
	public boolean validateData(String username, String pass){
		FindPwDAO dao = new FindPwDAOjdbc();
		FindPwBean bean = dao.select(username);

		if(bean!=null && username.equals(bean.getUserName()) && pass.equals(TOTP.getTOTP(bean.getUserName(), bean.getRequestTime()))){
			return true;
		}
		return false;
	}
	
	public String bulidUrl(String Path, FindPwBean bean){
		StringBuilder sb = new StringBuilder();
		sb.append(Path);
		sb.append("/service/findpassword?username=");
		sb.append(bean.getUserName());
		sb.append("&pass=");
		sb.append(TOTP.getTOTP(bean.getUserName(), bean.getRequestTime()));

		return sb.toString();
	}
	
	public boolean deleteLog(String username){
		FindPwDAO dao = new FindPwDAOjdbc();
		boolean bean = dao.delete(username);
		return bean;
	}
	
}
