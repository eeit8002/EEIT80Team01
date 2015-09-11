package items.model;

import java.util.ArrayList;
import java.util.List;

import items.model.dao.ItemsDAOjdbc;

public class ItemsService {
	private ItemsDAO itemsDAO = new ItemsDAOjdbc();
	public List<ItemsBean> select (ItemsBean bean){
		List<ItemsBean> result = null;
		if(bean!=null && bean.getItemId()!=0){
			ItemsBean temp = itemsDAO.selectId(bean.getItemId());
			if(temp!=null){
				result = new ArrayList<ItemsBean>();
				result.add(temp);
			}
		}else{
			result = itemsDAO.selectAll();
		}
		return result;
	}
	
	public ItemsBean insert(ItemsBean bean){
		ItemsBean result = null;
		if(bean!=null){
			result = itemsDAO.insert(bean);
		}
		return result;
	}
	
	public ItemsBean update(ItemsBean bean){
		ItemsBean result = null;
		if(bean!=null){
			result = itemsDAO.update(bean.getSeller(), bean.getBuyer(),bean.getItemCategory(), bean.getTitle(),
					bean.getStartPrice(), bean.getDirectPrice(), bean.getBid(), bean.getEndTime(),
					bean.getItemDiscribe(), bean.getItemStatus(), bean.getThreadLock(), 
					bean.getItemId());
		}
		return result;
	}
	
	public boolean delete(ItemsBean bean){
		boolean result = false;
		if(bean!=null){
			result = itemsDAO.delete(bean.getItemId());
		}
		return result;
	}
	
	
	
}
