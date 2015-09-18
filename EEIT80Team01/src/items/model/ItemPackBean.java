package items.model;

public class ItemPackBean {
	private ItemsBean itemsBean;
	private ImagesBean imagesBean;
	public ItemPackBean(){
		itemsBean = new ItemsBean();
		imagesBean = new ImagesBean();
	}
	public ItemsBean getItemsBean() {
		return itemsBean;
	}
	public void setItemsBean(ItemsBean itemsBean) {
		this.itemsBean = itemsBean;
	}
	public ImagesBean getImagesBean() {
		return imagesBean;
	}
	public void setImagesBean(ImagesBean imagesBean) {
		this.imagesBean = imagesBean;
	}
	
}
