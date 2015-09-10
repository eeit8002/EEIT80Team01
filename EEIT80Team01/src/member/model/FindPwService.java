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
	
	public String bulidUrl(String Path, FindPwBean bean){
		StringBuffer sb = new StringBuffer();
		sb.append(Path);
		sb.append("service/findpassword?username=");
		sb.append(bean.getUserName());
		sb.append("&pass=");
		sb.append(TOTP.getTOTP(bean.getUserName(), bean.getRequestTime()));

		return sb.toString();
	}
	
}
