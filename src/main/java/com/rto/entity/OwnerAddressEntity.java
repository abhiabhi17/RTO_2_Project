package com.rto.entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table(name="owner_address")
public class OwnerAddressEntity {
	
	@Column(name = "oaid")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_address_id_generator")
	@SequenceGenerator(name="owner_address_id_generator",
	                   initialValue = 1,allocationSize = 1,
	                   sequenceName = "owner_address_id_seq")

	private Integer oaid;
	
	@Column(name = "hno")
	private Integer hno;
	
	@Column(name = "streetno")
	private String streetno;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "zip")
	private Integer zip;
	
	@Column(name="createDate",updatable = false)
	@CreationTimestamp
	private Date CreateDate;
	
	@Column(name="updateDate")
	@UpdateTimestamp
	private Date updateDate;
	
	/*@OneToOne(targetEntity = VehicleOwnerRegistrationEntity.class,
			 cascade=CascadeType.ALL,
			  fetch=FetchType.LAZY
			  )*/
	@OneToOne
	@JoinColumn(name="v_own_id",nullable = false)
	private VehicleOwnerRegistrationEntity vihcleOwnEntity;

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

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public VehicleOwnerRegistrationEntity getVihcleOwnEntity() {
		return vihcleOwnEntity;
	}

	public void setVihcleOwnEntity(VehicleOwnerRegistrationEntity vihcleOwnEntity) {
		this.vihcleOwnEntity = vihcleOwnEntity;
	}

	@Override
	public String toString() {
		return "OwnerAddressEntity [oaid=" + oaid + ", hno=" + hno + ", streetno=" + streetno + ", city=" + city
				+ ", zip=" + zip + ", CreateDate=" + CreateDate + ", updateDate=" + updateDate + ", vihcleOwnEntity="
				+ vihcleOwnEntity + "]";
	}


}
