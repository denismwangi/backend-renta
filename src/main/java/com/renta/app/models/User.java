package com.renta.app.models;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name  = "userId")
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String firstname;
	
	@NotBlank
	@Size(max = 20)
	private String lastname;
	
	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
//	@Email
	private String email;



	@NotBlank
	@Size(max = 14)
	private String phone;
	@NotBlank
	@Size(max = 120)
	private String password;
	@NotNull
	private Date dateCreated;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();



	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private List<House> house;


	public User() {
	}

	public User(String firstname, String lastname, String username, String email,String phone, String password ) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.dateCreated = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getDateCreated() {
	    return dateCreated;
	  }

	  public void setDateCreated(Date dateCreated) {
	    this.dateCreated = dateCreated;
	  }

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public List<House> getHouse() {
		return house;
	}

	public void setHouse(List<House> house) {
		this.house = house;
	}

}
