package com.bca.dto;

public class OrderDetailForm {

	private int id;

	private int orderId;

	private String createdOrder;

	private String createdPayment;

	private String checkoutDate;

	private String status;

	private String image;

	private String model;

	// harga per produk
	private double price;

	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCreatedOrder() {
		return createdOrder;
	}

	public void setCreatedOrder(String createdOrder) {
		this.createdOrder = createdOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCreatedPayment() {
		return createdPayment;
	}

	public void setCreatedPayment(String createdPayment) {
		this.createdPayment = createdPayment;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

}
