package admin.model;

public class AdminBean {
	private String adminname;
	private String passwd;
	private int permission;
	
	public String getAdminName() {
		return adminname;
	}
	public void setAdminName(String adminname) {
		this.adminname = adminname;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	
}
