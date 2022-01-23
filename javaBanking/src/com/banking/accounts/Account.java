package com.banking.accounts;

import java.util.Date;

public abstract class Account {
	
	protected long accountId;
	protected Date openingDate;
	protected long clientId;
	protected String accountType;
	protected float accountBalance;
	
	public abstract String toString();

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	};
	
	public void setAccountBalance(float value) {
		this.accountBalance = value;
	}
	
	public float getAccountBalance() {
		return this.accountBalance;
	}

	
}
