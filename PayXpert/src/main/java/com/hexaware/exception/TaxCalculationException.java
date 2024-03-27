package com.hexaware.exception;

import java.sql.SQLException;

@SuppressWarnings("serial")
public class TaxCalculationException extends Exception {
	
	 /**
     * Constructs a new TaxCalculationException with the specified detail message.
     * 
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public TaxCalculationException(String message) {
        super(message);
    }
    
    /**
     * Constructs a new TaxCalculationException with the specified detail message and SQL exception.
     * 
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     * @param sqlException the SQL exception (which is saved for later retrieval by the getCause() method)
     */

    public TaxCalculationException(String message, SQLException sqlException) {
        super(message, sqlException);
    }

}

