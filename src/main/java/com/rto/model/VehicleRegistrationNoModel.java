package com.rto.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleRegistrationNoModel {
	
	private Integer vregid;
	private String regDate;
	private String regNo;
	private String regCenter;
	private String createDate;
	private String updateDate;
	public Integer getVregid() {
		return vregid;
	}
	public void setVregid(Integer vregid) {
		this.vregid = vregid;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "VehicleRegistrationNoModel [vregid=" + vregid + ", regDate=" + regDate + ", regNo=" + regNo
				+ ", regCenter=" + regCenter + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

}
