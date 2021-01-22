package com.vmware.employee.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vmware.employee.constants.EmployeeConstants;
import com.vmware.employee.constants.STATUS;
import com.vmware.employee.entity.EmployeeEntity;
import com.vmware.employee.entity.TransactionEntity;
import com.vmware.employee.exceptions.EmployeeException;
import com.vmware.employee.exceptions.EmployeeNotFoundException;
import com.vmware.employee.model.Employee;
import com.vmware.employee.model.Transaction;
import com.vmware.employee.repository.EmployeeRepository;
import com.vmware.employee.repository.TranscationStatusRepository;
import com.vmware.employee.service.EmployeeService;
import com.vmware.employee.util.EmployeeUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeUtil empUtil;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	TranscationStatusRepository transactionRepository;

	@Override
	public String saveEmployeeData(MultipartFile file) {
		String transactionId = null;
		try {
			transactionId = UUID.randomUUID().toString();
			List<Employee> empList = empUtil.processInputFile(file);
			Transaction transaction = new Transaction();
			transaction.setTransactionid(transactionId);
			transaction.setStatus(STATUS.IN_PROGRESS);
			CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> saveEmployees(empList, transaction))
					.whenComplete((data, error) -> {
						printStatus(data);
						if (error != null) {
							log.info(error.toString());
							transaction.setStatus(STATUS.FAILED);
							transactionRepository.save(transaction._toConvertTransactionEntity());
						}
					});
			try {
				cf.get();
			} catch (InterruptedException e) {
				log.error("While processing the data got exception" + e);
				transaction.setStatus(STATUS.FAILED);
				transactionRepository.save(transaction._toConvertTransactionEntity());
			} catch (ExecutionException e) {
				log.error("While processing the data got exception" + e);
				transaction.setStatus(STATUS.FAILED);
				transactionRepository.save(transaction._toConvertTransactionEntity());
			}
		} catch (Exception e) {
			log.error("While processing the data got exception" + e);
			throw new EmployeeException("While processing the input file got exception please try again");
		}

		return transactionId;
	}

	private void printStatus(String data) {
		log.info("Result:" + data);
	}

	private String saveEmployees(List<Employee> empList, Transaction transaction) {
		empList.stream().forEach(e -> {
			transaction.setStatus(STATUS.IN_PROGRESS);
			employeeRepository.save(e._toConvertEmployeeEntity());
			transactionRepository.save(transaction._toConvertTransactionEntity());
		});
		transaction.setStatus(STATUS.SUCCESS);
		transactionRepository.save(transaction._toConvertTransactionEntity());
		return EmployeeConstants.SUCCESS;
	}

	@Override
	public Employee getEmployeeData(Integer empID) {
		Optional<EmployeeEntity> empEntity = employeeRepository.findById(empID);
		if (empEntity.isPresent()) {
			return empEntity.get()._toConvertEmployee();
		}else {
			throw new EmployeeNotFoundException("Employee not found for this id :: " + empID);
		}
	}

	@Override
	public Map<String, Boolean> deleteEmployeeData(Integer empID) {
		EmployeeEntity employee = employeeRepository.findById(empID)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id :: " + empID));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@Override
	public Transaction getTransactionStatus(String transactionId) {
		TransactionEntity transactionEntity;
		try {
			transactionEntity = transactionRepository.findByTransactionid(transactionId);
		} catch (Exception e) {
			log.error("While fetching the data got exception" + e);
			throw new EmployeeException("While fetching the status file got exception");
		}
		return transactionEntity._toConvertTransaction();
	}

	@Override
	public List<Employee> getAllEmployeesData() {
		List<Employee> empList = new ArrayList<>();
		List<EmployeeEntity> entityList = employeeRepository.findAll();
		entityList.stream().forEach(e -> {
			empList.add(e._toConvertEmployee());
		});
		return empList;
	}

	@Override
	public Employee updateEmployeeData(Employee employee, Integer empId) {
		EmployeeEntity employeeEntity = employeeRepository.findById(empId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id :: " + empId));
		employeeEntity.setAge(employee.getAge());
		employeeEntity.setEmpName(employee.getEName());
		final EmployeeEntity updatedEmployee = employeeRepository.save(employeeEntity);
		return updatedEmployee._toConvertEmployee();
	}

}
