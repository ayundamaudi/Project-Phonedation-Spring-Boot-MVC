package com.bca.dto;

import javax.validation.constraints.NotEmpty;

public class UserForm {

	private int id;
	
	@NotEmpty(message="E-mail is required")
    private String email;
	
	@NotEmpty(message="Passowrd is required")
    private String password;
	
	@NotEmpty(message="Nama Lengkap is required")
    private String fullname;

    private String photo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

    
}
