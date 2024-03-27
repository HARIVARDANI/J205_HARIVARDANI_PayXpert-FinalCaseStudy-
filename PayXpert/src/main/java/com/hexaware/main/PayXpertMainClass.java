/**
 * The main class for the PayXpert system, providing a command-line interface for user interaction.
 * This class allows users to perform various operations related to employee management, payroll generation, tax calculation,
 * and financial record management.
 *
 * @version 1.0
 * @author Harivardani
 */

package com.hexaware.main;

import com.hexaware.dao.IEmployeeService;
import com.hexaware.dao.IPayrollService;
import com.hexaware.dao.IFinancialRecordService;
import com.hexaware.entity.FinancialRecord;
import com.hexaware.entity.Payroll;
import com.hexaware.entity.Tax;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.exception.InvalidInputException;
import com.hexaware.exception.PayrollGenerationException;
import com.hexaware.exception.TaxCalculationException;
import com.hexaware.dao.ITaxService;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.hexaware.controller.EmployeeService;
import com.hexaware.controller.PayrollService;
import com.hexaware.controller.TaxService;
import com.hexaware.controller.FinancialRecordService;

public class PayXpertMainClass {
	public static void main(String[] args) throws PayrollGenerationException, DatabaseConnectionException, TaxCalculationException, InvalidInputException, EmployeeNotFoundException {
		IEmployeeService es = new EmployeeService();
		IPayrollService pys = new PayrollService();
		ITaxService ts = new TaxService();
		IFinancialRecordService fs = new FinancialRecordService();
		Scanner sc = new Scanner(System.in);
		String ch = null;
		do {
			System.out.println("----Welcome to PayXpert System-------");
			System.out.println("****MENU****");
			System.out.println("Enter your choice :");
			System.out.println("1.GetEmployeeById");
			System.out.println("2.GetAllEmployees");
			System.out.println("3.AddEmployee");
			System.out.println("4.UpdateEmployee");
			System.out.println("5.RemoveEmployee");
			System.out.println("6.GeneratePayroll");
            System.out.println("7.GetPayrollById");
            System.out.println("8.GetPayrollsForEmployee");
            System.out.println("9.GetPayrollsForPeriod");
			System.out.println("10.Calculate Tax");
			System.out.println("11.GetTaxById");
			System.out.println("12.GetTaxesForEmployee");
			System.out.println("13.GetTaxesForYear");
			System.out.println("14.AddFinancialReord");
			System.out.println("15.GetFinancialRecordById");
			System.out.println("16.GetFinancialRecordsForEmployee");
			System.out.println("17.GetFinancialRecordsForYear");
			System.out.println("----------------------------------");
			
			int choice =0;
			try {
				choice = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Invalid input! Please enter a valid option number.");
                sc.nextLine();
                continue;
			}
			switch(choice) {
			/*Get Employee by ID*/
			case 1:{ 
				System.out.println("Enter the employee ID:");
			    int empId = sc.nextInt();
			    es.getEmployeeById(empId);
			    break;
			}
			/* Get All Employees*/
			case 2:{ 
				es.getAllEmployees();
		    	break;
			}
			/* Add Employee */
			case 3:{  
				es.addEmployee();
				break;
			}
			/* Update Employee*/
			case 4:{
				
				 System.out.println("Enter the employee ID you want to update:");
                 int employeeId = sc.nextInt();
                 es.updateEmployee(employeeId);
                 break;
			}
			/*Remove Employee*/
			case 5:{
				 System.out.println("Enter employee ID you want to remove:");
	             int employeeId = sc.nextInt();
	             es.removeEmployee(employeeId);
	             break;
			}
			/*Generate Payroll*/
			case 6:{
				pys.generatePayroll();
				break;
			}
			/* Get Payroll by ID*/
			case 7:{
				System.out.println("Enter the payroll ID :");
				int payrollId = sc.nextInt();
				pys.getPayrollById(payrollId);
				break;
			}
			/* Get Payrolls for Employee*/
			case 8:{
				System.out.println("Enter Employee ID:");
			    int employeeId = sc.nextInt();
			    List<Payroll> payrolls = pys.getPayrollsForEmployee(employeeId);
				if (payrolls.isEmpty()) {
				    System.out.println("No payrolls found for employee ID: " + employeeId);
				} else {
				    System.out.println("Payrolls for employee ID " + employeeId + ":");
				    for (Payroll payroll : payrolls) {
				        System.out.println(payroll);
				    }
				}
			    break;
			}
			/* Get Payrolls for Period*/
			case 9:{
				 System.out.println("Enter start date (YYYY-MM-DD):");
                 String startDateStr = sc.next();
                 LocalDate startDate = LocalDate.parse(startDateStr);
                 System.out.println("Enter end date (YYYY-MM-DD):");
                 String endDateStr = sc.next();
                 LocalDate endDate = LocalDate.parse(endDateStr);
                 List<Payroll> payrolls = pys.getPayrollsForPeriod(startDate, endDate);
                 if (payrolls != null && !payrolls.isEmpty()) {
                     System.out.println("Payrolls for the period:");
                     for (Payroll payroll : payrolls) {
                         System.out.println(payroll);
                     }
                 } else {
                     System.out.println("No payrolls found for the specified period.");
                 }
                 break;
             }
			/* Calculate Tax*/
			case 10:{
			            TaxService taxService = new TaxService();

			            System.out.println("Enter employee ID:");
			            int employeeId = sc.nextInt();

			            System.out.println("Enter tax year:");
			            int taxYear = sc.nextInt();

			            try {
			                Tax tax = taxService.calculateTax(employeeId, taxYear);
			                if (tax != null) {
			                    System.out.println("Tax calculated successfully and stored in the database.");
			                } else {
			                    System.out.println("Error calculating tax.");
			                }
			            } catch (TaxCalculationException e) {
			                System.out.println("Error calculating tax: " + e.getMessage());
			            }
			       break;
			        }
			/*Get Tax by ID*/
			case 11:{ 
				System.out.println("Enter the Tax ID :");
				int taxId = sc.nextInt();
				ts.getTaxById(taxId);
				break;
			}
			/* Get Taxes for Employee*/
			case 12:{
				System.out.println("Enter Employee ID:");
			    int employeeId = sc.nextInt();
			    List<Tax> Taxlist = ts.getTaxesForEmployee(employeeId);
				if (Taxlist.isEmpty()) {
				    System.out.println("No Taxes found for employee ID" + employeeId);
				} else {
				    System.out.println("Taxes for employee ID " + employeeId + ":");
				    for (Tax tax : Taxlist) {
				        System.out.println(tax);
				    }
				}
			    break;				
			}
			/* Get Taxes for Year*/
			case 13:{
				System.out.println("Enter Tax Year");
				int taxYear = sc.nextInt();
				List<Tax> Taxlistt = ts.getTaxesForYear(taxYear);
				if(Taxlistt.isEmpty()) {
					System.out.println("No Taxes available in taxYear" + taxYear);
				}else {
					System.out.println("Taxes for the Year" + taxYear + ":");
					for(Tax tax : Taxlistt) {
						System.out.println(tax);
					}
				}
				break;
			}
			/* Add Financial Record*/
			case 14:{
				System.out.println("Add Financial Record");
				fs.addFinancialRecord();
				break;
			}
			/* Get Financial Record by ID*/
			case 15:{
				System.out.println("Enter the record ID :");
				int recordId = sc.nextInt();
				fs.getFinancialRecordById(recordId);
				break;			
			}
			/*Get Financial Records for Employee*/
			case 16:{ 
				System.out.println("Enter Employee ID:");
			    int employeeId = sc.nextInt();
			    List<FinancialRecord> financial = fs.getFinancialRecordsForEmployee(employeeId);
				if (financial.isEmpty()) {
				    System.out.println("No Financial Record  found for employee ID: " + employeeId);
				} else {
				    System.out.println("Payrolls for employee ID " + employeeId + ":");
				    for (FinancialRecord financialRecord : financial) {
				        System.out.println(financial);
				    }
				}
			    break;				
			}
			/*Get Financial Records for date*/
			case 17:{
				System.out.println("Enter date (YYYY-MM-DD):");
				String dateStr = sc.next();
				LocalDate date = LocalDate.parse(dateStr);
				List<FinancialRecord> records = fs.getFinancialRecordsForDate(date);
				if (records != null && !records.isEmpty()) {
				    System.out.println("Financial records for the date:");
				    for (FinancialRecord record : records) {
				        System.out.println(record);
				    }
				} else {
				    System.out.println("No financial records found for the specified date.");
				}
								
			}
			default:{
				System.out.println("Enter the right choice ");
			}
			}
			System.out.println("Do you want to continue? y or Y");
			ch=sc.next();
	}while (ch.equals("Y") || ch.equals("y"));
		System.out.println("Thanks for using our system !!!");
		System.exit(0);
	}
}


