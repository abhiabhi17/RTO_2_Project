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
@Table(name="vehicle_details")
public class VehicleDetailsEntity {
	@Column(name = "vid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_details_id_generator")
	@SequenceGenerator(name="vehicle_details_id_generator",
	                   initialValue = 1,allocationSize = 1,
	                   
	                   sequenceName = "vhcl_details_id_seq")
    @Id
	private Integer vid;
	
	@Column(name="type")
	private String type;
	
	@Column(name="year")
	private Integer year;
	
	@Column(name="vcompanyname")
	private String vcompanyname;
	
	@Column(name="createDate",updatable = false)
	@CreationTimestamp
	private Date CreateDate;
	
	@Column(name="updateDate")
	@UpdateTimestamp
	private Date updateDate;
	
/*	@OneToOne(targetEntity = VehicleOwnerRegistrationEntity.class,
			 cascade=CascadeType.ALL,fetch = FetchType.EAGER
			  )
	@JoinColumn(name="v_own_id",
	            referencedColumnName ="oid",
	            nullable = false)*/
   @OneToOne
   @JoinColumn(name="v_own_id",nullable = false)
	private VehicleOwnerRegistrationEntity vehicleOwn;

public Integer getVid() {
	return vid;
}

public void setVid(Integer vid) {
	this.vid = vid;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public Integer getYear() {
	return year;
}

public void setYear(Integer year) {
	this.year = year;
}

public String getVcompanyname() {
	return vcompanyname;
}

public void setVcompanyname(String vcompanyname) {
	this.vcompanyname = vcompanyname;
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

public VehicleOwnerRegistrationEntity getVehicleOwn() {
	return vehicleOwn;
}

public void setVehicleOwn(VehicleOwnerRegistrationEntity vehicleOwn) {
	this.vehicleOwn = vehicleOwn;
}

@Override
public String toString() {
	return "VehicleDetailsEntity [vid=" + vid + ", type=" + type + ", year=" + year + ", vcompanyname=" + vcompanyname
			+ ", CreateDate=" + CreateDate + ", updateDate=" + updateDate + ", vehicleOwn=" + vehicleOwn + "]";
}



}
