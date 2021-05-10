package com.renta.app.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "house")

public class House {




    //	 @Id
//	  @GeneratedValue(generator = "uuid")
//	  @GenericGenerator(name = "uuid", strategy = "uuid2")
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "houseId")
        private Long id;


        @NotNull
        @Size(max = 30)
        private String category;


        //	  @NotNull
//	  @Size(max = 20)
        private String roomSize;

        @NotNull
        @Size(max = 20)
        private String price;


        @NotNull
        @Size(max = 20)
        private String location;



        @NotNull
        @Size(max = 200)
        private String description;
    private String name;

    private String type;

    @Lob
    private byte[] data;
  public House(){}

//    public House(Long id, String category, String roomSize, String price, String location, String description, String name, String type, byte[] data) {
//        this.id = id;
//
//    }

    public House(String category, String roomSize, String price, String location, String description, String name, String type, byte[] data) {
        this.category = category;
        this.roomSize = roomSize;
        this.price = price;
        this.location = location;
        this.description = description;
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getRoomSize() {
        return roomSize;
    }

    public String getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public byte[] getData() {
        return data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRoomSize(String roomSize) {
        this.roomSize = roomSize;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

}
