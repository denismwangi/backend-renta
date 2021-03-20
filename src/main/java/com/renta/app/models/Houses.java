package com.renta.app.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "houses")
public class Houses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	
	  

	private String imgName;
	//private String imgUrl;
	private String type;
	  @Lob
	  private byte[] data;
	  
	  @NotNull
	  @Size(max = 20)
	  private String location;
	  
//	  @NotNull
//	  @Size(max = 20)
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
	  
//	  @NotNull
//	  private String hPhoto;
	  
	  

	public  Houses() {
	  }
	public Houses( String imgName, String type, byte[] data, @NotNull @Size(max = 20) String location,
			String roomSize, @NotNull @Size(max = 20) String price, @NotNull @Size(max = 30) String category,
			@NotNull @Size(max = 200) String description) {
		//super();
		this.id = id;
		this.imgName = imgName;
		this.type = type;
		this.data = data;
		this.location = location;
		this.roomSize = roomSize;
		this.price = price;
		this.category = category;
		this.description = description;
	}
	  

	public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
//		public String gethPhoto() {
//			return hPhoto;
//		}
//
//		public void sethPhoto(String hPhoto) {
//			this.hPhoto = hPhoto;
//		}


		 public String getImgName() {
				return imgName;
			}

			public void setImgName(String imgName) {
				this.imgName = imgName;
			}

//			public String getImgUrl() {
//				return imgUrl;
//			}
//
//			public void setImgUrl(String imgUrl) {
//				this.imgUrl = imgUrl;
//			}
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
