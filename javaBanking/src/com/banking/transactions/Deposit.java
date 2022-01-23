package com.banking.transactions;

import java.util.Date;

import com.banking.accounts.Account;
import com.banking.accounts.CurrentAccount;
import com.banking.accounts.SavingsAccount;

public class Deposit extends Transaction {

	private float ammount;
	
	public Deposit(Account account,long clientId,long transactionId,float ammount) {
		this.transactionType= "Deposit";
		this.ammount = ammount;
		this.account = account;
		this.clientId= clientId;
		this.transactionId= transactionId;
	}
	

	@Override
	public String toString() {
		return "Transaction ID:"+this.transactionId+ " Type:"+ this.transactionType+ " Ammount: "+this.ammount+ " dollars \n Realated account: \n"+ this.account.toString();
	}

}
