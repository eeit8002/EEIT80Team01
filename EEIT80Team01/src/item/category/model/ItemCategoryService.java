package item.category.model;

import java.util.ArrayList;
import java.util.List;

import item.category.model.dao.ItemCategoryDAOjdbc;

public class ItemCategoryService {

	public List<ItemCategoryBean> selectCategory(ItemCategoryBean bean) {
		ItemCategoryDAO dao = new ItemCategoryDAOjdbc();

		List<ItemCategoryBean> result = null;
		if (bean != null && bean.getItemCategory() != 0) {
			ItemCategoryBean temp = dao.selectItemCategory(bean.getItemCategory());
			if (temp != null) {
				result = new ArrayList<ItemCategoryBean>();
				result.add(temp);
			}
		} else {
			result = dao.getAll();
		}
		return result;
	}

	public ItemCategoryBean getOneCategory(int itemCategory) {
		ItemCategoryDAO dao = new ItemCategoryDAOjdbc();
		return dao.selectItemCategory(itemCategory);
	}
	
	public boolean checkIfItemCategoryAlreadyExist(int itemCategory) {
		ItemCategoryDAO dao = new ItemCategoryDAOjdbc();
		ItemCategoryBean bean = dao.selectItemCategory(itemCategory);
		if (bean != null) {
			return true;
		} else {
			return false;
		}
	}

	public ItemCategoryBean insert(ItemCategoryBean bean) {
		ItemCategoryDAO dao = new ItemCategoryDAOjdbc();

		ItemCategoryBean result = null;
		if (bean != null) {
			result = dao.insert(bean);
		}
		return result;

	}

	public ItemCategoryBean update(ItemCategoryBean bean) {
		ItemCategoryDAO dao = new ItemCategoryDAOjdbc();

		ItemCategoryBean result = null;
		if (bean != null) {
			result = dao.update(bean);
		}
		return result;
	}

	public boolean delete(int itemCategory) {
		ItemCategoryDAO dao = new ItemCategoryDAOjdbc();

		boolean result = false;
		if (itemCategory != 0) {
			result = dao.delete(itemCategory);
		}
		return result;
	}
}
