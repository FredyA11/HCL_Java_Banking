package com.banking.transactions;

import com.banking.accounts.Account;
import com.banking.accounts.CurrentAccount;
import com.banking.accounts.SavingsAccount;

public class Withdraw extends Transaction {

	private float ammount;
	
	public Withdraw(Account account,long clientId,long transactionId,float ammount) {
		this.transactionType= "Withdraw";
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
