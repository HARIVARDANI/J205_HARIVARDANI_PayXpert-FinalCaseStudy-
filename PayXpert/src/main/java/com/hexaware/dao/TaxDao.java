package com.hexaware.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Tax;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.exception.InvalidInputException;
import com.hexaware.util.DBUtil;

/**
 * The TaxDao class provides methods to interact with the database for tax-related operations.
 */

public class TaxDao {
	
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	
	/**
     * Calculates tax for a given employee and tax year.
     * @param employeeId The ID of the employee.
     * @param taxYear The tax year.
     * @return The Tax object representing the calculated tax details.
     * @throws SQLException If an SQL error occurs during database interaction.
     */
	
	public Tax calculateTax(int employeeId, int taxYear) throws SQLException {
        try (Connection con = DBUtil.getDBConn()) {
            PreparedStatement ps = con.prepareStatement("SELECT SUM(basicSalary)as totalSalary FROM payroll WHERE employeeId=? AND YEAR(PayPeriodStartDate)=? AND YEAR(PayPeriodEndDate)=?");
            ps.setInt(1, employeeId);
            ps.setInt(2, taxYear);
            ps.setInt(3, taxYear);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                double taxableIncome = rs.getDouble("totalSalary");
                double taxAmount = taxableIncome * 0.15*2f;
                
                
                ps = con.prepareStatement("INSERT INTO tax(employeeId, taxYear, taxableIncome, taxAmount) VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1, employeeId);
                ps.setInt(2, taxYear);
                ps.setDouble(3, taxableIncome);
                ps.setDouble(4, taxAmount);
                int rowsAffected = ps.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Tax recorded successfully.");
                    ResultSet generatedKeys = ps.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int taxId = generatedKeys.getInt(1);
                        return new Tax(taxId, employeeId, taxYear, taxableIncome, taxAmount);
                    }
                }
            }
        }
        return null;
    }
	
	 /**
     * Retrieves tax details by tax ID.
     * @param taxId The ID of the tax.
     * @return The Tax object representing the retrieved tax details.
     * @throws InvalidInputException If the specified tax ID is not found in the database.
     */

	public Tax getTaxById(int taxId) throws InvalidInputException{
		try (Connection con = DBUtil.getDBConn();
		         PreparedStatement ps = con.prepareStatement("SELECT * FROM tax WHERE taxId = ?")) {
		        ps.setInt(1, taxId);
		        try (ResultSet rs = ps.executeQuery()) {
		            if (rs.next()) {
		                System.out.println("Tax Id: " + rs.getInt("taxId"));
		                System.out.println("Employee Id: " + rs.getInt("employeeId"));
		                System.out.println("Tax Year: " + rs.getInt("taxYear"));
		                System.out.println("Taxable Income: " + rs.getDouble("taxableIncome"));
		                System.out.println("Tax Amount: " + rs.getDouble("taxAmount"));
		            } else {
		                throw new InvalidInputException("Employee with taxID " + taxId + " not found");
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		return null;
		}
	/**
     * Retrieves all tax records for a given employee from the database.
     * @param employeeId The ID of the employee whose tax records are to be retrieved.
     * @return A list of Tax objects representing the retrieved tax records.
     * @throws DatabaseConnectionException If there is an error connecting to the database.
     */

	  public List<Tax> getTaxForEmployee(int employeeId) throws DatabaseConnectionException {
	        List<Tax> Taxlist = new ArrayList<>();
	           
	        try (Connection con = DBUtil.getDBConn();
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM tax WHERE employeeId = ?")) {
	            ps.setInt(1, employeeId);
	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                    int taxId = rs.getInt("taxId");
	                    int taxYear = rs.getInt("taxYear");
	                    double taxableIncome = rs.getDouble("taxableIncome");
	                    double taxAmount = rs.getDouble("taxAmount");
	                    
	                    Tax tax = new Tax(taxId, employeeId,taxYear,taxableIncome,taxAmount);
	                    Taxlist.add(tax);
	                }
	            }
	        }
	         catch (SQLException e) {
	            throw new DatabaseConnectionException("Error connecting to the database: " + e.getMessage());
	        }
	         return Taxlist;
	    }
	  
	  /**
	     * Retrieves all tax records for a given tax year from the database.
	     * @param taxYear The tax year.
	     * @return A list of Tax objects representing the retrieved tax records.
	     * @throws DatabaseConnectionException If there is an error connecting to the database.
	     */
	  public List<Tax> getTaxForYear(int taxYear) throws DatabaseConnectionException {
	        List<Tax> Taxlistt = new ArrayList<>();
	           
	        try (Connection con = DBUtil.getDBConn();
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM tax WHERE taxYear = ?")) {
	            ps.setInt(1, taxYear);
	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                    int taxId = rs.getInt("taxId");
	                    int employeeId = rs.getInt("employeeId");
	                    double taxableIncome = rs.getDouble("taxableIncome");
	                    double taxAmount = rs.getDouble("taxAmount");
	                    
	                    Tax tax = new Tax(taxId, employeeId,taxYear,taxableIncome,taxAmount);
	                    Taxlistt.add(tax);
	                }
	            }
	        }
	         catch (SQLException e) {
	            throw new DatabaseConnectionException("Error connecting to the database: " + e.getMessage());
	        }
	         return Taxlistt;
	  }
	  
	  //Dao implementation for testcase 5:
	  
	  /**
	     * Calculates tax for a given employee.
	     * @param eid The ID of the employee.
	     * @return The calculated tax amount.
	     */
	  
	  public double TaxCalculation(int eid) {
			con = DBUtil.getDBConn();
			try {
				ps = con.prepareStatement("select 1 from employee where EmployeeID in(?)");
				ps.setObject(1, eid);
				rs = ps.executeQuery();
				if(rs.next()) {
				}
				else {
					throw new EmployeeNotFoundException();
				}
				ps = con.prepareStatement("select TaxAmount from tax where EmployeeID=?");
				ps.setObject(1,eid);
				rs = ps.executeQuery();
				if(rs.next()) {
					return rs.getFloat("TaxAmount");
				}
			}catch(SQLException | EmployeeNotFoundException e) {
				e.printStackTrace();
			}
			return 0.0f;
		}

}
