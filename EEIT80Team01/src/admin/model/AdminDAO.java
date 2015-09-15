package admin.model;

import java.util.List;

import admin.model.AdminBean;

public interface AdminDAO {
	public abstract AdminBean select(String userName);

	public abstract List<AdminBean> select();

	public abstract AdminBean insert(AdminBean bean);

	public abstract AdminBean update(AdminBean bean);

	public abstract boolean delete(String userName);
}
