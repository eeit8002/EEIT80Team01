package bidLog.model;

import java.util.List;

public interface BidLogDAO {
	public List<BidLogBean> getAll();
	public BidLogBean getByPK(int itemId,String buyer);
	public List<BidLogBean> getByItem(int itemId);
	public List<BidLogBean> getByBidPrice(double bidPrice);
	public List<BidLogBean> getByBidTime(java.sql.Date bidTime);
	public List<BidLogBean> getByBuyer(String buyer);
	public int insert(BidLogBean bean);
	public int update(BidLogBean bean);
	public int delete(int itemId,String buyer);
}
