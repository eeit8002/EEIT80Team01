package items.model;

import java.util.List;

import items.model.ItemsBean;

public interface ItemsDAO {

	ItemsBean selectId(int itemId);

	ItemsBean selectCategory(int itemCategory);

	List<ItemsBean> getAll();

	ItemsBean insert(ItemsBean bean);

	ItemsBean update(ItemsBean bean);

	boolean delete(int itemId);

}