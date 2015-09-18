package items.model;

import java.io.FileInputStream;

import items.model.dao.ItemImagesDAOjdbc;

public class ItemImagesService {
	public int insert(ImagesBean bean, FileInputStream fis, long size){
	ItemImagesDAO dao = new ItemImagesDAOjdbc();
			
			int result = 0;
			if(bean!=null && fis!=null && size!=0){
				result = dao.insert(bean, fis, size);
			}
			return result;
		}
	
	public int update(ImagesBean bean, FileInputStream fis, long size){
		ItemImagesDAO dao = new ItemImagesDAOjdbc();
		
		int result = 0;
		if(bean!=null){
			result = dao.update(bean, fis, size);
		}
		return result;
	}
	
	public boolean delete(int itemId, int itemNo){
		ItemImagesDAO dao = new ItemImagesDAOjdbc();
		
		boolean result =false;
		if(itemId!=0 && itemNo!=0){
			result = dao.delete(itemId, itemNo);
		}
		return result;
	}
	
	public ImagesBean selectOneItem(int itemId){
		ItemImagesDAO dao = new ItemImagesDAOjdbc();
		
		ImagesBean result = null;
		if(itemId!=0){
			result = dao.selectOneItem(itemId);
		}
		return result;
	}
	
	
}
