package admin.model;

import admin.model.dao.AdminDAOJdbc;
import global.GlobalService;

public class AdminService {

	// check adminname already exist
	public boolean adminAccountCheck(String adminname) {
		AdminDAO dao = new AdminDAOJdbc();
		AdminBean bean = dao.select(adminname);

		if (bean != null && bean.getAdminName().equals(adminname)) {
			return false;
		} else {
			return true;
		}
	}

	// verify adminname and password
	public AdminBean CheckAdminNamePassword(String adminname, String password) {
		AdminBean bean = new AdminBean();
		AdminDAO dao = new AdminDAOJdbc();
		bean = dao.select(adminname);
		if (bean != null && bean.getAdminName().toLowerCase().equals(adminname)
				&& bean.getPasswd().equals(GlobalService.getMD5Encoding(password))) {
			return bean;
		} else {
			return null;
		}
	}

	public AdminBean changeAdminPassword(AdminBean bean) {
		AdminDAO dao = new AdminDAOJdbc();
		bean = dao.update(bean);
		return bean;
	}
	
}
