package items.model;

import java.util.ArrayList;
import java.util.List;

import items.model.dao.ItemsDAOjdbc;

public class ItemsService {

	public List<ItemsBean> select (ItemsBean bean){
		ItemsDAO dao = new ItemsDAOjdbc();
		
		List<ItemsBean> result = null;
		if(bean!=null && bean.getItemId()!=0){
			ItemsBean temp = dao.selectId(bean.getItemId());
			if(temp!=null){
				result = new ArrayList<ItemsBean>();
				result.add(temp);
			}
		}else{
			result = dao.getAll();
		}
		return result;
	}
	
	public ItemsBean getOneItemId(int itemId) {
		ItemsDAO dao = new ItemsDAOjdbc();
		return dao.selectId(itemId);
	}
	
	public ItemsBean insert(ItemsBean bean, List<ImageInput> list){
		ItemsDAO dao = new ItemsDAOjdbc();
		
		ItemsBean result = null;
		if(bean!=null){
			result = dao.insert(bean, list);
		}
		return result;
	}
	
	public ItemsBean update(ItemsBean bean){
		ItemsDAO dao = new ItemsDAOjdbc();
		
		ItemsBean result = null;
		if(bean!=null){
			result = dao.update(bean);
		}
		return result;
	}
	
	public boolean delete(int itemId){
		ItemsDAO dao = new ItemsDAOjdbc();
		
		boolean result = false;
		if(itemId != 0){
			result = dao.delete(itemId);
		}
		return result;
	}
	
	
	
}
