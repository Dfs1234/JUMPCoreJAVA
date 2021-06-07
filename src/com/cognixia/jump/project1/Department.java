package com.cognixia.jump.project1;

import java.io.Serializable;

public class Department  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String phone;
	private String location;
	private Double budget; 
	
	public Department() {
		super();
	}
	
	public Department(String name, String phone, String location, Double budget) {
		super();
		this.name = name;
		this.phone = phone;
		this.location = location;
		this.budget = budget;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", phone=" + phone + ", location=" + location + ", budget=" + budget + "]";
	}
}
