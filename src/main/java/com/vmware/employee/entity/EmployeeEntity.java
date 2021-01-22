package com.vmware.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vmware.employee.model.Employee;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity {
	@Id
	@Column(name = "emp_id")
	private Integer id;
	
	@Column(name = "emp_age")
	private Integer age;
	     
	@Column(name = "emp_name")
	private String empName;
	
	public Employee _toConvertEmployee() {
		Employee emp = new Employee();
		emp.setEName(empName);
		emp.setAge(age);
		emp.setId(id);
		return emp;
	}
}
