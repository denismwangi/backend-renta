package com.renta.app.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "house")

public class House {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "houseId")
        private Long id;



            @NotNull
        @Size(max = 30)
        private String category;
        	  @NotNull
	  @Size(max = 20)
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
        private String imgpath;


    private Long userId;




//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(	name = "house_owners",
//            joinColumns = @JoinColumn(name = "house_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private Set<User> owner = new HashSet<>();

//  public House(){
//
//  }
    public House(Long id, String category, String roomSize, String price, String location, String description, String imgpath, Long userId) {
        this.id = id;
        this.category = category;
        this.roomSize = roomSize;
        this.price = price;
        this.location = location;
        this.description = description;
        this.imgpath = imgpath;
        this.userId = userId;
    }

    public House() {

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

    public String getPath() {
        return imgpath;
    }

    public String setPath(String imgpath) {
        this.imgpath = imgpath;
        return imgpath;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

//    public void setOwner(Set<User> owner) {
//        this.owner = owner;
//    }
//    public Set<User> getOwner() {
//        return owner;
//    }


}
