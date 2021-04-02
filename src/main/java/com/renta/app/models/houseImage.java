package com.renta.app.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "files")
public class houseImage {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "file_id")
  private String id;

  private String name;

  private String type;

  @Lob
  private byte[] data;
  
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "house_images",
		  joinColumns = @JoinColumn(name = "image_id"),
          inverseJoinColumns = @JoinColumn(name = "house_id"))
  
  private Collection<Houses> houses = new ArrayList<>();

  public Collection<Houses> getHouses() {
	return houses;
}

public void setHouses(Collection<Houses> houses) {
	this.houses = houses;
}

public houseImage() {
  }

  public houseImage(String name, String type, byte[] data) {
    this.name = name;
    this.type = type;
    this.data = data;
  }

  public String getId() {
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
