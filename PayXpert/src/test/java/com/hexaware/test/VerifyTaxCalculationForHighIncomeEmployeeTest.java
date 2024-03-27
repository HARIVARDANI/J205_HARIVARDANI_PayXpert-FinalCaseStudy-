package com.hexaware.test;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.hexaware.controller.TaxService;
import com.hexaware.exception.TaxCalculationException;

/**
 * A test class to verify tax calculation for high-income employees.
 */

public class VerifyTaxCalculationForHighIncomeEmployeeTest {

    private TaxService tax;
    private int highIncomeEmployeeId;
    
/**
  * Sets up the test environment by initializing the TaxService object and defining
  * the ID of a high-income employee.
  */
    @Before
    public void setUp() {
        tax = new TaxService();
        highIncomeEmployeeId = 103;
    }

 /**
   * Tests the calculation of tax for a high-income employee.
   *
   * @throws TaxCalculationException if an error occurs during tax calculation
   */    
    @Test
    public void testTaxCalculationForHighIncomeEmployee() throws TaxCalculationException {
        double expectedTaxAmount = 11400;
		double calculatedTaxAmount = tax.VerifyTaxCalculationForHighIncomeEmployee(highIncomeEmployeeId);
		assertEquals(expectedTaxAmount, calculatedTaxAmount,0.0);
		}
    }



