package com.vmware.employee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.NotNull;
import com.vmware.employee.constants.EmployeeConstants;
import com.vmware.employee.exceptions.EmployeeNotFoundException;
import com.vmware.employee.model.Employee;
import com.vmware.employee.model.Transaction;
import com.vmware.employee.response.PostAPIResponse;
import com.vmware.employee.service.EmployeeService;

/**
 * The Class EmployeeController.
 */
@RestController
@CrossOrigin("*")
public class EmployeeController {

	/** The employee service. */
	@Autowired
	EmployeeService employeeService;

	/**
	 * Save employee data.
	 *
	 * @param file the file
	 * @return the response entity
	 */
	@PostMapping(value = EmployeeConstants.EMPLOYEES, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<PostAPIResponse> saveEmployees(
			@RequestParam("file") @Validated @NotNull MultipartFile file) {
		PostAPIResponse result = new PostAPIResponse();
		String transactionId = employeeService.saveEmployeeData(file);
		result.setTransactionId(transactionId);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	/**
	 * Gets the transcation status.
	 *
	 * @param transactionId the transaction id
	 * @return the transcation status
	 */
	@GetMapping(value = EmployeeConstants.STATUS_TRANSACTIONID)
	public ResponseEntity<Transaction> getTranscationStatus(
			@PathVariable(value = "transactionId") String transactionId) {
		return new ResponseEntity<>(employeeService.getTransactionStatus(transactionId), HttpStatus.OK);
	}

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	@GetMapping(value = EmployeeConstants.EMPLOYEES)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<>(employeeService.getAllEmployeesData(), HttpStatus.OK);
	}

	/**
	 * Gets the employee data.
	 *
	 * @param empId the emp id
	 * @return the employee data
	 */
	@GetMapping(value = EmployeeConstants.EMPLOYEES_ID)
	public ResponseEntity<Employee> getEmployee(@PathVariable(value = "empId") Integer empId) {
		return new ResponseEntity<>(employeeService.getEmployeeData(empId), HttpStatus.OK);
	}

	/**
	 * Update employee data.
	 *
	 * @param empId    the emp id
	 * @param employee the employee
	 * @return the response entity
	 */
	@PutMapping(value = EmployeeConstants.EMPLOYEES_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "empId") Integer empId,
			@Validated @RequestBody Employee employee) throws EmployeeNotFoundException {
		Employee emp = employeeService.updateEmployeeData(employee, empId);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	/**
	 * Delete employee data.
	 *
	 * @param empId the emp id
	 * @return the response entity
	 */
	@DeleteMapping(value = EmployeeConstants.EMPLOYEES_ID)
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "empId") Integer empId)
			throws EmployeeNotFoundException {
		return employeeService.deleteEmployeeData(empId);
	}
}
