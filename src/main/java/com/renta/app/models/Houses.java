package com.renta.app.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "houses")
public class Houses {
	
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




	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cc_fk",referencedColumnName = "houseId")
	private List<User> owner;

	public void setOwner(List<User> owner) {
		this.owner = owner;
	}

	public List<User> getOwner() {
		return owner;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cc_fk",referencedColumnName = "houseId")
	    private Collection<houseImage> houseimage = new ArrayList<>();




	public Collection<houseImage> getHouseimage() {
		return houseimage;
	}


	public void setHouseimage(Collection<houseImage> houseimage) {
		this.houseimage = houseimage;
	}


	public  Houses() {
	  }
	
	
//	public Houses( String id , @NotNull @Size(max = 20) String location,
//			String roomSize, @NotNull @Size(max = 20) String price, @NotNull @Size(max = 30) String category,
//			@NotNull @Size(max = 200) String description) {
//		//super();
//		this.id = id;
//		this.location = location;
//		this.roomSize = roomSize;
//		this.price = price;
//		this.category = category;
//		this.description = description;
//	}
	  
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
