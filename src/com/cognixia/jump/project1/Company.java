package com.cognixia.jump.project1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;


public class Company implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<Department, List<Employee>> ems;

	public Company() {
		ems = new HashMap<Department, List<Employee>>();
	}

	public boolean updateDepartment(Department department) {
		Department oldDepartment = ems.keySet()
									.stream()
									.filter(d -> d.getName().equals(department.getName()))
									.findFirst()
									.get();
		if(ems.containsKey(oldDepartment)) {
			Set<Department> departments = ems.keySet();
			for(Department d : departments) {
				if(d.equals(oldDepartment)) {
					d.setName(department.getName());
					d.setBudget(department.getBudget());
					d.setPhone(department.getPhone());
					d.setLocation(department.getLocation());
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean updateDepartment(Department department, Department oldDepartment) {
		System.out.println(oldDepartment);
		if(ems.containsKey(oldDepartment)) {
			Set<Department> departments = ems.keySet();
			for(Department d : departments) {
				System.out.println("x");
				if(d.equals(oldDepartment)) {
					System.out.println(d);
					d.setName(department.getName());
					d.setBudget(department.getBudget());
					d.setPhone(department.getPhone());
					d.setLocation(department.getLocation());
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean addDepartment(Department department) {
		if(!ems.containsKey(department)) {
			ems.put(department, new ArrayList<Employee>());
			return true;
		}
		return false;
	}
	
	public boolean removeDepartment(Department department) {
		if(ems.containsKey(department)) {
			ems.remove(department);
			return true;
		}
		return false;
	}
	
	public void departmentInfo() {
		ems.keySet().forEach(System.out::println);
	}
	
	public boolean addEmployee(Department d, Employee e) {
		if(ems.containsKey(d)) {
			List<Employee> employees = ems.get(d);
			if(employees == null) {
				employees = new ArrayList<Employee>();
			}
			employees.add(e);
			ems.replace(d, employees);
			return true;
		}
		return false;
	}
	
	public boolean removeEmployee(Department d, Employee e) {
		if(ems.containsKey(d)){
			List<Employee> employees = ems.get(d);
			employees.remove(e);
			ems.replace(d, employees);
			return true;
		}
		return false;
	}
	
	public void infomation() {
		for(Entry<Department, List<Employee>> entry: ems.entrySet()) {
			System.out.println(entry.getKey());
			entry.getValue().forEach(System.out::println);
			System.out.println();
		}
	}
	
	public Department findByName(String name) throws UnableToFindException {
		Department department = ems.keySet()
				.stream()
				.filter(d -> d.getName().equals(name))
				.findFirst()
				.get();
		if(department == null) {
			throw new UnableToFindException("unable to find the department.");
		}
		return department;
	}
	
	public void changeDepartment(Department oldD, Department d, Employee e) {
		if(this.removeEmployee(oldD, e)) {
			System.out.println("remove " + e.getFirstName() + " " + e.getLastName() + " from the " + oldD.getName());
			if(this.addEmployee(d, e)) {
				System.out.println("add " + e.getFirstName() + " " + e.getLastName() + " from the " + d.getName());
			}
		}
	}
}
