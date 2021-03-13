package com.renta.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "houses")
public class Houses {
	
	  @Id
	  @GeneratedValue(generator = "uuid")
	  @GenericGenerator(name = "uuid", strategy = "uuid2")
	  private String id;

	
	  private String name;
	  private String type;
	  @Lob
	  private byte[] data;
	  
	  @NotNull
	  @Size(max = 20)
	  private String location;
	  
	  @NotNull
	  @Size(max = 20)
	  private String roomSize;
	  
	  @NotNull
	  @Size(max = 20)
	  private String price;
	  @NotNull
	  @Size(max = 30)
	  private String category;
	  
	  @NotNull
	  @Size(max = 200)
	  private String description;
	  
	  public  Houses() {
	  }
	  
	  public Houses(String id, String name, String type, byte[] data,
				@NotNull @javax.validation.constraints.Size(max = 20) String location,
				@NotNull @javax.validation.constraints.Size(max = 20) String roomSize,
				@NotNull @javax.validation.constraints.Size(max = 20) String price,
				@NotNull @javax.validation.constraints.Size(max = 30) String category,
				@NotNull @javax.validation.constraints.Size(max = 200) String description) {
			//super();
			this.id = id;
			this.name = name;
			this.type = type;
			this.data = data;
			this.location = location;
			this.roomSize = roomSize;
			this.price = price;
			this.category = category;
			this.description = description;
		}
	  

	public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
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
