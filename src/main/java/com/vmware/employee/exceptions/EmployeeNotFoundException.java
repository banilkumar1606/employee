package com.vmware.employee.exceptions;

/**
 * The Class EmployeeNotFoundException.
 */
public class EmployeeNotFoundException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new employee not found exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new employee not found exception.
	 *
	 * @param message the message
	 */
	public EmployeeNotFoundException(String message) {
		super(message);
	}
	

}
