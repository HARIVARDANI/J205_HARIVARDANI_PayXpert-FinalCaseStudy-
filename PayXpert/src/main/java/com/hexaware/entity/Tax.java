package com.hexaware.entity;
/**
 * Represents a tax record for an employee in a specific tax year.
 */

public class Tax {
	private int taxId;
    private int employeeId;
    private int taxYear;
    private double taxableIncome;
    private double taxAmount;
    
    /**
     * Constructs a Tax object.
     */
    
    public Tax() {
    	
    }
    /**
     * Constructs a Tax object with specified attributes.
     *
     * @param taxId         the ID of the tax record
     * @param employeeId    the ID of the employee associated with the tax record
     * @param taxYear       the tax year
     * @param taxableIncome the taxable income for the tax year
     * @param taxAmount     the calculated tax amount for the tax year
     */

	public Tax(int taxId, int employeeId, int taxYear, double taxableIncome, double taxAmount) {
		super();
		this.taxId = taxId;
		this.employeeId = employeeId;
		this.taxYear = taxYear;
		this.taxableIncome = taxableIncome;
		this.taxAmount = taxAmount;
	}

	/**
     * Retrieves the ID of the tax record.
     *
     * @return the tax ID
     */
	public int getTaxId() {
		return taxId;
	}

	/**
     * Sets the ID of the tax record.
     *
     * @param taxId the tax ID to set
     */
	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}
	 /**
     * Retrieves the ID of the employee associated with the tax record.
     *
     * @return the employee ID
     */
	public int getEmployeeId() {
		return employeeId;
	}
	/**
     * Sets the ID of the employee associated with the tax record.
     *
     * @param employeeId the employee ID to set
     */

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	/**
     * Retrieves the tax year.
     *
     * @return the tax year
     */

	public int getTaxYear() {
		return taxYear;
	}
	/**
     * Sets the tax year.
     *
     * @param taxYear the tax year to set
     */
	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
	}
	/**
     * Retrieves the taxable income for the tax year.
     *
     * @return the taxable income
     */

	public double getTaxableIncome() {
		return taxableIncome;
	}
	/**
     * Sets the taxable income for the tax year.
     *
     * @param taxableIncome the taxable income to set
     */

	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}
	/**
     * Retrieves the calculated tax amount for the tax year.
     *
     * @return the tax amount
     */

	public double getTaxAmount() {
		return taxAmount;
	}
	/**
     * Sets the calculated tax amount for the tax year.
     *
     * @param taxAmount the tax amount to set
     */

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	/**
     * Returns a string representation of the Tax object.
     *
     * @return a string representation of the Tax object
     */
	@Override
	public String toString() {
		return "Tax [taxId=" + taxId + ", employeeId=" + employeeId + ", taxYear=" + taxYear + ", taxableIncome="
				+ taxableIncome + ", taxAmount=" + taxAmount + "]";
	}

	
      
}
