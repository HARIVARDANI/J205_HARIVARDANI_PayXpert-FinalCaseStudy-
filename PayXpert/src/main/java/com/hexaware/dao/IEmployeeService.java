package com.hexaware.dao;

import java.util.List;

import com.hexaware.entity.Employee;
import com.hexaware.exception.EmployeeNotFoundException;

public interface IEmployeeService {
	/**
     * Retrieves an employee by their ID.
     * @param employeeId The ID of the employee to retrieve.
     * @return The employee with the specified ID.
     * @throws EmployeeNotFoundException If the employee with the specified ID is not found.
     */
	
	 public Employee getEmployeeById(int employeeId) throws EmployeeNotFoundException;
	 
	 /**
	     * Retrieves a list of all employees.
	     * @return A list of all employees.
	     */
	 
	 public List<Employee> getAllEmployees();
	 /**
	     * Adds a new employee.
	     */
	 
	 public void addEmployee();
	 /**
	     * Updates an existing employee.
	     * @param employeeId The ID of the employee to update.
	     */
	
	 void updateEmployee(int employeeId);
	 /**
	     * Removes an employee.
	     * @param employeeId The ID of the employee to remove.
	     */

	 void removeEmployee(int employeeId);

}
