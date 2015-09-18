package search.model;

import java.util.List;

import items.model.ItemsBean;
import search.model.dao.SearchDAOJdbc;


public class SearchService {
	private SearchDAO dao = null;
	
	public SearchService(){
		dao = new SearchDAOJdbc();
	}
	
	public List<ItemsBean> getItemsByKeyword(String keyword){
		return dao.getItemsByKeyword(keyword);
	}
	
	public List<ItemsBean> getItemsWithOption(int option,String keyword){
		return dao.getItemsWithOption(option, keyword) ;
	}
	
	
	
	
	
	
	
}
