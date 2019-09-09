package com.example.demo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity()
@Table(name = "TEMP")
public class PositionStatus {
	
	private Fields fields;
	
	private List<Fields> values;

	public Fields getFields() {
		return fields;
	}

	public void setFields(Fields fields) {
		this.fields = fields;
	}

	public List<Fields> getValues() {
		return values;
	}

	public void setValues(List<Fields> values) {
		this.values = values;
	}
	
	
	
	

	
	

}
