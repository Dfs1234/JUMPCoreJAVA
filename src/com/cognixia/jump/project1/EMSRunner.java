package com.cognixia.jump.project1;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EMSRunner {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		FileIO file = new FileIO();
		Company company = file.readFromComapnyFile();
		Employees employees = file.readFromEmployeeFile();
		start(company, employees);
		file.writeToComapnyFile(company);
		file.writeToEmployeeFile(employees);
	}
	
	public static void start(Company c, Employees es) {
		boolean exit = true;
		do {
			System.out.println("Employee Management System");
			System.out.println("1  : New Employee\n"
							 + "2  : Update Employee\n"
							 + "3  : Remove Employee\n"
							 + "4  : Employees' Information\n"
							 + "5  : New Department\n"
							 + "6  : Update Department\n"
							 + "7  : Remove Department\n"
							 + "8  : Departments' Information\n"
							 + "9  : Departments with Employees Information\n"
							 + "10 : Change Employee's Department\n"
							 + "11 : Add Employee to A Department\n"
							 + "12 : Remove Employee from A Department\n"
							 + "13 : exit(Save the data to file)");
			try {
				int newInput = Integer.parseInt(scanner.nextLine());
				if(0 < newInput && newInput < 13) {
					switchTo(newInput, c, es);
				}else if(newInput == 13) {
					exit = false;
				}else {
					System.out.println("Invaild input");
				}
			}catch(InputMismatchException e) {
				System.out.println("Invaild input");
			}catch(NumberFormatException e) {
				System.out.println("Invaild input");
			}
		}while(exit);
		scanner.close();
	}
	
	public static void switchTo(int newInput, Company c, Employees es) {
		switch (newInput) {
		case 1:
			if(es.addEmployee(enterEmployeeinfo())){
				System.out.println("add new employee success");
			}else {
				System.out.println("unable to add employee");
			}
			break;
		case 2:
			if(es.updateEmployee(changeEmployeeById(es))) {
				System.out.println("update employee success");
			}else {
				System.out.println("unable to update employee");
			}
			break;
		case 3:
			if(es.removeEmployee(findEmployeeById(es))) {
				System.out.println("remove employee success");
			}else {
				System.out.println("unable to remove employee");
			}
			break;
		case 4:
			es.employeesInfo();
			break;
		case 5:
			if(c.addDepartment(enterDeparmentInfo())){
				System.out.println("add new department successful");
			}else {
				System.out.println("unable to add new department");
			}
			break;
		case 6:
			Department d = findDeparmentByName(c);
			if(c.updateDepartment(enterDeparmentInfo(), d)) {
				System.out.println("Update department successful");
			}else {
				System.out.println("unable to update department");
			}
			break;
		case 7:
			if(c.removeDepartment(findDeparmentByName(c))){
				System.out.println("remove the department successful");
			}else {
				System.out.println("unable to remove new department");
			}
			break;
		case 8:
			c.departmentInfo();
			break;
		case 9:
			c.infomation();
			break;
		case 10:
			changeDepertment(c, es);
			break;
		case 11:
			addEmployeeToDepartment(c, es);
			break;
		case 12:
			RemoveEmployeeToDepartment(c, es);
			break;
		}
	}
	
	public static Employee enterEmployeeinfo() {
		String firstName;
		String lastName;
		double salary = 0;
		boolean exit = true;
		
		System.out.println("Enter First Name");
		firstName = scanner.nextLine();
		System.out.println("Enter Last Name");
		lastName = scanner.nextLine();
		do {
			System.out.println("Enter Salary");
			try {
				salary = Double.parseDouble(scanner.nextLine());
				exit = false;
			}catch(InputMismatchException e) {
				System.out.println("Invaild input");
			}catch(NumberFormatException e) {
				System.out.println("Invaild input");
			}
		}while(exit);
		LocalDateTime date = LocalDateTime.now();
		return new Employee(firstName, lastName, ++Employee.count, date, salary);
	}
	
	public static Employee findEmployeeById(Employees es) {
		Employee employee = new Employee();
		boolean exit = true;
		do {
			System.out.println("Enter employee ID: ");
			try {
				int newInput = Integer.parseInt(scanner.nextLine());
				employee = es.findById(newInput);
				exit = false;
			}catch(InputMismatchException e) {
				System.out.println("Invaild input");
			}catch(NumberFormatException e) {
				System.out.println("Invaild input");
			}catch(UnableToFindException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}while(exit);
		return employee;
	}
	
	public static Employee changeEmployeeById(Employees es) {
		Employee oldE = findEmployeeById(es);
		System.out.println("Old Employee's Information :" + oldE.toString());
		String firstName;
		String lastName;
		double salary = 0;
		boolean exit = true;
		
		System.out.println("Enter First Name");
		firstName = scanner.nextLine();
		System.out.println("Enter Last Name");
		lastName = scanner.nextLine();
		do {
			System.out.println("Enter Salary");
			try {
				salary = Double.parseDouble(scanner.nextLine());
				exit = false;
			}catch(InputMismatchException e) {
				System.out.println("Invaild input");
			}catch(NumberFormatException e) {
				System.out.println("Invaild input");
			}
 		}while(exit);
		return new Employee(firstName, lastName, oldE.getEmployeeID(), oldE.getDateofEmployment(), salary);
	}
	
	public static Department enterDeparmentInfo() {
		String name;
		String phone;
		String location;
		double budget = 0;
		boolean exit = true;
		System.out.println("Enter a name of the Department");
		name = scanner.nextLine();
		System.out.println("Enter a phone number");
		phone = scanner.nextLine();
		System.out.println("Enter a location");
		location = scanner.nextLine();
		do {
			System.out.println("Enter budgt");
			try {
				budget = Double.parseDouble(scanner.nextLine());
				exit = false;
			}catch(InputMismatchException e) {
				System.out.println("Invaild input");
			}catch(NumberFormatException e) {
				System.out.println("Invaild input");
			}
 		}while(exit);
		return new Department(name, phone, location, budget); 
	}
	
	public static Department findDeparmentByName(Company c) {
		String name;
		Department department = new Department();
		System.out.println("Enter a name of the Department to find from company");
		name = scanner.nextLine();
		boolean exit = true;
		
		do {
			try {
				department = c.findByName(name);
				exit = false;
			} catch (UnableToFindException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}while(exit);
		return department;
	}
	
	public static void addEmployeeToDepartment(Company c, Employees es) {
		if(c.addEmployee(findDeparmentByName(c), findEmployeeById(es))) {
			System.out.println("Add Employee to Department succesfully");
		}else {
			System.out.println("unable to add Employee to Department");
		}
	}
	
	public static void RemoveEmployeeToDepartment(Company c, Employees es) {
		if(c.removeEmployee(findDeparmentByName(c), findEmployeeById(es))) {
			System.out.println("remove Employee from Department succesfully");
		}else {
			System.out.println("unable to remove Employee to Department");
		}
	}
	
	public static void changeDepertment(Company c, Employees es) {
		Employee e = findEmployeeById(es);
		System.out.println("Enter old department");
		Department oldD = findDeparmentByName(c);
		System.out.println("Enter new department");
		Department d = findDeparmentByName(c);
		c.changeDepartment(oldD, d, e);
	}
}
