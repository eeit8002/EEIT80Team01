package admin.model;

import admin.model.dao.AdminDAOJdbc;
import global.GlobalService;

public class AdminService {

	// check username already exist
	public boolean adminAccountCheck(String username) {
		AdminDAO dao = new AdminDAOJdbc();
		AdminBean bean = dao.select(username);

		if (bean != null && bean.getUserName().equals(username)) {
			return false;
		} else {
			return true;
		}
	}

	// verify username and password
	public AdminBean adminCheckUsernamePassword(String username, String password) {
		AdminBean bean = new AdminBean();
		AdminDAO dao = new AdminDAOJdbc();
		bean = dao.select(username);
		if (bean != null && bean.getUserName().toUpperCase().equals(username)
				&& bean.getPasswd().equals(GlobalService.getMD5Endocing(password))) {
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
