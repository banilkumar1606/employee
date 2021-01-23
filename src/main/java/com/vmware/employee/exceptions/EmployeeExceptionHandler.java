package com.vmware.employee.exceptions;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vmware.employee.constants.EmployeeConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class EmployeeExceptionHandler.
 */
@RestControllerAdvice

/** The Constant log. */
@Slf4j
public class EmployeeExceptionHandler {
	/**
	 * Handle EmployeeException.
	 *
	 * @param exception the exception
	 * @return the response entity
	 */

	@ExceptionHandler(EmployeeException.class)
	protected ResponseEntity<Object> handleEmployeeException(EmployeeException exception) {
		String correlationId = MDC.get(EmployeeConstants.TRACE_ID);
		log.error("Internal Service Error", exception);
		LogRefClass logref = LogRefClass.builder().logRef(correlationId).status(500).message(exception.getMessage())
				.build();
		return new ResponseEntity<>(logref, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Handle EmployeeException.
	 *
	 * @param exception the exception
	 * @return the response entity
	 */

	@ExceptionHandler(EmployeeNotFoundException.class)
	protected ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException exception) {
		String correlationId = MDC.get(EmployeeConstants.TRACE_ID);
		log.error("Internal Service Error", exception);
		LogRefClass logref = LogRefClass.builder().logRef(correlationId).status(404).message(exception.getMessage())
				.build();
		return new ResponseEntity<>(logref, HttpStatus.NOT_FOUND);
	}

	/**
	 * Handle Exception exception.
	 *
	 * @param exception the exception
	 * @return the response entity
	 */

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleException(Exception exception) {
		String correlationId = MDC.get(EmployeeConstants.TRACE_ID);
		log.error("Internal Service Error", exception);
		LogRefClass logref = LogRefClass.builder().logRef(correlationId).status(500).message(exception.getMessage())
				.build();
		return new ResponseEntity<>(logref, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
