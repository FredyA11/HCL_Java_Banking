package com.banking.accounts;

import java.util.Date;

public class MortgaugeAccount extends Account {
	
	private float debt;
	private float interest;
	private int months;
	private float payments;

	{
		this.interest = 0.12f;
	}
	
	public MortgaugeAccount(long clientId,long accountId,int months,float debt,Date openingDate) {
		this.accountType=new String("Mortgauge Account");
		this.clientId= clientId;
		this.accountId=accountId;
		this.openingDate=openingDate;
		this.debt = debt;
		this.months = months;
		this.payments = (debt/months)+((debt/months) * interest);
	}
	
	public float getPayments() {
		return this.payments;
	}
	
	public float getDebt() {
		return this.debt;
	}
	
	public void setDebt(float debt) {
		this.debt=debt;
	}

	@Override
	public String toString() {
		return "Mortgauge Account Details: \n ID:"+this.accountId+"\n Client Id: "+ this.clientId+ "\n Account debt:"+this.debt+" \n Opening Date:"+ this.openingDate +" \n Interest rate:"+ this.interest;
	}
	
	
}
