package model;

import java.io.Serializable;

public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
//測試==================
	String username;
	String passwd;
	String id;
	String fname;
	String lname;
//	int tel;




public Member(String username,String  passwd,String id,String fname,String lname) {
	super();
	this.username = username;
//	this.tel=tel;
	this.passwd=passwd;
	this.id=id;
	this.fname=fname;
	this.lname=lname;
	
}
	public String getPasswd() {
	return passwd;
}
public void setPasswd(String passwd) {
	this.passwd = passwd;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
	public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
//	public String getAccount() {
//	return account;
//}
//public void setAccount(String account) {
//	this.account = account;
//}
//public int getTel() {
//		return tel;
//	}
//	public void setTel(int tel) {
//		this.tel = tel;
//	}
//=================
	
	
	
//		String userId;
//	String password;
//	String name;
//	String email;
//	String tel; 
//	int experience;
//	
//	public Member(String userId, String password, String name, String mail,
//			String tel, int expericnce) {
//		super();
//		this.userId = userId;
//		this.password = password;
//		this.name = name;
//		email = mail;
//		this.tel = tel;
//		this.experience = expericnce;
//	}
//
//	public Member() {
//		super();
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String mail) {
//		email = mail;
//	}
//
//	public int getExperience() {
//		return experience;
//	}
//
//	public void setExperience(int expericnce) {
//		this.experience = expericnce;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getTel() {
//		return tel;
//	}
//
//	public void setTel(String tel) {
//		this.tel = tel;
//	}
//
//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

}
