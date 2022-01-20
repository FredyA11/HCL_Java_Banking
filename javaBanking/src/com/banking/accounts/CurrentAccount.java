package com.banking.accounts;

import java.util.Date;

public class CurrentAccount extends Account {

	public CurrentAccount(long clientId,long accountId) {
		this.accountType=new String("Current Account");
		this.clientId = clientId;
		this.accountId = accountId;
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
		// TODO Auto-generated method stub
		return this.accountId;
	}

	@Override
	public double getAccountBalance() {
		// TODO Auto-generated method stub
		return this.accountBalance;
	}

	@Override
	public Date getExpirationDate() {
		// TODO Auto-generated method stub
		return this.expirationDate;
	}

}
