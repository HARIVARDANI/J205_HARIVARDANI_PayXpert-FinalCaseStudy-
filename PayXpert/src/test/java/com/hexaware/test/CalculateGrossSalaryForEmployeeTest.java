package com.hexaware.test;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import com.hexaware.controller.PayrollService;

/**
 * A test class to verify the calculation of gross salary for an employee.
 */

public class CalculateGrossSalaryForEmployeeTest {
    
    private PayrollService pys;
    /**
     * Sets up the test environment by initializing the PayrollService object.
     */
    @Before
    public void setUp() {
        pys = new PayrollService();
    }
    
    /**
     * Tests the calculation of gross salary for an employee.
     */

    @Test
    public void testCalculateGrossSalaryForEmployee() {
    	
    	int employeeId = 101;
        
        double grossSalary = pys.CalculateGrossSalary(employeeId);

        double expectedGrossSalary = 8200; 

        assertEquals(expectedGrossSalary, grossSalary,0.0);
    }
}



