package com.hexaware.dao;

import java.beans.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Payroll;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.exception.PayrollGenerationException;
import com.hexaware.util.DBUtil;

/**
 * The PayrollDao class provides methods to interact with the database for payroll-related operations.
 */

public class PayrollDao {
	
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	
	/**
     * Generates a new payroll record in the database.
     * @param pay The Payroll object representing the payroll details to be inserted.
     */
	
	public void generatePayroll(Payroll pay) {
		try {
			con=DBUtil.getDBConn();
			ps = con.prepareStatement("insert into payroll(payrollId,employeeId,payPeriodStartDate,payPeriodEndDate,basicSalary,overtimePay,deductions,netSalary) "
					+ "values(?,?,?,?,?,?,?,?)");
			ps.setInt(1,pay.getPayrollId());
			ps.setInt(2,pay.getEmployeeId());
			ps.setObject(3,pay.getPayPeriodStartDate());
			ps.setObject(4,pay.getPayPeriodEndDate());
			ps.setDouble(5,pay.getBasicSalary());
			ps.setDouble(6,pay.getOvertimePay());
			ps.setDouble(7,pay.getDeductions());
			ps.setDouble(8,pay.getNetSalary());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + "payroll inserted successfully in DB");
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
     * Retrieves a payroll record by its ID from the database.
     * @param payrollId The ID of the payroll to retrieve.
     * @return The Payroll object representing the retrieved payroll.
     * @throws PayrollGenerationException If the specified payroll ID is not found in the database.
     */
	
	public Payroll getPayrollById(int payrollId) throws PayrollGenerationException{
		Payroll payroll = null;
		try (Connection con = DBUtil.getDBConn();
		         PreparedStatement ps = con.prepareStatement("SELECT * FROM payroll WHERE payrollId = ?")) {
		        ps.setInt(1, payrollId);
		        try (ResultSet rs = ps.executeQuery()) {
		            if (rs.next()) {
		                System.out.println("Payroll Id: " + rs.getInt("payrollId"));
		                System.out.println("Employee Id: " + rs.getInt("employeeId"));
		                System.out.println("Pay Period Start Date: " + rs.getDate("payPeriodStartDate"));
		                System.out.println("Pay Period End Date: " + rs.getDate("payPeriodEndDate"));
		                System.out.println("Basic Salary: " + rs.getDouble("basicSalary"));
		                System.out.println("Overtime Pay: " + rs.getDouble("overtimePay"));
		                System.out.println("Deductions: " + rs.getDouble("deductions"));
		                System.out.println("Net Salary: " + rs.getDouble("netSalary"));
		                
		                payroll = new Payroll();
			            payroll.setPayrollId(rs.getInt("PayrollID"));
			            payroll.setEmployeeId( rs.getInt("employeeId"));
			            payroll.setPayPeriodStartDate(rs.getDate("payPeriodStartDate").toLocalDate());
			            payroll.setPayPeriodEndDate(rs.getDate("PayPeriodEndDate").toLocalDate());
			            payroll.setBasicSalary(rs.getDouble("BasicSalary"));
			            payroll.setOvertimePay(rs.getDouble("OvertimePay"));
			            payroll.setDeductions(rs.getDouble("deductions"));
			            payroll.setNetSalary(rs.getDouble("NetSalary"));
		                
		                
		            } else {
		                throw new PayrollGenerationException("Employee with payrollID " + payrollId + " not found");
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		return payroll;
		}
	 /**
     * Retrieves all payroll records for a given employee from the database.
     * @param employeeId The ID of the employee whose payroll records are to be retrieved.
     * @return A list of Payroll objects representing the retrieved payroll records.
     * @throws PayrollGenerationException If no payroll records are found for the specified employee.
     * @throws DatabaseConnectionException If there is an error connecting to the database.
     */
	
	  public List<Payroll> getPayrollsForEmployee(int employeeId) throws PayrollGenerationException, DatabaseConnectionException {
	        List<Payroll> payrolls = new ArrayList<>();
	           
	        try (Connection con = DBUtil.getDBConn();
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM payroll WHERE employeeId = ?")) {
	            ps.setInt(1, employeeId);
	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                    int payrollId = rs.getInt("payrollId");
	                    LocalDate payPeriodStartDate = rs.getDate("payPeriodStartDate").toLocalDate();
	                    LocalDate payPeriodEndDate = rs.getDate("payPeriodEndDate").toLocalDate();
	                    double basicSalary = rs.getDouble("basicSalary");
	                    double overtimePay = rs.getDouble("overtimePay");
	                    double deductions = rs.getDouble("deductions");
	                    double netSalary = rs.getDouble("netSalary");
	                    
	                    Payroll payroll = new Payroll(payrollId, employeeId, payPeriodStartDate, payPeriodEndDate,
	                                                  basicSalary, overtimePay, deductions, netSalary);
	                    payrolls.add(payroll);
	                }
	            }
	        }
	         catch (SQLException e) {
	            throw new DatabaseConnectionException("Error connecting to the database: " + e.getMessage());
	        }
	         return payrolls;
	    }

	  /**
	     * Retrieves all payroll records within a specified date range from the database.
	     * @param startDate The start date of the period.
	     * @param endDate The end date of the period.
	     * @return A list of Payroll objects representing the retrieved payroll records.
	     * @throws DatabaseConnectionException If there is an error connecting to the database.
	     */
   public List<Payroll> getPayrollsForPeriod(LocalDate startDate, LocalDate endDate) throws DatabaseConnectionException {
    List<Payroll> payrolls = new ArrayList<>();
    try (Connection con = DBUtil.getDBConn();
           PreparedStatement ps = con.prepareStatement("SELECT * FROM payroll WHERE payPeriodStartDate >= ? AND payPeriodEndDate <= ?")){
           ps.setDate(1, java.sql.Date.valueOf(startDate));
           ps.setDate(2, java.sql.Date.valueOf(endDate));
           try (ResultSet rs = ps.executeQuery()) {
               while (rs.next()) {
                   int payrollId = rs.getInt("payrollId");
                   int employeeId = rs.getInt("employeeId");
                   LocalDate payPeriodStartDate = rs.getDate("payPeriodStartDate").toLocalDate();
                   LocalDate payPeriodEndDate = rs.getDate("payPeriodEndDate").toLocalDate();
                   double basicSalary = rs.getDouble("basicSalary");
                   double overtimePay = rs.getDouble("overtimePay");
                   double deductions = rs.getDouble("deductions");
                   double netSalary = rs.getDouble("netSalary");

                   Payroll payroll = new Payroll(payrollId, employeeId, payPeriodStartDate, payPeriodEndDate,
                           basicSalary, overtimePay, deductions, netSalary);
                   payrolls.add(payroll);
               }
           }
       } catch (SQLException e) {
           throw new DatabaseConnectionException("Error connecting to the database: " + e.getMessage());
       }
       return payrolls;
   }
   
   
   /*Dao Implementation for testcase 1*/
   
   /**
    * Calculates the gross salary for an employee based on their ID.
    * @param eid The ID of the employee.
    * @return The calculated gross salary.
    */
   
   public float CalculateGrossSalary(int eid) {
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
			ps = con.prepareStatement("select sum(BasicSalary)+sum(OvertimePay) g from payroll where EmployeeID=?");
			ps.setObject(1,eid);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getFloat("g");
			}
		}catch(SQLException | EmployeeNotFoundException e) {
			e.printStackTrace();
		}
		return 0.0f;
	}
   
   /* Dao implementation for testcase 2*/
   
   /**
    * Calculates the net salary after deductions for a given payroll.
    * @param pay The Payroll object representing the payroll for which net salary is to be calculated.
    * @return The calculated net salary after deductions.
    */
   
   public float CalculateNetSalaryAfterDeductions(Payroll pay) {
		con = DBUtil.getDBConn();
		try {
			ps = con.prepareStatement("select NetSalary from payroll where PayrollId=?");
			ps.setObject(1,pay.getPayrollId());
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getFloat("NetSalary");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0.0f;
	}
   
}
	
	
	
	

