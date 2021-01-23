package com.vmware.employee.model;

import com.vmware.employee.entity.EmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Sets the age.
 *
 * @param age the new age
 */
@Data

/**
 * Instantiates a new employee.
 *
 * @param id the id
 * @param eName the e name
 * @param age the age
 */
@AllArgsConstructor

/**
 * Instantiates a new employee.
 */
@NoArgsConstructor

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@ToString

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@EqualsAndHashCode
public class Employee {
	
	/** The id. */
	private int id;
	
	/** The e name. */
	private String eName;
	
	/** The age. */
	private int age;
	
	/**
	 * To convert employee entity.
	 *
	 * @return the employee entity
	 */
	public EmployeeEntity _toConvertEmployeeEntity() {
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmpName(eName);
		emp.setAge(age);
		emp.setId(id);
		return emp;
	}
}
