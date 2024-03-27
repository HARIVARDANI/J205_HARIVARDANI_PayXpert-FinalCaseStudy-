package com.hexaware.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hexaware.controller.PayrollService;
import com.hexaware.entity.Payroll;

/**
 * A test class to verify the processing of payroll for multiple employees.
 */

public class ProcessPayrollForMultipleEmployeesTest {
	private PayrollService payrollService;
	private List<Payroll> payrollList;
	
/**
 * Sets up the test environment by initializing the PayrollService object and creating a list of sample payroll data.
 */

	@Before
    public void setUp() {
    	 payrollService = new PayrollService();
    	    payrollList = new ArrayList<>();

    	   
    	    Payroll payroll1 = new Payroll();
    	    payroll1.setPayrollId(1);
    	    payroll1.setEmployeeId(101);
    	    payroll1.setPayPeriodStartDate(java.time.LocalDate.of(2024,03,01));
    	    payroll1.setPayPeriodEndDate(java.time.LocalDate.of(2024,03,15));
    	    payroll1.setBasicSalary(3000.0f);
    	    payroll1.setOvertimePay(100.0f);
    	    payroll1.setDeductions(250.0f);
    	    payroll1.setNetSalary(2850.0f);
    	    payrollList.add(payroll1);

    	    
    	    Payroll payroll2 = new Payroll();
    	    payroll2.setPayrollId(2);
    	    payroll2.setEmployeeId(102);
    	    payroll2.setPayPeriodStartDate(java.time.LocalDate.of(2024,03,01));
    	    payroll2.setPayPeriodEndDate(java.time.LocalDate.of(2024,03,15));
    	    payroll2.setBasicSalary(2500.0f);
    	    payroll2.setOvertimePay(00.0f);
    	    payroll2.setDeductions(100.0f);
    	    payroll2.setNetSalary(2400.0f);
    	    payrollList.add(payroll2);
	}
	
/**
  * Tests the processing of payroll for multiple employees.
  */
    	    
    	    @Test
    	    public void testProcessPayrollForMultipleEmployees() {
    	        assertNotNull(payrollList);
    	        
    	        for (Payroll payroll : payrollList) {
    	            int payrollId = payroll.getPayrollId();
    	            Payroll retrievedPayroll = payrollService.getPayrollById(payrollId);
    	            assertNotNull(retrievedPayroll);
    	            assertEquals("Mismatch in payroll ID", payrollId, retrievedPayroll.getPayrollId());
    	            assertEquals("Mismatch in employee ID", payroll.getEmployeeId(), retrievedPayroll.getEmployeeId());
    	            assertEquals("Mismatch in start date", payroll.getPayPeriodStartDate(), retrievedPayroll.getPayPeriodStartDate());
    	            assertEquals("Mismatch in end date", payroll.getPayPeriodEndDate(), retrievedPayroll.getPayPeriodEndDate());
    	            assertEquals("Mismatch in basic salary", payroll.getBasicSalary(), retrievedPayroll.getBasicSalary(), 0.0);
    	            assertEquals("Mismatch in overtime pay", payroll.getOvertimePay(), retrievedPayroll.getOvertimePay(), 0.0);
    	            assertEquals("Mismatch in deductions", payroll.getDeductions(), retrievedPayroll.getDeductions(), 0.0);
    	            assertEquals("Mismatch in net salary", payroll.getNetSalary(), retrievedPayroll.getNetSalary(), 0.0);
    	        }
    	    }
    	 }

