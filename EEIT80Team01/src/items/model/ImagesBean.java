package items.model;

import java.sql.Blob;

public class ImagesBean {
private int itemId;
private Blob image;
private int itemNo;

public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public Blob getImage() {
	return image;
}
public void setImage(Blob image) {
	this.image = image;
}
public int getItemNo() {
	return itemNo;
}
public void setItemNo(int itemNo) {
	this.itemNo = itemNo;
}

}
