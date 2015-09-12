package bidLog.model;

import java.util.List;

import bidLog.model.dao.BidLogDAOJdbc;

public class BidLogDAOService {
	public BidLogDAOService(){
		dao = new BidLogDAOJdbc();
	}
	private BidLogDAO dao = null;
	private BidLogBean bean = null;
	
	public List<BidLogBean> getAll(){
		return dao.getAll();
	}
	public BidLogBean getByPK(int itemId,String buyer){
		return dao.getByPK(itemId, buyer);
	}
	public List<BidLogBean> getByBidPrice(double bidPrice){
		return dao.getByBidPrice(bidPrice);
	}
	public List<BidLogBean> getByBidTime(java.sql.Date bidTime){
		return dao.getByBidTime(bidTime);
	}
	public List<BidLogBean> getByBuyer(String buyer){
		return dao.getByBuyer(buyer);
	}
	public List<BidLogBean> getByItem(int itemId){
		return dao.getByItem(itemId);
	}
	public BidLogBean insert(int itemId,double bidPrice,java.sql.Date bidTime,String buyer){
		bean = new BidLogBean();
		bean.setItemId(itemId);
		bean.setBidPrice(bidPrice);
		bean.setBidTime(bidTime);
		bean.setBuyer(buyer);
		int i = dao.insert(bean);
		if(i==1){
			return bean;
		}
		return null;
	}
	public BidLogBean update(int itemId,double bidPrice,java.sql.Date bidTime,String buyer){
		bean = new BidLogBean();
		bean.setItemId(itemId);
		bean.setBidPrice(bidPrice);
		bean.setBidTime(bidTime);
		bean.setBuyer(buyer);
		int i = dao.update(bean);
		if(i==1){
			return bean;
		}
		return null;
	}
	public void delete(int itemId,String buyer){
		dao.delete(itemId, buyer);
	}
}
