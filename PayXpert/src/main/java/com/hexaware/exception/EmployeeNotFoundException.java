package com.hexaware.exception;

/**
 * Exception class to handle cases where an employee is not found.
 */

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends Exception {
	
	/**
     * Constructs a new EmployeeNotFoundException with a default message.
     */
	
	public EmployeeNotFoundException()
	{
		super("Employee not found");
	}

}
