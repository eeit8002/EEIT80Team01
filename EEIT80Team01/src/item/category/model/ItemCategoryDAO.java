package item.category.model;

import java.util.List;

public interface ItemCategoryDAO {

	ItemCategoryBean selectItemCategory(int itemCategory);

	List<ItemCategoryBean> getAll();

	ItemCategoryBean insert(ItemCategoryBean bean);

	ItemCategoryBean update(ItemCategoryBean bean);

	boolean delete(int itemCategory);

}