package com.banking.accounts;

import java.util.Date;

public class SavingsAccount extends Account {

	
	public SavingsAccount(long clientId,long accountId,Date openingDate) {
		this.accountType=new String("Savings Account");
		this.clientId = clientId;
		this.accountId = accountId;
		this.accountBalance= 0;
		this.openingDate= openingDate;
	}


	@Override
	public String toString() {
		return "Saving Account Details: \n ID:"+this.accountId+"\n Client Id: "+ this.clientId+ "\n Account Balance:"+this.accountBalance+" \n Opening Date:"+ this.openingDate;
	}

}
