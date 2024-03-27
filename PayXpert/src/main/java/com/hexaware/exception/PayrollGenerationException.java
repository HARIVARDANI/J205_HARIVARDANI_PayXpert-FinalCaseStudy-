package com.hexaware.exception;

/**
 * Exception class to handle errors that occur during payroll generation.
 */
@SuppressWarnings("serial")
public class PayrollGenerationException extends Exception{
	
	/**
     * Constructs a new PayrollGenerationException with the specified detail message.
     * 
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */

	 public PayrollGenerationException(String message) {
	        super(message);
	    }
}
