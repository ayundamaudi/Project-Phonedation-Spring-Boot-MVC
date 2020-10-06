package com.bca.dto;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.bca.entities.Addresses;
import com.bca.entities.PaymentMethod;
import com.bca.entities.Shipments;

public class CheckoutForm {

	private int id;
	
	@NotEmpty(message="Alamat is required")
	private Addresses addresses;
	
	@NotEmpty(message="Provinsi is required")
	private Shipments shipments;
	
	@NotEmpty(message="Provinsi is required")
	private PaymentMethod paymentMethod;
	
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

	public Addresses getAddresses() {
		return addresses;
	}

	public void setAddresses(Addresses addresses) {
		this.addresses = addresses;
	}

	public Shipments getShipments() {
		return shipments;
	}

	public void setShipments(Shipments shipments) {
		this.shipments = shipments;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
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
