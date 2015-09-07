package admin.model;

import admin.model.dao.AdminDAOJdbc;

public class AdminService {

	public boolean adminAccountCheck(String username) {
		AdminDAO dao = new AdminDAOJdbc();
		AdminBean bean = dao.select(username);

		if (bean != null && bean.getUserName().equals(username)) {
			return false;
		} else {
			return true;
		}
	}
	
}
