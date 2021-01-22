package com.vmware.employee.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.vmware.employee.model.Employee;
import com.vmware.employee.model.Transaction;

public interface EmployeeService {
	public String saveEmployeeData(MultipartFile file);
	public Employee getEmployeeData(Integer empId);
	public Map<String, Boolean> deleteEmployeeData(Integer empId);
	public Transaction getTransactionStatus(String transactionId);
	public Employee updateEmployeeData(Employee employee, Integer empId);
	public List<Employee> getAllEmployeesData();
}
