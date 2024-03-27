package com.hexaware.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Employee;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.exception.InvalidInputException;
import com.hexaware.util.DBUtil;

/**
 * DAO class for handling Employee entities.
 */
public class EmployeeDao {
	
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	
	 /**
     * Retrieves an employee by their ID.
     * 
     * @param employeeId the ID of the employee
     * @return the employee with the specified ID
     * @throws EmployeeNotFoundException if the employee is not found
     */
	
	public Employee getEmployeeById(int employeeId) throws EmployeeNotFoundException{
		try (Connection con = DBUtil.getDBConn();
		         PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE employeeId = ?")) {
		        ps.setInt(1, employeeId);
		        try (ResultSet rs = ps.executeQuery()) {
		            if (rs.next()) {
		                System.out.println("Employee Id: " + rs.getInt("employeeId"));
		                System.out.println("First Name: " + rs.getString("firstName"));
		                System.out.println("Last Name: " + rs.getString("lastName"));
		                System.out.println("Date of Birth: " + rs.getDate("dateOfBirth"));
		                System.out.println("Gender: " + rs.getString("gender"));
		                System.out.println("Email: " + rs.getString("email"));
		                System.out.println("Phone Number: " + rs.getString("phoneNumber"));
		                System.out.println("Address: " + rs.getString("address"));
		                System.out.println("Position: " + rs.getString("position"));
		                System.out.println("Joining Date: " + rs.getDate("joiningDate"));
		                System.out.println("Termination Date: " + rs.getDate("terminalDate"));
		            } else {
		                throw new EmployeeNotFoundException();
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }finally {
		        try {
		            if (rs != null) rs.close();
		            if (ps != null) ps.close();
		            if (con != null) con.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		return null;
		}
	
	/**
     * Retrieves all employees from the database.
     * 
     * @return the list of all employees
     */
	
	public List<Employee> showEmployee() {
		List<Employee> employees = new ArrayList<>();
		
		try {
			con=DBUtil.getDBConn();
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from Employee");
			while(rs.next()) {
				System.out.println("EmployeeId : "+rs.getInt(1));
				System.out.println("Employee FirstName :" + rs.getString(2));
				System.out.println("Employee LastName :" + rs.getString(3));
				System.out.println("Employee DateOfBirth :" + rs.getDate(4));
				System.out.println("Employee Gender :" + rs.getString(5));
				System.out.println("Employee Email :" + rs.getString(6));
				System.out.println("Employee PhoneNumber :" + rs.getString(7));
				System.out.println("Employee Address :" + rs.getString(8));
				System.out.println("Employee Position :" + rs.getString(9));
				System.out.println("Employee JoiningDate :" + rs.getDate(10));
				System.out.println("Employee TerminationDate :" + rs.getDate(11));
			}
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return employees;
	}	
	
	/**
     * Creates a new employee in the database.
     * 
     * @param emp the employee object to be created
     */
	public void createEmployee(Employee emp) {
		try {
			con=DBUtil.getDBConn();
			ps = con.prepareStatement("insert into Employee(employeeId,firstName,lastName,dateOfBirth,gender,email,phoneNumber,address,position,joiningDate,terminalDate) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,emp.getEmployeeId());
			ps.setString(2, emp.getFirstName());
			ps.setString(3,emp.getLastName());
			ps.setObject(4,emp.getDateOfBirth());
			ps.setString(5,emp.getGender());
			ps.setString(6,emp.getEmail());
			ps.setString(7,emp.getPhoneNumber());
			ps.setString(8,emp.getAddress());
			ps.setString(9,emp.getPosition());
			ps.setObject(10,emp.getJoiningDate());
			ps.setObject(11,emp.getTerminalDate());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + "inserted successfully in DB");
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	/**
     * Updates an existing employee in the database.
     * 
     * @param employeeId-the ID of the employee to be updated
     * @param firstName-the updated first name
     * @param lastName -the updated last name
     * @param dateOfBirth -the updated date of birth
     * @param gender-the updated gender
     * @param email - the updated email
     * @param phoneNumber-the updated phone number
     * @param address-the updated address
     * @param position-the updated position
     * @param joiningDate -the updated joining date
     * @param terminalDate -the updated terminal date
     * @throws EmployeeNotFoundException if the employee is not found
     * @throws InvalidInputException-if the input is invalid
     */
			public void updateEmployee(int employeeId, String firstName, String lastName, LocalDate dateOfBirth, String gender,
		            String email, String phoneNumber, String address, String position, LocalDate joiningDate,
		            LocalDate terminalDate) throws EmployeeNotFoundException, InvalidInputException {
				Employee emp = new Employee();
				try {
					con = DBUtil.getDBConn();
			        ps = con.prepareStatement("update Employee set firstName=?, lastName=?, dateOfBirth=?, gender=?, email=?, phoneNumber=?, address=?, position=?, joiningDate=?, terminalDate=? where employeeId=?");
			        ps.setString(1, firstName);
			        ps.setString(2, lastName);
			        ps.setObject(3, dateOfBirth);
			        ps.setString(4, gender);
			        ps.setString(5, email);
			        ps.setString(6, phoneNumber);
			        ps.setString(7, address);
			        ps.setString(8, position);
			        ps.setObject(9, joiningDate);
			        ps.setObject(10, terminalDate);
			        ps.setInt(11, employeeId);       
			        int rows = ps.executeUpdate();
			        if(rows>0) {
			            System.out.println("Employee updated successfully...");
			        }
			        else
			        {
			        	throw new EmployeeNotFoundException();
			        }
				}
				catch (SQLException e)
				{
					System.out.println(e);
					throw new InvalidInputException("Kindly check the record you have entered...");	
				}
		}
			
			/**
		     * Deletes an employee record from the database.
		     *
		     * @param employeeId the ID of the employee to delete
		     * @throws EmployeeNotFoundException if the employee with the specified ID is not found
		     */
	
	public void deleteEmployee(int employeeId) throws EmployeeNotFoundException {
		
		try {
			con = DBUtil.getDBConn();
			ps = con.prepareStatement("delete from employee where employeeId=?");
	        ps.setInt(1, employeeId);
	        int rows = ps.executeUpdate();
	        if (rows>0) {
	            System.out.println("Employee with ID " + employeeId + " deleted successfully.");
	        } else {
	        	throw new EmployeeNotFoundException ();
	        }
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    }
	}		
}


