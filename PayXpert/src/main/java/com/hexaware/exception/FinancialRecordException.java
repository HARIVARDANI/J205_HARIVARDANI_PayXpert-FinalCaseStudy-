package com.hexaware.exception;

/**
 * Exception class to handle financial record-related errors.
 */

@SuppressWarnings("serial")
public class FinancialRecordException extends Exception {
	
	/**
     * Constructs a new FinancialRecordException with the specified detail message.
     * @param message The detail message.
     */
    public FinancialRecordException(String message) {
        super(message);
    }
}
