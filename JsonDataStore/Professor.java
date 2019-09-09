package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Professor {

	@Id
	private Long pId;

	private String pName;
	
	private String pSubjectName;
	
	private String pAddress;
	
	

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}
	
	
	

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpSubjectName() {
		return pSubjectName;
	}

	public void setpSubjectName(String pSubjectName) {
		this.pSubjectName = pSubjectName;
	}

	public String getpAddress() {
		return pAddress;
	}

	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	@Override
	public String toString() {
		return "Professor [pId=" + pId + ", pName=" + pName + ", pSubjectName=" + pSubjectName + ", pAddress="
				+ pAddress + "]";
	}

	

	
}
