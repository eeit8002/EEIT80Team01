package trade.model;

import java.util.List;

import trade.model.dao.TradeDAOJdbc;

public class TradeDAOService {
	TradeDAOService(){
		dao = new TradeDAOJdbc();
	}
	private TradeDAO dao = null;
	private TradeBean bean = null;
	
	public List<TradeBean> getAll(){
		return dao.getAll();
	}
	public TradeBean getByPK(int itemId){
		return dao.getByPK(itemId);
	}
	public List<TradeBean> getByBuyer(String buyer){
		return dao.getByBuyer(buyer);
	}
	public List<TradeBean> getByItem(int itemId){
		return dao.getByItem(itemId);
	}
	public List<TradeBean> getBySeller(String seller){
		return dao.getBySeller(seller);
	}
	public TradeBean insert(int itemId,String buyer,
			int buyerCheck,String seller,int sellerCheck){
		bean = new TradeBean();
		bean.setItemId(itemId);
		bean.setBuyer(buyer);
		bean.setBuyerCheck(buyerCheck);
		bean.setSeller(seller);
		bean.setSellerCheck(sellerCheck);
		int i = dao.insert(bean);
		if(i==1){
			return bean;
		}
		return null;
	}
	public TradeBean update(int itemId,String buyer,
			int buyerCheck,String seller,int sellerCheck){
		bean = new TradeBean();
		bean.setItemId(itemId);
		bean.setBuyer(buyer);
		bean.setBuyerCheck(buyerCheck);
		bean.setSeller(seller);
		bean.setSellerCheck(sellerCheck);
		int i = dao.update(bean);
		if(i==1){
			return bean;
		}
		return null;
	}
	public void delete(int itemId){
		dao.delete(itemId);
	}
	
}
