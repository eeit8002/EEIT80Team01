package items.model;

import items.model.dao.ItemsDAOjdbc;

public class ItemsService {
	private ItemsDAO dao;
	public ItemsService(){
		dao = new ItemsDAOjdbc();
	}
	public ItemsBean addItems(int itemId, String selley, String buyer, String title,
			double startPrice, double directPrice, int bid, java.util.Date endTime,
			String itemStatus, int threadLock){
		
		ItemsBean bean = new ItemsBean();
		
		bean.setItemId(itemId);
		bean.setSeller(selley);
		bean.setBuyer(buyer);
		bean.setTitle(title);
		bean.setStartPrice(startPrice);
		bean.setDirectPrice(directPrice);
		bean.setBid(bid);
		bean.setEndTime(endTime);
		bean.setItemStatus(itemStatus);
		bean.setThreadLock(threadLock);
		dao.insert(bean);
		
		return bean;

	}

}
