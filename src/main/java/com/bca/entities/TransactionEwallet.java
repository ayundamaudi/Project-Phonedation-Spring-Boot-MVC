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
@Table(name = "tb_transactionewallets")
public class TransactionEwallet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Ewallet sender;
	
	@ManyToOne
	private Ewallet receiver;

	@Column
    private double amount;
	
	// transaksi apa ? ex: send balance ke user lain or topup ewallet
	@Column(length = 100, nullable = false)
    private String transaction;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTransaction;

	@PrePersist
	public void setDateTransaction() {
		this.dateTransaction = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Ewallet getSender() {
		return sender;
	}

	public void setSender(Ewallet sender) {
		this.sender = sender;
	}

	public Ewallet getReceiver() {
		return receiver;
	}

	public void setReceiver(Ewallet receiver) {
		this.receiver = receiver;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	

}
