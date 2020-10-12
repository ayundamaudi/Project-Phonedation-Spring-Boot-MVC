package com.bca.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Brand brand;

	@OneToMany
	private List<Wishlist> wishlists;

	@OneToMany
	private List<OrderDetail> orderDetails;

	@Column(length = 100, nullable = false)
	private String model;

	@Column(length = 100, nullable = false)
	private String internalMemory;

	@Column(length = 100, nullable = false)
	private String ram;

	@Column(length = 100, nullable = false)
	private String color;

	@Column(length = 1000, nullable = false)
	private String description;

	@Column
	private int stock;

	@Column
	private int sold;

	@Column
	private double price;

	@Column
	private double weight;

	@Column
	private String image;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModified;

	@PrePersist
	public void setDateJoined() {
		this.dateCreated = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
