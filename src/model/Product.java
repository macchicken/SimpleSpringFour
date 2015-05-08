package model;

import java.io.Serializable;

public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String imgUrl;
	private String title;
	private String description;

	public Product(String id,String imgUrl,String title) {
		super();
		this.id=id;
		this.imgUrl = imgUrl;
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
