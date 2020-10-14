package com.bca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bca.dto.AddressForm;

@Entity
@Table(name = "tb_addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	private User user;

	@ManyToOne
	private PostalCode postalCode;

	@Column(length = 50, nullable = false)
	private String receiverName;

	@Column(length = 1000, nullable = false)
	private String address;

	@Column(length = 50, nullable = false)
	private String phoneNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = postalCode;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public AddressForm toForm() {
		AddressForm form = new AddressForm();

		form.setId(this.id);
		form.setUserId(this.user.getId());
		form.setPostalCodes(String.valueOf(this.postalCode.getPostalCode()));
		form.setReceiverName(this.receiverName);
		form.setAddress(this.address);
		form.setPhoneNumber(this.phoneNumber);

		return form;
	}
}
