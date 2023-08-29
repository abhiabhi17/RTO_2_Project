package com.rto.entity;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="vehicle_registration")
public class VehicleRegistrationNoEntity {
	@Column(name = "vregid")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_address_id_generator")
	@SequenceGenerator(name="owner_address_id_generator",
	                   initialValue = 1,allocationSize = 1,
	                   sequenceName = "vehicle_registration_id_seq")
    private Integer vregid;
	
	
	
	@Column(name = "regDate",updatable = false)
	@CreationTimestamp
	private Date regDate;
	
	@Column(name="regNo")
	private String regNo;
	
	@Column(name = "regCenter")
	private String regCenter;
	
	@Column(name="createDate",updatable = false)
	@CreationTimestamp
	private Date CreateDate;
	
	@Column(name="updateDate")
	@UpdateTimestamp
	private Date updateDate;
	
	
	@OneToOne(targetEntity = VehicleOwnerRegistrationEntity.class,
			 cascade=CascadeType.MERGE,
			  fetch=FetchType.LAZY
			  )
	@JoinColumn(name="v_own_id",referencedColumnName ="oid",nullable = false)
	private VehicleOwnerRegistrationEntity vihcleOwnEntity;


	public Integer getVregid() {
		return vregid;
	}


	public void setVregid(Integer vregid) {
		this.vregid = vregid;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public String getRegNo() {
		return regNo;
	}


	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}


	public String getRegCenter() {
		return regCenter;
	}


	public void setRegCenter(String regCenter) {
		this.regCenter = regCenter;
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
		return "VehicleRegistrationNoEntity [vregid=" + vregid + ", regDate=" + regDate + ", regNo=" + regNo
				+ ", regCenter=" + regCenter + ", CreateDate=" + CreateDate + ", updateDate=" + updateDate
				+ ", vihcleOwnEntity=" + vihcleOwnEntity + "]";
	}


}
