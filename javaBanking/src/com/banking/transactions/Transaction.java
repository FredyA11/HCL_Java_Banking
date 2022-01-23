package com.banking.transactions;

import java.util.Date;

import com.banking.accounts.Account;

public abstract class Transaction {

	protected Account account;
	protected long clientId;
	protected String transactionType;
	protected long transactionId;
	protected Date transactionDate;
	
	public abstract String toString();
}
