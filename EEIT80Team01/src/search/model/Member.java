package search.model;

import java.io.Serializable;

public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//商品table
//	String ITEM_ID;
	String SELLER;
	String MEMBER ;
	String ITEM_CATEGORY;
	String TITLE ;
	String START_PRICE ;
	String DIRECT_PRICE ;
	String BID ;
	String END_TIME ;
	String ITEM_DISCRIBE ;
	String ITEM_STATUS ;
	String THREAD_LOCK ;
	
	//String ITEM_ID,
	public Member(String  SELLER,String MEMBER,String ITEM_CATEGORY,String TITLE,
			String START_PRICE,String DIRECT_PRICE,String BID,String END_TIME,String ITEM_DISCRIBE
			,String ITEM_STATUS,String THREAD_LOCK) {
	super();
//	this.ITEM_ID = ITEM_ID;
	this.SELLER=SELLER;
	this.MEMBER=MEMBER;
	this.ITEM_CATEGORY=ITEM_CATEGORY;
	this.TITLE=TITLE;
	this.START_PRICE=START_PRICE;
	this.DIRECT_PRICE=DIRECT_PRICE;
	this.BID=BID;
	this.END_TIME=END_TIME;
	this.ITEM_DISCRIBE=ITEM_DISCRIBE;
	this.ITEM_STATUS=ITEM_STATUS;
	this.THREAD_LOCK=THREAD_LOCK;
}
	
	
	
	
	
//	public String getITEM_ID() {
//		return ITEM_ID;
//	}
//	public void setITEM_ID(String iTEM_ID) {
//		ITEM_ID = iTEM_ID;
//	}
	public String getSELLER() {
		return SELLER;
	}
	public void setSELLER(String sELLER) {
		SELLER = sELLER;
	}
	public String getMEMBER() {
		return MEMBER;
	}
	public void setMEMBER(String mEMBER) {
		MEMBER = mEMBER;
	}
	public String getITEM_CATEGORY() {
		return ITEM_CATEGORY;
	}
	public void setITEM_CATEGORY(String iTEM_CATEGORY) {
		ITEM_CATEGORY = iTEM_CATEGORY;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getSTART_PRICE() {
		return START_PRICE;
	}
	public void setSTART_PRICE(String sTART_PRICE) {
		START_PRICE = sTART_PRICE;
	}
	public String getDIRECT_PRICE() {
		return DIRECT_PRICE;
	}
	public void setDIRECT_PRICE(String dIRECT_PRICE) {
		DIRECT_PRICE = dIRECT_PRICE;
	}
	public String getBID() {
		return BID;
	}
	public void setBID(String bID) {
		BID = bID;
	}
	public String getEND_TIME() {
		return END_TIME;
	}
	public void setEND_TIME(String eND_TIME) {
		END_TIME = eND_TIME;
	}
	public String getITEM_DISCRIBE() {
		return ITEM_DISCRIBE;
	}
	public void setITEM_DISCRIBE(String iTEM_DISCRIBE) {
		ITEM_DISCRIBE = iTEM_DISCRIBE;
	}
	public String getITEM_STATUS() {
		return ITEM_STATUS;
	}
	public void setITEM_STATUS(String iTEM_STATUS) {
		ITEM_STATUS = iTEM_STATUS;
	}
	public String getTHREAD_LOCK() {
		return THREAD_LOCK;
	}
	public void setTHREAD_LOCK(String tHREAD_LOCK) {
		THREAD_LOCK = tHREAD_LOCK;
	}
	
	
	
	
	//測試=============================================================
//	String username;
//	String passwd;
//	String id;
//	String fname;
//	String lname;
//	int tel;




//public Member(String username,String  passwd,String id,String fname,String lname) {
//	super();
//	this.username = username;
////	this.tel=tel;
//	this.passwd=passwd;
//	this.id=id;
//	this.fname=fname;
//	this.lname=lname;
//	
//}
//	public String getPasswd() {
//	return passwd;
//}
//public void setPasswd(String passwd) {
//	this.passwd = passwd;
//}
//public String getId() {
//	return id;
//}
//public void setId(String id) {
//	this.id = id;
//}
//public String getFname() {
//	return fname;
//}
//public void setFname(String fname) {
//	this.fname = fname;
//}
//public String getLname() {
//	return lname;
//}
//public void setLname(String lname) {
//	this.lname = lname;
//}
//	public String getUsername() {
//	return username;
//}
//public void setUsername(String username) {
//	this.username = username;
//}
	
//==========================================================================
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
