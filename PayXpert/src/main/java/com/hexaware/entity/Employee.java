package com.hexaware.entity;

import java.time.LocalDate;

/**
 * Represents an employee in the system.
 */

public class Employee {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String gender;
	private String email;
	private String phoneNumber;
	private String address;
	private String position;
	private LocalDate joiningDate;
	private LocalDate terminalDate;
	private Payroll payroll;
	private Tax tax;
	private FinancialRecord financialRecord;
	
	/**
     * Constructs an Employee object.
     */
	
	public Employee() {
		
	}

	 /**
     * Constructs an Employee object with specified attributes.
     * @param employeeId the ID of the employee
     * @param firstName the first name of the employee
     * @param lastName the last name of the employee
     * @param dateOfBirth the date of birth of the employee
     * @param gender the gender of the employee
     * @param email the email address of the employee
     * @param phoneNumber the phone number of the employee
     * @param address the address of the employee
     * @param position the position of the employee
     * @param joiningDate the joining date of the employee
     * @param terminalDate the terminal date of the employee
     * @param payroll the payroll information of the employee
     * @param tax the tax information of the employee
     * @param financialRecord the financial record of the employee
     */
	
	public Employee(int employeeId, String firstName, String lastName, LocalDate dateOfBirth, String gender,
			String email, String phoneNumber, String address, String position, LocalDate joiningDate,
			LocalDate terminalDate, Payroll payroll, Tax tax, FinancialRecord financialRecord) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.position = position;
		this.joiningDate = joiningDate;
		this.terminalDate = terminalDate;
		this.payroll = payroll;
		this.tax = tax;
		this.financialRecord = financialRecord;
	}

	/**
     * Gets the employee ID.
     *
     * @return the employee ID
     */
	public int getEmployeeId() {
		return employeeId;
	}
	
	/**
     * Sets the ID of the employee.
     * 
     * @param employeeId the employee ID to set
     */

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
     * Retrieves the first name of the employee.
     * 
     * @return the first name
     */

	public String getFirstName() {
		return firstName;
	}
	
	/**
     * Sets the first name of the employee.
     * 
     * @param firstName the first name to set
     */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	 /**
     * Retrieves the last name of the employee.
     * 
     * @return the last name
     */

	public String getLastName() {
		return lastName;
	}
	
	 /**
     * Retrieves the last name of the employee.
     * 
     * @return the last name
     */

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
     * Retrieves the date of birth of the employee.
     * 
     * @return the date of birth
     */

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
     * Sets the date of birth of the employee.
     * 
     * @param dateOfBirth the date of birth to set
     */

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
     * Sets the date of birth of the employee.
     * 
     * @param dateOfBirth the date of birth to set
     */

	public String getGender() {
		return gender;
	}
	
	/**
     * Sets the date of birth of the employee.
     * 
     * @param dateOfBirth the date of birth to set
     */

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	 /**
     * Retrieves the email address of the employee.
     * 
     * @return the email address
     */

	public String getEmail() {
		return email;
	}
	
	 /**
     * Sets the email address of the employee.
     * 
     * @param email the email address to set
     */

	public void setEmail(String email) {
		this.email = email;
	}

	 /**
     * Retrieves the phone number of the employee.
     * 
     * @return the phone number
     */
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	

    /**
     * Sets the phone number of the employee.
     * 
     * @param phoneNumber the phone number to set
     */

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
     * Retrieves the address of the employee.
     * 
     * @return the address
     */

	public String getAddress() {
		return address;
	}
	
	/**
     * Sets the address of the employee.
     * 
     * @param address the address to set
     */

	public void setAddress(String address) {
		this.address = address;
	}
	
	 /**
     * Retrieves the position of the employee.
     * 
     * @return the position
     */

	public String getPosition() {
		return position;
	}
	
	/**
     * Sets the position of the employee.
     * 
     * @param position the position to set
     */

	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
     * Retrieves the joining date of the employee.
     * 
     * @return the joining date
     */

	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	
	 /**
     * Sets the joining date of the employee.
     * 
     * @param joiningDate the joining date to set
     */

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	/**
     * Retrieves the terminal date of the employee.
     * 
     * @return the terminal date
     */

	public LocalDate getTerminalDate() {
		return terminalDate;
	}
	
	 /**
     * Sets the terminal date of the employee.
     * 
     * @param terminalDate the terminal date to set
     */

	public void setTerminalDate(LocalDate terminalDate) {
		this.terminalDate = terminalDate;
	}
	
	 /**
     * Retrieves the payroll information of the employee.
     * 
     * @return the payroll information
     */

	public Payroll getPayroll() {
		return payroll;
	}
	
	 /**
     * Sets the payroll information of the employee.
     * 
     * @param payroll the payroll information to set
     */

	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}
	
	 /**
     * Retrieves the tax information of the employee.
     * 
     * @return the tax information
     */

	public Tax getTax() {
		return tax;
	}
	
	/**
     * Sets the tax information of the employee.
     * 
     * @param tax the tax information to set
     */

	public void setTax(Tax tax) {
		this.tax = tax;
	}
	
	/**
     * Retrieves the financial record of the employee.
     * 
     * @return the financial record
     */

	public FinancialRecord getFinancialRecord() {
		return financialRecord;
	}
	
	/**
     * Sets the financial record of the employee.
     * 
     * @param financialRecord the financial record to set
     */

	public void setFinancialRecord(FinancialRecord financialRecord) {
		this.financialRecord = financialRecord;
	}
	
	/**
     * Returns a string representation of the Employee object.
     * The string representation consists of the employee's details including ID, name, date of birth, gender,
     * email, phone number, address, position, joining date, terminal date, payroll information, tax information,
     * and financial record.
     * 
     * @return a string representation of the Employee object
     */

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", position=" + position + ", joiningDate=" + joiningDate
				+ ", terminalDate=" + terminalDate + ", payroll=" + payroll + ", tax=" + tax + ", financialRecord="
				+ financialRecord + "]";
	}

}