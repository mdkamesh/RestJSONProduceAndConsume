package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "WMAPAPI")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fields {

	@Id
	private int ID;

	private String Status;

	private Integer Position;

	private String Modified;

	public int getID() {
		return ID;
	}

	public void setID(Object object) {
		ID = (int) object;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(Object object) {
		Status = (String) object;
	}

	public Integer getPosition() {
		return Position;
	}

	public void setPosition(Object object) {
		Position = (Integer) object;
	}

	public String getModified() {
		return Modified;
	}

	public void setModified(Object object) {
		Modified = (String) object;
	}

}
