package com.hexaware.dao;

import java.util.List;

import com.hexaware.entity.Tax;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.InvalidInputException;
import com.hexaware.exception.TaxCalculationException;

/**
 * The ITaxService interface defines the contract for calculating and retrieving tax-related information.
 */
public interface ITaxService {
	 /**
     * Calculates tax for a specific employee and tax year.
     * @param employeeId The ID of the employee.
     * @param taxYear The tax year for which tax is to be calculated.
     * @return The calculated tax for the employee and tax year.
     * @throws TaxCalculationException If an error occurs during tax calculation.
     * @throws DatabaseConnectionException If there is an error connecting to the database.
     * @throws InvalidInputException If the input parameters are invalid.
     */
	Tax calculateTax(int employeeId, int taxYear) throws TaxCalculationException, DatabaseConnectionException, InvalidInputException;
	/**
     * Retrieves tax information by its ID.
     * @param taxId The ID of the tax record.
     * @return The tax information with the specified ID.
     */
	
    public Tax getTaxById(int taxId);
    /**
     * Retrieves a list of tax records for a specific employee.
     * @param employeeId The ID of the employee.
     * @return A list of tax records for the specified employee.
     */
    
    List<Tax> getTaxesForEmployee(int employeeId);
    /**
     * Retrieves a list of tax records for a specific tax year.
     * @param taxYear The tax year.
     * @return A list of tax records for the specified tax year.
     */
    
    List<Tax> getTaxesForYear(int taxYear);

}
