package com.hexaware.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.IPayrollService;
import com.hexaware.dao.PayrollDao;
import com.hexaware.entity.Payroll;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.PayrollGenerationException;

/**
 * Provides services related to payroll management.
 */

public class PayrollService implements IPayrollService{

	Payroll pay;
	List<Payroll> paylist = new ArrayList<Payroll>();
		
	PayrollDao pdao = new PayrollDao();

	Scanner sc = new Scanner(System.in);
	@Override
	public void generatePayroll() {
		
		pay = new Payroll();
		
		System.out.println("Enter payroll id :");
		int payrollId = sc.nextInt();
		pay.setPayrollId(payrollId);
		
		System.out.println("Enter employee id :");
		int employeeId = sc.nextInt();
		pay.setEmployeeId(employeeId);
		
		System.out.println("Enter Pay Period Start Date (yyyy-MM-dd): ");
		LocalDate payPeriodStartDate = LocalDate.parse(sc.next());
		pay.setPayPeriodStartDate(payPeriodStartDate);
		
		System.out.println("Enter Pay Period End Date (yyyy-MM-dd): ");
		LocalDate payPeriodEndDate = LocalDate.parse(sc.next());
		pay.setPayPeriodEndDate(payPeriodEndDate);
			    
	    System.out.println("Enter Basic Salary :");
	    Double basicSalary = sc.nextDouble();
	    pay.setBasicSalary(basicSalary);
	    
	    System.out.println("Enter OvertimePay :");
	    Double overtimePay = sc.nextDouble();
	    pay.setOvertimePay(overtimePay);
	    
	    System.out.println("Enter Deductions :");
	    Double deductions = sc.nextDouble();
	    pay.setDeductions(deductions);
	    
	    System.out.println("Enter Net Salary :");
	    Double netSalary = basicSalary + overtimePay - deductions ;
	    pay.setNetSalary(netSalary);
	           
        pdao.generatePayroll(pay);
        System.out.println("Payroll Generated successfully.");
	}
	
	/**
     * Retrieves payroll by ID.
     *
     * @param payrollId the ID of the payroll to retrieve
     * @return the payroll with the specified ID
     */
		

	@Override
	public Payroll getPayrollById(int payrollId) {
		try {
		      return pdao.getPayrollById(payrollId);
		    } catch ( PayrollGenerationException e) {
		        System.out.println(e.getMessage());
		        return null;
		    }
		}
	
	/**
     * Retrieves all payrolls for a specific employee.
     *
     * @param employeeId the ID of the employee
     * @return the list of payrolls for the specified employee
     */

	@Override
	public List<Payroll> getPayrollsForEmployee(int employeeId) {
		try {
	        paylist = pdao.getPayrollsForEmployee(employeeId);
	    } catch (PayrollGenerationException e) {
	    	e.printStackTrace(); 
	    }catch (DatabaseConnectionException e) {
	    	e.printStackTrace();
	    }
		return paylist;
	}
	
	/**
     * Retrieves all payrolls for a specific period.
     *
     * @param startDate the start date of the period
     * @param endDate   the end date of the period
     * @return the list of payrolls for the specified period
     */

	@Override
	public List<Payroll> getPayrollsForPeriod(LocalDate startDate, LocalDate endDate) {
		try {
	        return pdao.getPayrollsForPeriod(startDate, endDate);
		 } catch (DatabaseConnectionException e) { 
			 e.printStackTrace(); 
		return null;
	}
	}

/*I have implemented method for testing in controller from payrolldao */
	

    /**
     * Calculates the gross salary for an employee.
     *
     * @param employeeId the employee ID
     * @return the gross salary of the employee
     */
	
	/* Method for implementing the testcase 1 calculateGrossSalary */
	
	public double CalculateGrossSalary(int eid) {
		return pdao.CalculateGrossSalary(eid);
	}
	
	 /**
     * Calculates the net salary after deductions for a payroll.
     *
     * @param pay the payroll
     * @return the net salary after deductions
     */
	
	/* Method for implementing the testcase 2 calculateNetSalaryAfterDeduction */
	
	public double CalculateNetSalaryAfterDeductions(Payroll pay) {
		return pdao.CalculateNetSalaryAfterDeductions(pay);
	}
}
	

