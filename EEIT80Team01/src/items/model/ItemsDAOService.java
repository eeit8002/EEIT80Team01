package items.model;

import items.model.dao.ItemsDAOjdbc;

public class ItemsDAOService {
	private ItemsDAO dao;
	public ItemsDAOService(){
		dao = new ItemsDAOjdbc();
	}
	public ItemsBean addItems(int itemId, String selley, String buyer,int itemCategory, String title,
			double startPrice, double directPrice, int bid, java.util.Date endTime,String itemDiscribe,
			int itemStatus, int threadLock){
		
		ItemsBean bean = new ItemsBean();
		
		bean.setItemId(itemId);
		bean.setSeller(selley);
		bean.setBuyer(buyer);
		bean.setItemCategory(itemCategory);
		bean.setTitle(title);
		bean.setStartPrice(startPrice);
		bean.setDirectPrice(directPrice);
		bean.setBid(bid);
		bean.setEndTime(endTime);
		bean.setItemDiscribe(itemDiscribe);
		bean.setItemStatus(itemStatus);
		bean.setThreadLock(threadLock);
		dao.insert(bean);
		
		return bean;

	}

}
