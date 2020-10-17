package com.bca.dto;

import java.util.Date;

public class OrderForm {

  private String id;

  private int userId;

  private int addressId;

  private int paymentMethodId;

  private String courier;

  private String service;

  private double subTotal;

  private double shippingFee;

  private double totalPrice;

  private String status;

  private String receiptNumber;

  private Date createdOrder;

  private Date createdPayment;

  private Date checkoutDate;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getAddressId() {
    return addressId;
  }

  public void setAddressId(int addressId) {
    this.addressId = addressId;
  }

  public int getPaymentMethodId() {
    return paymentMethodId;
  }

  public void setPaymentMethodId(int paymentMethodId) {
    this.paymentMethodId = paymentMethodId;
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
}