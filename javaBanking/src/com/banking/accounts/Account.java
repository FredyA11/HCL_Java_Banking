package com.banking.accounts;

import java.util.Date;

public abstract class Account {
	
	protected long accountId;
	protected float accountBalance;
	protected Date openingDate;
	protected Date expirationDate;
	protected long clientId;
	protected String accountType;
	
	public abstract long getAccountId();
	public abstract double getAccountBalance();
	public abstract Date getExpirationDate();
	
	public String getAccountType() {
		return this.accountType;
	};
	
	public String toString() {
		
		return "Account id:"+ this.accountId + ", ClientId:"+ this.clientId + ",AccountType:"+this.accountType;
	};
	
}
