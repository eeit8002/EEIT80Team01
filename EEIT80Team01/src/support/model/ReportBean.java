package support.model;

public class ReportBean {
	private int legal;
	private String prosecutor;
	private String username;
	private String url;
	private String reason;
	private int status;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getLegal() {
		return legal;
	}
	public void setLegal(int legal) {
		this.legal = legal;
	}
	public String getProsecutor() {
		return prosecutor;
	}
	public void setProsecutor(String prosecutor) {
		this.prosecutor = prosecutor;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
