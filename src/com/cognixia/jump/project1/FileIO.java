package com.cognixia.jump.project1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileIO {
	private File company = new File("resources/company.data");
	private File employee = new File("resources/employee.data");
	
	public FileIO() {
		try {
			company.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			employee.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeToComapnyFile(Company c) {
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(this.company))) {
			writer.writeObject(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Company readFromComapnyFile() {
		Company company = new Company();
		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(this.company))) {
			company = (Company) reader.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return company;
	}
	
	public void writeToEmployeeFile(Employees employees) {
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(this.employee))) {
			writer.writeObject(employees);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Employees readFromEmployeeFile() {
		Employees employees = new Employees();
		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(this.employee))) {
			employees  = (Employees) reader.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
		
	}
}
