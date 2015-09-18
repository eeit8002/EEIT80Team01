package items.model;

import java.io.FileInputStream;

import items.model.ImagesBean;

public interface ItemImagesDAO {

	int insert(ImagesBean bean, FileInputStream fis, long size);

	int update(ImagesBean bean, FileInputStream fis, long size);

	boolean delete(int itemId, int itemNo);

	ImagesBean selectOneItem(int itemId);

}