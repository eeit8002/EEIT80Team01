package items.model;

import java.util.Date;

public class ItemsBean {
	private int itemId;
	private String seller;
	private String buyer;
	private String title;
	private double startPrice;
	private double directPrice;
	private int bid;
	private java.util.Date endTime;
	private String itemStatus;
	private int threadLock;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(double startPrice) {
		this.startPrice = startPrice;
	}
	public double getDirectPrice() {
		return directPrice;
	}
	public void setDirectPrice(double directPrice) {
		this.directPrice = directPrice;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	public int getThreadLock() {
		return threadLock;
	}
	public void setThreadLock(int threadLock) {
		this.threadLock = threadLock;
	}
	
}
