package com.cognixia.jump.project1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Employees implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Employee> employees;
	
	public Employees() {
		this.employees= new LinkedList<Employee>();
	}

	public Employees(List<Employee> employees) {
		super();
		this.employees = employees;
	}
	
	public boolean updateEmployee(Employee employee) {
		for(Employee e : employees) { 
			if(e.getEmployeeID() == employee.getEmployeeID()) {
				e.setFirstName(employee.getFirstName());
				e.setLastName(employee.getLastName());
				e.setSalary(employee.getSalary());
				return true;
			}
		}
		return false;
	}
	
	public boolean addEmployee(Employee employee) {
		System.out.println(employee);
		if(employees.add(employee)) {
			return true;
		}
		return false;
	}
	
	public boolean removeEmployee(Employee employee) {
		if(employees.remove(employee)) {
			return true;
		}
		return false;
	}
	
	public void employeesInfo() {
		employees.forEach(System.out::println);
	}
	
	public Employee findById(int i) throws Exception {
		Employee employee =employees.stream().filter(e -> e.getEmployeeID() == i).findFirst().get();
		if(employee == null) {
			throw new UnableToFindException("unable to find employee.");
		}
		return employee;
	}
}
