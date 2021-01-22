package com.vmware.employee.model;

import com.vmware.employee.constants.STATUS;
import com.vmware.employee.entity.TransactionEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Transaction {
	private String transactionid;
	private STATUS status;
	
	public TransactionEntity _toConvertTransactionEntity() {
		TransactionEntity transaction = new TransactionEntity();
		transaction.setStatus(status.toString());
		transaction.setTransactionid(transactionid);
		return transaction;
	}
}
