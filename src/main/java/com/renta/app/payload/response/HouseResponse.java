package com.renta.app.payload.response;

public class HouseResponse {

    private Long id;
    private String category;
    private String roomSize;
    private String price;
    private String location;
    private String description;
    private String imgurl;



    public HouseResponse(Long id, String category, String roomSize, String price, String location, String description, String imgurl) {
        this.id = id;
        this.category = category;
        this.roomSize = roomSize;
        this.price = price;
        this.location = location;
        this.description = description;
        this.imgurl = imgurl;



    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }




}
