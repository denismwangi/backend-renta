package com.renta.app.payload.response;

public class HouseResponseFile {

	private String imgName;
	private String imgurl;
	

	private String type;
	private long size;
	private String location;
	private String roomSize;
	private String price;
	private String category;
	private String description;
	
	public HouseResponseFile(String imgName, String imgurl, String type, long size, String location, String roomSize,
			String price, String category, String description) {
		//super();
		this.imgName = imgName;
		this.imgurl = imgurl;
		this.type = type;
		this.size = size;
		this.location = location;
		this.roomSize = roomSize;
		this.price = price;
		this.category = category;
		this.description = description;
	}
	
	

	
	public String getType() {
		return type;
	}
	public String getImgName() {
		return imgName;
	}
	public String getImgurl() {
		return imgurl;
	}




	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}


	public void setImgName(String imgName) {
		this.imgName = imgName;
	}


	public void setType(String type) {
		this.type = type;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(String roomSize) {
		this.roomSize = roomSize;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
