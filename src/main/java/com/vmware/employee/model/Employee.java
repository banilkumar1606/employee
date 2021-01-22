package com.vmware.employee.model;

import com.vmware.employee.entity.EmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
	private int id;
	private String eName;
	private int age;
	
	public EmployeeEntity _toConvertEmployeeEntity() {
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmpName(eName);
		emp.setAge(age);
		emp.setId(id);
		return emp;
	}
}
