package com.bca.dto;

import javax.validation.constraints.NotEmpty;

public class AddressForm {

	private int id;
	
    private int userId;
    
	@NotEmpty(message="Nama Penerima is required")
    private String receiverName;

	@NotEmpty(message="Kode Pos is required")
	private String postalCodes;
	
	@NotEmpty(message="Provinsi is required")
	private String province;

	@NotEmpty(message="Kota Pos is required")
	private String city;

	@NotEmpty(message="Kecamatan Pos is required")
	private String district;

	@NotEmpty(message="Kelurahan Pos is required")
	private String urban;

	@NotEmpty(message="Alamat Lengkap is required")
    private String address;
	
	@NotEmpty(message="Nomor Handphone is required")
	private String phoneNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getPostalCodes() {
		return postalCodes;
	}

	public void setPostalCodes(String postalCodes) {
		this.postalCodes = postalCodes;
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

	
}
