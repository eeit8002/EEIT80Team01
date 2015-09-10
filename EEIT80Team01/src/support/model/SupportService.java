package support.model;

import global.GlobalService;
import support.model.dao.SupportDAOJdbc;

public class SupportService {
	public boolean supporterAccountCheck(String supportername) {
		SupportDAO dao = new SupportDAOJdbc();
		SupportBean bean = dao.select(supportername);

		if (bean != null && bean.getSupportername().equals(supportername)) {
			return false;
		} else {
			return true;
		}
	}

	public SupportBean supporterCheckSupporterNamePassword(String supportername, String password) {
		SupportBean bean = new SupportBean();
		SupportDAO dao = new SupportDAOJdbc();
		bean = dao.select(supportername);
		if (bean != null && bean.getSupportername().toUpperCase().equals(supportername)
				&& bean.getPassword().equals(GlobalService.getMD5Endocing(password))) {
			return bean;
		} else {
			return null;
		}
	}
	
	public SupportBean changeSupporterPassword(SupportBean bean) {
		SupportDAO dao = new SupportDAOJdbc();
		bean = dao.update(bean);
		return bean;
	}
}
