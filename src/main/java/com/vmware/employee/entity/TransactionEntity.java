package com.vmware.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vmware.employee.constants.STATUS;
import com.vmware.employee.model.Transaction;

import lombok.Data;

@Entity
@Table(name = "Transaction_Status")
@Data
public class TransactionEntity {
	@Id
	@Column(name = "transactionid")
	private String transactionid;
	
	@Column(name = "status")
	private String status;
	
	public Transaction _toConvertTransaction() {
		Transaction transaction = new Transaction();
		transaction.setTransactionid(transactionid);
		transaction.setStatus(STATUS.valueOf(status));
		return transaction;
	}
}
