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
	public void doTransaction() {
		if(this.account.getAccountType().equals("Savings Account")) {
			SavingsAccount account = (SavingsAccount)this.account;
			account.withdraw(ammount);
		}else {
			CurrentAccount curAccount = (CurrentAccount)this.account;
			curAccount.withdraw(this.ammount);
		}
		// TODO Auto-generated method stub
		
	}


	@Override
	public String toString() {
		return "Transaction ID:"+this.transactionId+ " Type:"+ this.transactionType+ " Ammount: "+this.ammount+ " dollars";
	}
	
}
