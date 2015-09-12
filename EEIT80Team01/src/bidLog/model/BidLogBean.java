package bidLog.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class BidLogBean {
	private int itemId;
    private String buyer;
    private double bidPrice;
    private java.sql.Date bidTime;
    
    public boolean equals(Object obj) {
    	   if (obj == null) { return false; }
    	   if (obj == this) { return true; }
    	   if (obj.getClass() != getClass()) {
    	     return false;
    	   }
    	   BidLogBean rhs = (BidLogBean) obj;
    	   return new EqualsBuilder()
    	                 .append(itemId, rhs.itemId)
    	                 .append(buyer, rhs.buyer)
    	                 .isEquals();
    	  }
    public int hashCode() {
        return new HashCodeBuilder(17, 37).
          append(itemId).
          append(buyer).
          toHashCode();
      }
    
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public java.sql.Date getBidTime() {
		return bidTime;
	}
	public void setBidTime(java.sql.Date bidTime) {
		this.bidTime = bidTime;
	}
    
}
