package com.hexaware.controller;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.ITaxService;
import com.hexaware.dao.TaxDao;
import com.hexaware.entity.Tax;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.InvalidInputException;
import com.hexaware.exception.TaxCalculationException;

/**
 * Provides services related to tax calculations.
 */


public class TaxService implements ITaxService{
	
	Tax tax;
	List<Tax> taxlist = new ArrayList<Tax>();
	List<Tax> Taxlistt = new ArrayList<Tax>();
	
	private TaxDao tdao = new TaxDao();
	Scanner sc = new Scanner(System.in);
	 /**
     * Calculates tax for an employee for a specific year.
     *
     * @param employeeId the ID of the employee
     * @param taxYear    the year for which tax is to be calculated
     * @return the calculated tax
     * @throws TaxCalculationException if an error occurs during tax calculation
     */
	
	@Override
	public Tax calculateTax(int employeeId, int taxYear) throws TaxCalculationException {
        try {
            return tdao.calculateTax(employeeId, taxYear);
        } catch (SQLException e) {
            throw new TaxCalculationException("Error calculating tax: " + e.getMessage(), e);
        }
    }
	/**
     * Retrieves tax details by tax ID.
     *
     * @param taxId the ID of the tax
     * @return the tax details with the specified ID
     */
	
	@Override
	public Tax getTaxById(int taxId) {
		try {
		      return tdao.getTaxById(taxId);
		    } catch ( InvalidInputException e) {
		        System.out.println(e.getMessage());
		        return null;
		    }		
	}
	/**
     * Retrieves all taxes for a specific employee.
     *
     * @param employeeId the ID of the employee
     * @return the list of taxes for the specified employee
     */
	
	@Override
	public List<Tax> getTaxesForEmployee(int employeeId) {
		try {
	        taxlist = tdao.getTaxForEmployee(employeeId);
	    }catch (DatabaseConnectionException e) {
	    	e.printStackTrace();
	    }
		return taxlist;
		
	}
	
	/**
     * Retrieves all taxes for a specific year.
     *
     * @param taxYear the year for which taxes are to be retrieved
     * @return the list of taxes for the specified year
     */
	@Override
	public List<Tax> getTaxesForYear(int taxYear) {
		try {
			Taxlistt = tdao.getTaxForYear(taxYear);
		}catch(DatabaseConnectionException e) {
			e.printStackTrace();
		}
		return Taxlistt;
	}

	
	/* Method for implementing the testcase 5 VerifyTaxCalculationForHighIncomeEmployeeData */
	
	/**
     * Verifies tax calculation for a high-income employee.
     *
     * @param eid the employee ID
     * @return the calculated tax amount
     */
	public double VerifyTaxCalculationForHighIncomeEmployee(int eid) {
		return tdao.TaxCalculation(eid);
	}
}
