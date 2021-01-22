package com.vmware.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmware.employee.entity.TransactionEntity;

@Repository
public interface TranscationStatusRepository extends JpaRepository<TransactionEntity, Integer>{
	TransactionEntity findByTransactionid(String trnasactionid);
}
