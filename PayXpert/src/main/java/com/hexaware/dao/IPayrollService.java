package com.hexaware.dao;

import java.time.LocalDate;

import java.util.List;
import com.hexaware.entity.Payroll;

/**
 * The IPayrollService interface defines the contract for accessing and managing payroll data.
 */

public interface IPayrollService {
	/**
     * Generates payroll for employees.
     */
	
	public void generatePayroll();
	/**
     * Retrieves a payroll by its ID.
     * @param payrollId The ID of the payroll to retrieve.
     * @return The payroll with the specified ID.
     */
	
    public Payroll getPayrollById(int payrollId);
    /**
     * Retrieves a list of payrolls for a specific employee.
     * @param employeeId The ID of the employee.
     * @return A list of payrolls for the specified employee.
     */
    
    List<Payroll> getPayrollsForEmployee(int employeeId);
    /**
     * Retrieves a list of payrolls for a specific period.
     * @param startDate The start date of the period.
     * @param endDate The end date of the period.
     * @return A list of payrolls for the specified period.
     */
    
    List<Payroll> getPayrollsForPeriod(LocalDate startDate, LocalDate endDate);

}
