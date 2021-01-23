package com.vmware.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vmware.employee.model.Employee;

import lombok.Data;

/**
 * The Class EmployeeEntity.
 */
@Entity
@Table(name = "employee")

/**
 * Instantiates a new employee entity.
 */
@Data
public class EmployeeEntity {
	
	/** The id. */
	@Id
	@Column(name = "emp_id")
	private Integer id;
	
	/** The age. */
	@Column(name = "emp_age")
	private Integer age;
	     
	/** The emp name. */
	@Column(name = "emp_name")
	private String empName;
	
	/**
	 * To convert employee.
	 *
	 * @return the employee
	 */
	public Employee _toConvertEmployee() {
		Employee emp = new Employee();
		emp.setEName(empName);
		emp.setAge(age);
		emp.setId(id);
		return emp;
	}
}
