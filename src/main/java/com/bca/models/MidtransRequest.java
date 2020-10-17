package com.bca.models;

public class MidtransRequest {

  public class TransactionDetails {
    private String orderId;
    private int grossAmount;

    public TransactionDetails(int grossAmount) {
      this.orderId = String.valueOf((int) Math.random() * 99999999);
      this.grossAmount = grossAmount;
    }

    public String getOrderId() {
      return orderId;
    }

    public void setOrderId(String orderId) {
      this.orderId = orderId;
    }

    public int getGrossAmount() {
      return grossAmount;
    }

    public void setGrossAmount(int grossAmount) {
      this.grossAmount = grossAmount;
    }
  }

  private TransactionDetails transactionDetails;

  public MidtransRequest(int grossAmount) {
    this.transactionDetails = new TransactionDetails(grossAmount);
  }

  public TransactionDetails getTransactionDetails() {
    return transactionDetails;
  }

  public void setTransactionDetails(TransactionDetails transactionDetails) {
    this.transactionDetails = transactionDetails;
  }

}
