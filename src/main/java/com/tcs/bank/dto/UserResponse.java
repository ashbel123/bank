package com.tcs.bank.dto;

public class UserResponse {
	private Long id;
	private String name;
	private String email;
	private String username;
//	private String address;
	private String mobile;
	
	public UserResponse(Long id,String name, String email, String username, String mobile ) {
		super();
		this.id=id;
		this.name = name;
		this.email = email;
		this.username = username;
//		this.address = address;
		this.mobile = mobile;
	}
	
	public UserResponse() {
		super();
	}

    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id=id;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
}
