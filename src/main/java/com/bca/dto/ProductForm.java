package com.bca.dto;

import javax.validation.constraints.NotEmpty;

public class ProductForm {

	private int id;

	private int brandId;

	@NotEmpty(message="Model Penerima is required")
	private String model;

	@NotEmpty(message="Memori Internal is required")
	private String internalMemory;

	@NotEmpty(message="RAM is required")
	private String ram;

	@NotEmpty(message="Color is required")
	private String color;

	@NotEmpty(message="Deskripsi is required")
	private String description;

	private int stock;

	private int sold;

	private double price;
	
	private double weight;

	@NotEmpty(message="Gambar is required")
	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getInternalMemory() {
		return internalMemory;
	}

	public void setInternalMemory(String internalMemory) {
		this.internalMemory = internalMemory;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
