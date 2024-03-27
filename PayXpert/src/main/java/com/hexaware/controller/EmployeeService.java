package com.hexaware.controller;

import java.time.LocalDate;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.EmployeeDao;
import com.hexaware.dao.IEmployeeService;
import com.hexaware.entity.Employee;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.exception.InvalidInputException;

/**
 * Provides services related to employee management.
 */

public class EmployeeService implements IEmployeeService {
	
	Employee emp;
	List<Employee> emplist = new ArrayList<Employee>();
	
	EmployeeDao dao = new EmployeeDao();
	Scanner sc = new Scanner(System.in);
	
	 /**
     * Retrieves an employee by their ID.
     *
     * @param employeeId the ID of the employee to retrieve
     * @return the employee with the specified ID
     * @throws EmployeeNotFoundException if the employee with the specified ID is not found
     */
	
	public Employee getEmployeeById(int employeeId) throws EmployeeNotFoundException {
		try {
	        return dao.getEmployeeById(employeeId);
	    } catch (EmployeeNotFoundException e) {
	        System.out.println(e.getMessage());
	        throw e;
	    }
	}
	 /**
     * Retrieves a list of all employees.
     *
     * @return the list of all employees
     */

	@Override
	public List<Employee> getAllEmployees() {
		 emplist = dao.showEmployee();
		    for (Employee employee : emplist) {
		        System.out.println(employee);
		    }
		    return emplist;
	}
	 /**
     * Adds a new employee.
     */

	@Override
	public void addEmployee() {
		
		emp = new Employee();
		
		System.out.println("Enter Emp id");
		int employeeId = sc.nextInt();
		emp.setEmployeeId(employeeId);
		
		System.out.println("Enter emp first name");
		String firstName = sc.next();
		emp.setFirstName(firstName);
		
		System.out.println("Enter emp last name");
		String lastName = sc.next();
		emp.setLastName(lastName);
		
		System.out.println("Enter emp dob(yyyy-MM-dd):");
		LocalDate dateOfBirth = LocalDate.parse(sc.next());
        emp.setDateOfBirth(dateOfBirth);
	    
	    System.out.println("Enter emp gender");
	    String gender = sc.next();
	    emp.setGender(gender);
	    
	    System.out.println("Enter emp email");
	    String email = sc.next();
	    emp.setEmail(email);
	    
	    System.out.println("Enter emp phone no");
	    String phoneNumber = sc.next();
	    emp.setPhoneNumber(phoneNumber);
	    
	    System.out.println("Enter emp address");
	    String address = sc.next();
	    emp.setAddress(address);
	    

	    System.out.println("Enter emp position");
	    String position = sc.next();
	    emp.setPosition(position);
	    
	    System.out.println("Enter Employee Joining Date (yyyy-MM-dd):");
        LocalDate joiningDate = LocalDate.parse(sc.next());
        emp.setJoiningDate(joiningDate);

        System.out.println("Enter Employee Terminal Date (yyyy-MM-dd):");
        LocalDate terminalDate = LocalDate.parse(sc.next());
        emp.setTerminalDate(terminalDate);
        
        dao.createEmployee(emp);
        System.out.println("Employee added successfully.");
	}
	/**
     * Updates an existing employee.
     *
     * @param employeeId the ID of the employee to update
     */
	
	public void updateEmployee(int employeeId) {
	    try {
	        	        
	        System.out.println("Enter updated first name:");
	        String firstName = sc.nextLine();
	        
	        System.out.println("Enter updated last name:");
	        String lastName = sc.nextLine();
	        
	        System.out.println("Enter updated date of birth (yyyy-MM-dd):");
	        LocalDate dateOfBirth = LocalDate.parse(sc.nextLine());
	        
	        System.out.println("Enter updated gender:");
	        String gender =sc.nextLine();
	        
	        System.out.println("Enter updated email:");
	        String email = sc.nextLine();
	        
	        System.out.println("Enter updated phone number:");
	        String phoneNumber = sc.nextLine();
	        
	        System.out.println("Enter updated address:");
	        String address = sc.nextLine();
	        
	        System.out.println("Enter updated position:");
	        String position = sc.nextLine();
	        
	        System.out.println("Enter updated joining date (yyyy-MM-dd):");
	        LocalDate joiningDate = LocalDate.parse(sc.nextLine());
	        
	        System.out.println("Enter updated terminal date (yyyy-MM-dd):");
	        LocalDate terminalDate = LocalDate.parse(sc.nextLine());
	        
	        dao.updateEmployee(employeeId,firstName, lastName, dateOfBirth, gender,
                    email, phoneNumber, address, position, joiningDate, terminalDate);
	        
	        System.out.println("Employee with ID " + employeeId + " updated successfully.");
	    } catch (DateTimeParseException e) {
	        System.out.println("Invalid input or SQL error occurred. Please check your input and try again.");
	    } catch (EmployeeNotFoundException e) {
	        System.out.println(e.getMessage());
	    } catch (InvalidInputException e) {
	        System.out.println(e.getMessage());
	    }
	}
	/**
     * Removes an existing employee.
     *
     * @param employeeId the ID of the employee to remove
     */
	@Override
	public void removeEmployee(int employeeId) {
		try {
			dao.deleteEmployee(employeeId);
			System.out.println("Employee with ID " + employeeId + " removed successfully.");
		}catch(EmployeeNotFoundException e){
			System.out.println(e.getMessage());
		}		
	}
		
}

	
	


	
	


