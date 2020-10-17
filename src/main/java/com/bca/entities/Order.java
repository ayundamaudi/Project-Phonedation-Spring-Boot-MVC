package com.bca.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column
	private String id;

	@ManyToOne
	private User user;

	@ManyToOne
	private Address address;

	@ManyToOne
	private PaymentMethod paymentMethod;

	@Column(length = 15)
	private String courier;

	@Column(length = 15)
	private String service;

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

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date checkoutDate;

	@PrePersist
	public void setDateJoined() {
		this.createdOrder = new Date();
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	@Override
	public String toString() {
		return "Order [address=" + address + ", checkoutDate=" + checkoutDate + ", courier=" + courier + ", createdOrder="
				+ createdOrder + ", createdPayment=" + createdPayment + ", id=" + id + ", paymentMethod=" + paymentMethod
				+ ", receiptNumber=" + receiptNumber + ", service=" + service + ", shippingFee=" + shippingFee + ", status="
				+ status + ", subTotal=" + subTotal + ", totalPrice=" + totalPrice + ", user=" + user + "]";
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
