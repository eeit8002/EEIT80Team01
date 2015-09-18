package search.model;

import java.util.List;

import items.model.ItemsBean;

public interface SearchDAO {

	List<ItemsBean> getItemsByKeyword(String keyword);

	List<ItemsBean> getItemsWithOption(int option, String keyword);

}