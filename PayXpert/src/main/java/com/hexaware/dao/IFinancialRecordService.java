package com.hexaware.dao;

import java.time.LocalDate;

import java.util.List;
import com.hexaware.entity.FinancialRecord;
/**
 * The IFinancialRecordService interface defines the contract for accessing and managing financial record data.
 */

public interface IFinancialRecordService {

	/**
     * Adds a new financial record.
     */
	 public void addFinancialRecord();
	  /**
	     * Retrieves a financial record by its ID.
	     * @param recordId The ID of the financial record to retrieve.
	     * @return The financial record with the specified ID.
	     */
	 
	 public FinancialRecord getFinancialRecordById(int recordId);
	 /**
	     * Retrieves a list of financial records for a specific employee.
	     * @param employeeId The ID of the employee.
	     * @return A list of financial records for the specified employee.
	     */
	 
	 List<FinancialRecord> getFinancialRecordsForEmployee(int employeeId);
	 /**
	     * Retrieves a list of financial records for a specific date.
	     * @param recordDate The date for which to retrieve financial records.
	     * @return A list of financial records for the specified date.
	     */
	 
	 List<FinancialRecord> getFinancialRecordsForDate(LocalDate recordDate);

	
}
