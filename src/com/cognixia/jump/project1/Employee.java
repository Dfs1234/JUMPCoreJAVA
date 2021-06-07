package com.cognixia.jump.project1;

import java.io.Serializable;
import java.time.LocalDateTime; 

public class Employee implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static int count = 0;
	
	private String firstName;
	private String lastName;
	private int employeeID;
	private LocalDateTime dateofEmployment;
	private double salary;
	
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, int employeeID, LocalDateTime dateofEmployment, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeID = employeeID;
		this.dateofEmployment = dateofEmployment;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public LocalDateTime getDateofEmployment() {
		return dateofEmployment;
	}

	public void setDateofEmployment(LocalDateTime dateofEmployment) {
		this.dateofEmployment = dateofEmployment;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", employeeID=" + employeeID
				+ ", dateofEmployment=" + dateofEmployment + ", salary=" + salary + "]";
	}
	
}
