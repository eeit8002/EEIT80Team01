package items.model;

import java.util.List;

import items.model.ItemsBean;

public interface ItemsDAO {

	ItemsBean selectId(int itemId);

	ItemsBean selectCategory(int itemCategory);

	List<ItemsBean> selectAll();

	ItemsBean insert(ItemsBean bean);

	ItemsBean update(String seller, String buyer, int itemCategory, String title, double startPrice, double directPrice,
			int bid, java.util.Date endTime, String itemDiscribe, int itemStatus, int threadLock, int itemId);

	boolean delete(int itemId);

}