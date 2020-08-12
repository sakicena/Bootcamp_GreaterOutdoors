package com.cg.greatoutdoor.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "great_outdoor_user")
public class User {
	
	

	@Id	
    @Column(name="user_Id")
//	@Range( min=1,max = Long.MAX_VALUE)
//	@GeneratedValue(strategy = GenerationType.TABLE)
	private int userId;
	
	@Column(name="USERNAME",length=30,nullable=false,unique=true)
	private String userName;

	@Column(name="PASSWORD",nullable=false,length = 20)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name="ROLE",length = 20,nullable=false)
	private Role role;

	@Column(name="PHONENUMBER",length = 16,unique=true,nullable=false)
	private String phoneNumber;

	@Column(name="EMAIL",length = 50,unique=true,nullable=false)
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Address> address = new HashSet<Address>();
	
	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Wishlist> product = new ArrayList<Wishlist>();

	


	public List<Wishlist> getProduct() {
		return product;
	}

	public void setProduct(List<Wishlist> product) {
		this.product = product;
	}

	public User( String userName, String password, Role role,
			 String email ,String phoneNumber) {
		super();
		
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public User(String userName, String password,  String email,String phoneNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	
	
	public User(int userId, String userName, String password, Role role, String phoneNumber, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address + "]";
	}

	
	
	
}
