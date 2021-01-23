package com.vmware.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmware.employee.entity.EmployeeEntity;

/**
 * The Interface EmployeeRepository.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

}
