package com.bca.dto;

import javax.validation.constraints.NotEmpty;

public class CheckoutForm {

	private int id;

	private int userId;

	@NotEmpty(message = "Alamat is required")
	private String address;

	@NotEmpty(message = "x is required")
	private String receiver;

	@NotEmpty(message = "x is required")
	private String phone;

	@NotEmpty(message = "x is required")
	private String postalcode;

	@NotEmpty(message = "x is required")
	private String district;

	@NotEmpty(message = "x is required")
	private String urban;

	@NotEmpty(message = "x is required")
	private String province;

	@NotEmpty(message = "x is required")
	private String city;

	@NotEmpty(message = "x is required")
	private String courier;

	@NotEmpty(message = "x is required")
	private String service;

	private String fee;

	@NotEmpty(message = "x is required")
	private String paymentMethod;

	// price * qty
	private double subTotal;

	private double shippingFee;

	// subtotal + shipping fee
	private double totalPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(double shippingFee) {
		this.shippingFee = shippingFee;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getUrban() {
		return urban;
	}

	public void setUrban(String urban) {
		this.urban = urban;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}
}
