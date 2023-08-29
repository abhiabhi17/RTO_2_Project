package com.rto.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;




@Entity
@Table(name="vehicle_owner_details")
public class VehicleOwnerRegistrationEntity {
	
	@Id
	@Column(name="oid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_id_generator")
	@SequenceGenerator(name="owner_id_generator",
	                   initialValue = 1,allocationSize = 1,
	                   sequenceName = "vhcl_owner_id_seq2")
	private Integer oid;
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="lname")
	private String lname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="ssn")
	private String ssn;
	
	
	@Column(name="createDate",updatable = false)
	@CreationTimestamp
	private Date CreateDate;
	
	@Column(name="updateDate")
	@UpdateTimestamp
	private Date updateDate;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
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

	@Override
	public String toString() {
		return "VehicleOwnerRegistrationEntity [oid=" + oid + ", fname=" + fname + ", lname=" + lname + ", email="
				+ email + ", dob=" + dob + ", ssn=" + ssn + ", CreateDate=" + CreateDate + ", updateDate=" + updateDate
				+ "]";
	}

}
