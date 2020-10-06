package com.bca.dto;

import javax.validation.constraints.NotEmpty;

public class BrandForm {

	private int id;
	
	@NotEmpty(message="Nama brand is required")
    private String brand;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	

}
