package com.bca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_postalcodes")
public class PostalCode {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postalCode;
	
	@Column(length = 50, nullable = false)
    private String province;
	
	@Column(length = 50, nullable = false)
    private String city;
	
	@Column(length = 50, nullable = false)
    private String district;
	
	@Column(length = 50, nullable = false)
    private String urban;

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
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

}
