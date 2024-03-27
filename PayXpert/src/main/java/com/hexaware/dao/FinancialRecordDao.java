package com.hexaware.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.FinancialRecord;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.FinancialRecordException;
import com.hexaware.util.DBUtil;
/**
 * The FinancialRecordDao class handles database operations related to financial records.
 */

public class FinancialRecordDao {
	
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	
	 /**
     * Creates a financial record in the database.
     * @param financial The financial record to be created.
     */
	
	public void createFinancialRecord(FinancialRecord financial) {
		try {
			con=DBUtil.getDBConn();
			ps = con.prepareStatement("insert into FinancialRecord(recordId,employeeId,recordDate,description,amount,recordType) "
					+ "values(?,?,?,?,?,?)");
			ps.setInt(1,financial.getRecordId());
			ps.setInt(2, financial.getEmployeeId());
			ps.setObject(3,financial.getRecordDate());
			ps.setString(4,financial.getDescription());
			ps.setDouble(5,financial.getAmount());
			ps.setString(6,financial.getRecordType());
			
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + "inserted successfully in DB");
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
     * Retrieves a financial record by its ID from the database.
     * @param recordId The ID of the financial record to retrieve.
     * @return The financial record with the specified ID.
     * @throws FinancialRecordException If the financial record with the specified ID is not found.
     */
	
	public FinancialRecord getFinancialRecordById(int recordId) throws FinancialRecordException{
		try (Connection con = DBUtil.getDBConn();
		        PreparedStatement ps = con.prepareStatement("SELECT * FROM FinancialRecord WHERE recordId = ?")) {
		        ps.setInt(1, recordId);
		        try (ResultSet rs = ps.executeQuery()) {
		            if (rs.next()) {
		                System.out.println("Record Id: " + rs.getInt("recordId"));
		                System.out.println("Employee Id: " + rs.getInt("employeeId"));
		                System.out.println("Record Date: " + rs.getDate("recordDate"));
		                System.out.println("Description: " + rs.getString("description"));
		                System.out.println("Amount: " + rs.getDouble("amount"));
		                System.out.println("Record Type: " + rs.getString("recordType"));
		            } else {
		                throw new  FinancialRecordException("Employee with Record ID " + recordId + " not found");
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		return null;
	}
	
	/**
     * Retrieves financial records associated with a specific employee from the database.
     * @param employeeId The ID of the employee.
     * @return A list of financial records associated with the employee.
     * @throws FinancialRecordException If an error occurs while retrieving the records.
     */
		
		 public List<FinancialRecord> getFinancialRecordsForEmployee(int employeeId) throws FinancialRecordException{
		        List<FinancialRecord> financialRecords = new ArrayList<>();
		           
		        try (Connection con = DBUtil.getDBConn();
		            PreparedStatement ps = con.prepareStatement("SELECT * FROM FinancialRecord WHERE employeeId = ?")) {
		            ps.setInt(1, employeeId);
		            try (ResultSet rs = ps.executeQuery()) {
		                while (rs.next()) {
		                    int recordId = rs.getInt("recordId");
		                    LocalDate recordDate = rs.getDate("recordDate").toLocalDate();
		                    String description = rs.getString("description");
		                    double amount = rs.getDouble("amount");
		                    String recordType = rs.getString("recordType");
		          
		                    FinancialRecord financialRecord = new FinancialRecord(recordId, employeeId, recordDate, description, amount, recordType);                                            
		                    financialRecords.add(financialRecord);
		                }
		            }
		        }
		         catch (SQLException e) {
		            throw new FinancialRecordException("Financial Record Exception " + e.getMessage());
		        }
		         return financialRecords;
		    }
		 
		 /**
		     * Retrieves financial records for a specific date from the database.
		     * @param recordDate The date for which to retrieve financial records.
		     * @return A list of financial records for the specified date.
		     * @throws DatabaseConnectionException If an error occurs while connecting to the database.
		     */
		 
		 public List<FinancialRecord> getFinancialRecordsForDate(LocalDate recordDate) throws DatabaseConnectionException {
		        List<FinancialRecord> financialRecords = new ArrayList<>();
		        
		        try (Connection con = DBUtil.getDBConn();
		             PreparedStatement ps = con.prepareStatement("SELECT * FROM financialRecord WHERE recordDate = ?")) {     
		        	 ps.setDate(1, java.sql.Date.valueOf(recordDate));
		             try (ResultSet rs = ps.executeQuery()) {
		                 while (rs.next()) {
		                     int recordId = rs.getInt("recordId");
		                     int employeeId = rs.getInt("employeeId");
		                     LocalDate date = rs.getDate("recordDate").toLocalDate();
		                     String description = rs.getString("description");
		                     double amount = rs.getDouble("amount");
		                     String recordType = rs.getString("recordType");
		                    
		                     FinancialRecord financialRecord = new FinancialRecord(recordId,employeeId,recordDate,description,amount,recordType);
		                     financialRecords.add(financialRecord);
		                 }
		             }
		        }catch(SQLException e) {
		        	 throw new DatabaseConnectionException("Error connecting to the database: " + e.getMessage());
		        }
		        return financialRecords;
		 }		                                        
}
