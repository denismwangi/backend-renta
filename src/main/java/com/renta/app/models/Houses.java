package com.renta.app.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "houses")
public class Houses {
	
	 @Id
	  @GeneratedValue(generator = "uuid")
	  @GenericGenerator(name = "uuid", strategy = "uuid2")
	 @Column(length = 36, nullable = false, updatable = false)
	  private String id;

	  
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
	  
//	  @NotNull
//	  private String hPhoto;
	  
	  
	  @ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(	name = "house_images", 
					joinColumns = @JoinColumn(name = "house_id"), 
					inverseJoinColumns = @JoinColumn(name = "file_id"))
	  
	  private Set<houseImage> houseimages = new HashSet<>();

	public  Houses() {
	  }
	public Houses( String id , @NotNull @Size(max = 20) String location,
			String roomSize, @NotNull @Size(max = 20) String price, @NotNull @Size(max = 30) String category,
			@NotNull @Size(max = 200) String description) {
		//super();
		this.id = id;
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
	
//		public String gethPhoto() {
//			return hPhoto;
//		}
//
//		public void sethPhoto(String hPhoto) {
//			this.hPhoto = hPhoto;
//		}
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



	  
	  
	  

}
