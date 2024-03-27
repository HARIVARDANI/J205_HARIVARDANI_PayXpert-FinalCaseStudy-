package com.hexaware.exception;

/**
 * Exception class to handle cases of invalid input.
 */

@SuppressWarnings("serial")
public class InvalidInputException extends Exception{
	
	/**
     * Constructs a new InvalidInputException with the specified detail message.
     * @param message The detail message.
     */
	
	public InvalidInputException(String message)
	{
		super(message);
	}

}
