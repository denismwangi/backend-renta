package com.renta.app.models;

import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class houseImage {
//  @Id
//  @GeneratedValue(generator = "uuid")
//  @GenericGenerator(name = "uuid", strategy = "uuid2")
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
//  @Column(name = "file_id")
//  private Long id;

  private String name;

  private String type;

  @Lob
  @Type(type = "org.hibernate.type.ImageType")
  private byte[] data;
  
//  @ManyToMany(cascade = CascadeType.ALL)
//  @JoinTable(name = "house_images",
//		  joinColumns = @JoinColumn(name = "image_id"),
//          inverseJoinColumns = @JoinColumn(name = "house_id"))
//
//  private Collection<Houses> houses = new ArrayList<>();
//
//  public Collection<Houses> getHouses() {
//	return houses;
//}
//
//public void setHouses(Collection<Houses> houses) {
//	this.houses = houses;
//}

public houseImage() {
  }

  public houseImage(String name, String type, byte[] data) {
    this.name = name;
    this.type = type;
    this.data = data;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

}
