package items.model;

import java.util.List;

public interface ItemsDAO {

	ItemsBean select(int itemId);

	List<ItemsBean> selectAll();

	ItemsBean insert(ItemsBean bean);

	ItemsBean update(String seller, String buyer, String title, double startPrice, double directPrice, int bid,
			java.util.Date endTime, String itemStatus, int threadLock, int itemId);

	boolean delete(int itemId);

}