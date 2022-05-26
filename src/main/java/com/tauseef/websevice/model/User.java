package com.tauseef.websevice.model;

public class User {

	public int userId;
	public String name;
	public String email;
	public String address;
	public boolean isActive;
	
	
	public User() {}
	public User(int userId, String name, String email, String address, boolean isActive) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.isActive = isActive;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
