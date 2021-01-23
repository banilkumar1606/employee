package com.vmware.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmware.employee.entity.TransactionEntity;

/**
 * The Interface TranscationStatusRepository.
 */
@Repository
public interface TranscationStatusRepository extends JpaRepository<TransactionEntity, Integer>{
	
	/**
	 * Find by transactionid.
	 *
	 * @param trnasactionid the trnasactionid
	 * @return the transaction entity
	 */
	TransactionEntity findByTransactionid(String trnasactionid);
}
