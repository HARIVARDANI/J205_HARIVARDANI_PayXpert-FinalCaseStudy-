package com.hexaware.test;


import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import com.hexaware.controller.PayrollService;
import com.hexaware.entity.Payroll;


/**
 * A test class to verify the calculation of net salary after deductions for an employee.
 */
public class CalculateNetSalaryAfterDeductionsTest  {
	
	private PayrollService pys;
	
	/**
     * Sets up the test environment by initializing the PayrollService object.
     */
	
	@Before
    public void setUp() {
        pys = new PayrollService();
    }
	
	/**
     * Tests the calculation of net salary after deductions for an employee.
     */

    @Test
    public void testCalculateGrossSalaryForEmployee() {
    	
    	Payroll pay = new Payroll();
    	
    	pay.setPayrollId(1);
    	
    	float BasicSalary = 3000;
    	float OverTimePay = 100;
    	float Deductions = 250;
    	float ExpectedNetSalary = BasicSalary+OverTimePay-Deductions;
    	

    	 double NetSalary = pys.CalculateNetSalaryAfterDeductions(pay);
         

         assertEquals(ExpectedNetSalary, NetSalary, 0.0f);
    }
}


