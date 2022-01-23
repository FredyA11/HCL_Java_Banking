package com.banking.transactions;

import com.banking.accounts.Account;
import com.banking.accounts.MortgaugeAccount;

public class DebtPay extends Transaction {
	
	private float ammount;

	public DebtPay(Account account,long clientId,long transactionId,float ammount) {
		this.transactionType= "Debt pay";
		this.account=account;
		this.clientId=clientId;
		this.transactionId=transactionId;
		this.ammount=ammount;
	}


	@Override
	public String toString() {
		return "Transaction ID:"+this.transactionId+ " Type:"+ this.transactionType+ " Ammount: "+this.ammount+ " dollars";
	}
	
}
