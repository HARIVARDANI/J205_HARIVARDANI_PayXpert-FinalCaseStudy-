package com.hexaware.test;

import org.junit.Test;
import com.hexaware.controller.EmployeeService;
import com.hexaware.exception.EmployeeNotFoundException;

/**
 * A test class to verify error handling for invalid employee data.
 */
public class VerifyErrorHandlingForInvalidEmployeeDataTest {
	
/**
  * Tests the scenario where an EmployeeNotFoundException is expected to be thrown
  * when trying to retrieve an employee by an invalid employee ID.
  *
  * @throws EmployeeNotFoundException if the employee with the specified ID is not found
  */
    @Test(expected = EmployeeNotFoundException.class)
    public void testEmployeeNotFound() throws EmployeeNotFoundException {
    	
        EmployeeService employeeService = new EmployeeService();

        int invalidEmployeeId = 105;
        employeeService.getEmployeeById(invalidEmployeeId);
       }
}



