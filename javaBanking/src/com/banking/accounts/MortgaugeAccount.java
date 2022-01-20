package com.banking.accounts;

import java.util.Date;

public class MortgaugeAccount extends Account {
	
	private float debt;

	public MortgaugeAccount(long clientId,long accountId,float debt) {
		this.accountType=new String("Mortgauge Account");
		this.clientId= clientId;
		this.accountId=accountId;
		this.debt = debt;
	}
	
	public void payDebt(float ammount) {
		this.debt-=ammount;
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
