package items.model;

import java.io.FileInputStream;

public class ImageInput {
	private FileInputStream fis;
	private long size;
	public FileInputStream getFis() {
		return fis;
	}
	public void setFis(FileInputStream fis) {
		this.fis = fis;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	
}
