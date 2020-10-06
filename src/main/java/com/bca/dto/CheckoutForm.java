package com.bca.dto;

import javax.validation.constraints.NotEmpty;

public class CheckoutForm {

	private int id;
	
	@NotEmpty(message="Alamat is required")
	private String address;
	
	@NotEmpty(message="Provinsi is required")
	private String shipments;
	
	@NotEmpty(message="Provinsi is required")
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

	public String getShipments() {
		return shipments;
	}

	public void setShipments(String shipments) {
		this.shipments = shipments;
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


    
}
