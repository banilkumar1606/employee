package com.vmware.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vmware.employee.constants.STATUS;
import com.vmware.employee.model.Transaction;

import lombok.Data;

/**
 * The Class TransactionEntity.
 */
@Entity
@Table(name = "Transaction_Status")

/**
 * Instantiates a new transaction entity.
 */
@Data
public class TransactionEntity {
	
	/** The transactionid. */
	@Id
	@Column(name = "transactionid")
	private String transactionid;
	
	/** The status. */
	@Column(name = "status")
	private String status;
	
	/**
	 * To convert transaction.
	 *
	 * @return the transaction
	 */
	public Transaction _toConvertTransaction() {
		Transaction transaction = new Transaction();
		transaction.setTransactionid(transactionid);
		transaction.setStatus(STATUS.valueOf(status));
		return transaction;
	}
}
