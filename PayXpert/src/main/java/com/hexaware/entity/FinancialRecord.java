package com.hexaware.entity;

import java.time.LocalDate;

/**
 * Represents a financial record in the system.
 */

public class FinancialRecord {
	private int recordId;
    private int employeeId;
    private LocalDate recordDate;
    private String description;
    private double amount;
    private String recordType;
    
    /**
     * Constructs a FinancialRecord object.
     */
    
    public FinancialRecord() {
    	
    }
    /**
     * Constructs a FinancialRecord object with specified attributes.
     * @param recordId the ID of the financial record
     * @param employeeId the ID of the employee associated with the record
     * @param recordDate the date of the financial record
     * @param description the description of the financial record
     * @param amount the amount of the financial record
     * @param recordType the type of the financial record
     */
	public FinancialRecord(int recordId, int employeeId, LocalDate recordDate, String description, double amount,
			String recordType) {
		super();
		this.recordId = recordId;
		this.employeeId = employeeId;
		this.recordDate = recordDate;
		this.description = description;
		this.amount = amount;
		this.recordType = recordType;
	}
	/**
     * Retrieves the ID of the financial record.
     *
     * @return the record ID
     */
	public int getRecordId() {
		return recordId;
	}
	/**
     * Sets the ID of the financial record.
     *
     * @param recordId the record ID to set
     */

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	/**
     * Retrieves the ID of the employee associated with the financial record.
     *
     * @return the employee ID
     */

	public int getEmployeeId() {
		return employeeId;
	}
	  /**
     * Sets the ID of the employee associated with the financial record.
     *
     * @param employeeId the employee ID to set
     */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	/**
     * Retrieves the date of the financial record.
     *
     * @return the record date
     */

	public LocalDate getRecordDate() {
		return recordDate;
	}
	/**
     * Sets the date of the financial record.
     *
     * @param recordDate the record date to set
     */

	public void setRecordDate(LocalDate recordDate) {
		this.recordDate = recordDate;
	}
	 /**
     * Retrieves the description of the financial record.
     *
     * @return the description
     */

	public String getDescription() {
		return description;
	}
	 /**
     * Sets the description of the financial record.
     *
     * @param description the description to set
     */

	public void setDescription(String description) {
		this.description = description;
	}
	 /**
     * Retrieves the amount of the financial record.
     *
     * @return the amount
     */
	public double getAmount() {
		return amount;
	}
	/**
     * Sets the amount of the financial record.
     *
     * @param amount the amount to set
     */

	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
     * Retrieves the type of the financial record.
     *
     * @return the record type
     */
	
	public String getRecordType() {
		return recordType;
	}
	 /**
     * Sets the type of the financial record.
     *
     * @param recordType the record type to set
     */
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
	/**
     * Returns a string representation of the FinancialRecord object.
     *
     * @return a string representation of the FinancialRecord object
     */

	@Override
	public String toString() {
		return "FinancialRecord [recordId=" + recordId + ", employeeId=" + employeeId + ", recordDate=" + recordDate
				+ ", description=" + description + ", amount=" + amount + ", recordType=" + recordType + "]";
	}
    	

}
