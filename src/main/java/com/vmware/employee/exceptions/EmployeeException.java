package com.vmware.employee.exceptions;

/**
 * The Class EmployeeException.
 */
public class EmployeeException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new employee exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public EmployeeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new employee exception.
	 *
	 * @param message the message
	 */
	public EmployeeException(String message) {
		super(message);
	}
	

}
