package com.banking.accounts;

import java.util.Date;

public class SavingsAccount extends Account {

	
	
	public SavingsAccount(long clientId,long accountId) {
		this.accountType=new String("Savings Account");
		this.clientId = clientId;
		this.accountId = accountId;
	}
	
	public SavingsAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public void addFunds(float ammount) {
		this.accountBalance += ammount;
	}
	
	public void withdraw(float ammount) {
		float difference = this.accountBalance - ammount;
		if(difference<0) {
			return;
		} 
		this.accountBalance-=ammount;
	}

	@Override
	public long getAccountId() {
		return this.accountId;
	}

	@Override
	public double getAccountBalance() {
		return this.accountBalance;
	}

	@Override
	public Date getExpirationDate() {
		return this.expirationDate;
	}

}
