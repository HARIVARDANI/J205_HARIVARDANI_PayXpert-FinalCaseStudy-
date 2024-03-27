package com.hexaware.controller;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.FinancialRecordDao;
import com.hexaware.dao.IFinancialRecordService;
import com.hexaware.entity.FinancialRecord;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.FinancialRecordException;

/**
 * Provides services related to financial records management.
 */

public class FinancialRecordService implements IFinancialRecordService {
	
	FinancialRecord financial;
	List<FinancialRecord> financiallist = new ArrayList<FinancialRecord>();
	
	FinancialRecordDao fdao = new FinancialRecordDao();
	Scanner sc = new Scanner(System.in);
	
    /**
     * Adds a new financial record.
     */

	@Override
	public void addFinancialRecord() {
		
		financial = new FinancialRecord();
		
		System.out.println("Enter record id :");
		int recordId = sc.nextInt();
	    financial.setRecordId(recordId);
		
		System.out.println("Enter employee id :");
		int employeeId = sc.nextInt();
		financial.setEmployeeId(employeeId);
		
		System.out.println("Enter Record Date (yyyy-MM-dd): ");
		LocalDate recordDate = LocalDate.parse(sc.next());
		financial.setRecordDate(recordDate);
		
		System.out.println("Enter Description :");
		String description = sc.next();
		financial.setDescription(description);
		
		System.out.println("Enter amount :");
		double amount = sc.nextDouble();
		financial.setAmount(amount);
		
		System.out.println("Enter Record Type:");
		String recordType = sc.next();
		financial.setRecordType(recordType);
		
		fdao.createFinancialRecord(financial);
	    System.out.println("FinancialRecord added successfully.");
		
	}
	
	/**
     * Retrieves a financial record by its ID.
     *
     * @param recordId the ID of the financial record to retrieve
     * @return the financial record with the specified ID
     */

	@Override
	public FinancialRecord getFinancialRecordById(int recordId) {
		try {
		      return fdao.getFinancialRecordById(recordId);
		    } catch (FinancialRecordException e) {
		        System.out.println(e.getMessage());
		        return null;		        
		    }
	}
	
	/**
     * Retrieves all financial records for a specific employee.
     *
     * @param employeeId the ID of the employee
     * @return the list of financial records for the specified employee
     */

	@Override
	public List<FinancialRecord> getFinancialRecordsForEmployee(int employeeId) {
		try {
	        financiallist = fdao.getFinancialRecordsForEmployee(employeeId);
	    } catch (FinancialRecordException  e) {
	    	e.printStackTrace(); 
	    }
		return financiallist;
	}
	/**
     * Retrieves all financial records for a specific date.
     *
     * @param recordDate the date of the financial records to retrieve
     * @return the list of financial records for the specified date
     */

	@Override
	public List<FinancialRecord> getFinancialRecordsForDate(LocalDate recordDate) {
		try {
	        return fdao.getFinancialRecordsForDate(recordDate);
		 } catch (DatabaseConnectionException e) { 
			 e.printStackTrace(); 
		return null;
	}		
	}
}

