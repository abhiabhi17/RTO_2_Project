package com.rto.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OwnerAddressModel {
	
	private Integer oaid;
	private Integer hno;
	private String streetno;
	private String city;
	private Integer zip;
	public Integer getOaid() {
		return oaid;
	}
	public void setOaid(Integer oaid) {
		this.oaid = oaid;
	}
	public Integer getHno() {
		return hno;
	}
	public void setHno(Integer hno) {
		this.hno = hno;
	}
	public String getStreetno() {
		return streetno;
	}
	public void setStreetno(String streetno) {
		this.streetno = streetno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	

}
