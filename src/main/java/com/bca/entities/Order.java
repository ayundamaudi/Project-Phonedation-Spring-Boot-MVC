package com.bca.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Address address;
	
	@ManyToOne
	private Shipment shipment;
	
	@ManyToOne
	private PaymentMethod paymentMethod;
	
	// price * qty
	@Column
    private double subTotal;

	@Column
    private double shippingFee;
	
	// subtotal + shipping fee
	@Column
    private double totalPrice;

	@Column(length = 20, nullable = false)
    private String status;
	
	@Column(length = 100)
    private String receiptNumber;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
    private Date createdOrder;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
    private Date createdPayment;

	@PrePersist
	public void setDateJoined() {
		this.createdOrder = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	public Date getCreatedOrder() {
		return createdOrder;
	}

	public void setCreatedOrder(Date createdOrder) {
		this.createdOrder = createdOrder;
	}

	public Date getCreatedPayment() {
		return createdPayment;
	}

	public void setCreatedPayment(Date createdPayment) {
		this.createdPayment = createdPayment;
	}
	
	

}
