package com.vmware.employee.model;

import com.vmware.employee.constants.STATUS;
import com.vmware.employee.entity.TransactionEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Instantiates a new transaction.
 */
@NoArgsConstructor

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@EqualsAndHashCode
public class Transaction {
	
	/** The transactionid. */
	private String transactionid;
	
	/** The status. */
	private STATUS status;
	
	/**
	 * To convert transaction entity.
	 *
	 * @return the transaction entity
	 */
	public TransactionEntity _toConvertTransactionEntity() {
		TransactionEntity transaction = new TransactionEntity();
		transaction.setStatus(status.toString());
		transaction.setTransactionid(transactionid);
		return transaction;
	}
}
