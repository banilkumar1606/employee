package com.vmware.employee.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.vmware.employee.model.Employee;
import com.vmware.employee.model.Transaction;

/**
 * The Interface EmployeeService.
 */
public interface EmployeeService {
	
	/**
	 * Save employee data.
	 *
	 * @param file the file
	 * @return the string
	 */
	public String saveEmployeeData(MultipartFile file);
	
	/**
	 * Gets the employee data.
	 *
	 * @param empId the emp id
	 * @return the employee data
	 */
	public Employee getEmployeeData(Integer empId);
	
	/**
	 * Delete employee data.
	 *
	 * @param empId the emp id
	 * @return the map
	 */
	public Map<String, Boolean> deleteEmployeeData(Integer empId);
	
	/**
	 * Gets the transaction status.
	 *
	 * @param transactionId the transaction id
	 * @return the transaction status
	 */
	public Transaction getTransactionStatus(String transactionId);
	
	/**
	 * Update employee data.
	 *
	 * @param employee the employee
	 * @param empId the emp id
	 * @return the employee
	 */
	public Employee updateEmployeeData(Employee employee, Integer empId);
	
	/**
	 * Gets the all employees data.
	 *
	 * @return the all employees data
	 */
	public List<Employee> getAllEmployeesData();
}
