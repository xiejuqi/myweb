package com.xiejuqi.domain;

/**
 * 
 * @Filename Address.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年1月25日 下午3:58:05
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class Address {
	private String country;
	private String province;
	private String city;
	private String district;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	@Override
	public String toString() {
		return "Address [country=" + country + ", province=" + province + ", city=" + city + ", district=" + district
				+ "]";
	}

}
