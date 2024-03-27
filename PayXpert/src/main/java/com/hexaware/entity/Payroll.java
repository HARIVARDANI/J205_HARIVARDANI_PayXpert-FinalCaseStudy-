package com.hexaware.entity;

import java.time.LocalDate;
/**
 * Represents a payroll record in the system.
 */

public class Payroll {
	private int payrollId;
	private int employeeId;
	private LocalDate payPeriodStartDate;
	private LocalDate payPeriodEndDate;
	private double basicSalary;
	private double overtimePay;
	private double deductions;
	private double netSalary;
	
	/**
     * Constructs a Payroll object.
     */
	
	public Payroll() {
		
	}
	
	/**
     * Constructs a Payroll object with specified attributes.
     *
     * @param payrollId-the ID of the payroll record
     * @param employeeId-the ID of the employee associated with the payroll record
     * @param payPeriodStartDate -the start date of the pay period
     * @param payPeriodEndDate-the end date of the pay period
     * @param basicSalary -the basic salary for the pay period
     * @param overtimePay-the overtime pay for the pay period
     * @param deductions-the deductions for the pay period
     * @param netSalary-the net salary for the pay period
     */

	public Payroll(int payrollId, int employeeId, LocalDate payPeriodStartDate, LocalDate payPeriodEndDate,
			double basicSalary, double overtimePay, double deductions, double netSalary) {
		super();
		this.payrollId = payrollId;
		this.employeeId = employeeId;
		this.payPeriodStartDate = payPeriodStartDate;
		this.payPeriodEndDate = payPeriodEndDate;
		this.basicSalary = basicSalary;
		this.overtimePay = overtimePay;
		this.deductions = deductions;
		this.netSalary = netSalary;
	}
	
	 /**
     * Retrieves the ID of the payroll record.
     *
     * @return the payroll ID
     */

	public int getPayrollId() {
		return payrollId;
	}
	/**
     * Sets the ID of the payroll record.
     *
     * @param payrollId the payroll ID to set
     */

	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}
	 /**
     * Retrieves the ID of the employee associated with the payroll record.
     *
     * @return the employee ID
     */

	public int getEmployeeId() {
		return employeeId;
	}
	
	/**
     * Sets the ID of the employee associated with the payroll record.
     *
     * @param employeeId the employee ID to set
     */

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	 /**
     * Retrieves the start date of the pay period.
     *
     * @return the pay period start date
     */

	public LocalDate getPayPeriodStartDate() {
		return payPeriodStartDate;
	}
	 /**
     * Sets the start date of the pay period.
     *
     * @param payPeriodStartDate the pay period start date to set
     */
	public void setPayPeriodStartDate(LocalDate payPeriodStartDate) {
		this.payPeriodStartDate = payPeriodStartDate;
	}
	
	/**
     * Retrieves the end date of the pay period.
     *
     * @return the pay period end date
     */

	public LocalDate getPayPeriodEndDate() {
		return payPeriodEndDate;
	}
	/**
     * Sets the end date of the pay period.
     *
     * @param payPeriodEndDate the pay period end date to set
     */

	public void setPayPeriodEndDate(LocalDate payPeriodEndDate) {
		this.payPeriodEndDate = payPeriodEndDate;
	}
	
	 /**
     * Retrieves the basic salary for the pay period.
     *
     * @return the basic salary
     */

	public double getBasicSalary() {
		return basicSalary;
	}
	  /**
     * Sets the basic salary for the pay period.
     *
     * @param basicSalary the basic salary to set
     */

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	/**
     * Retrieves the overtime pay for the pay period.
     *
     * @return the overtime pay
     */

	public double getOvertimePay() {
		return overtimePay;
	}
	/**
     * Sets the overtime pay for the pay period.
     *
     * @param overtimePay the overtime pay to set
     */

	public void setOvertimePay(double overtimePay) {
		this.overtimePay = overtimePay;
	}
	/**
     * Retrieves the deductions for the pay period.
     *
     * @return the deductions
     */

	public double getDeductions() {
		return deductions;
	}
	/**
     * Sets the deductions for the pay period.
     *
     * @param deductions the deductions to set
     */

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}
	/**
     * Retrieves the net salary for the pay period.
     *
     * @return the net salary
     */

	public double getNetSalary() {
		return netSalary;
	}
	 /**
     * Sets the net salary for the pay period.
     *
     * @param netSalary the net salary to set
     */

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	
	 /**
     * Returns a string representation of the Payroll object.
     *
     * @return a string representation of the Payroll object
     */

	@Override
	public String toString() {
		return "Payroll [payrollId=" + payrollId + ", employeeId=" + employeeId + ", payPeriodStartDate="
				+ payPeriodStartDate + ", payPeriodEndDate=" + payPeriodEndDate + ", basicSalary=" + basicSalary
				+ ", overtimePay=" + overtimePay + ", deductions=" + deductions + ", netSalary=" + netSalary + "]";
	}

}
