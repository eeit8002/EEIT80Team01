package member.model;

import java.sql.Timestamp;


public class MessageBean {
	private String sender;
	private String receiver;
	private String messageTitle;
	private String messageBody;
	private Timestamp messageTime;
	private long messageNumber;
	private int visibility;
	
	public int getVisibility() {
		return visibility;
	}
	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public Timestamp getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(Timestamp messageTime) {
		this.messageTime = messageTime;
	}
	public long getMessageNumber() {
		return messageNumber;
	}
	public void setMessageNumber(long messageNumber) {
		this.messageNumber = messageNumber;
	}
			
}
