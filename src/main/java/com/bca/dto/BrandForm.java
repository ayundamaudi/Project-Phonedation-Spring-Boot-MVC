package com.bca.dto;

import javax.validation.constraints.NotEmpty;

public class BrandForm {

	private int id;
	
	@NotEmpty(message="Nama brand is required")
    private String brand;

}
