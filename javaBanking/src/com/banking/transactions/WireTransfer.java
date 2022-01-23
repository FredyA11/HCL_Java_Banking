package com.banking.transactions;

import com.banking.accounts.Account;

public class WireTransfer extends Transaction{

	private Account senderAccount;
	private Account receiverAccount;
	private float ammount;
	
	public WireTransfer(Account senderAccount,Account receiverAccount,long transactionId,float ammount) {
		this.transactionType= "Wire Transfer";
		this.ammount = ammount;
		this.senderAccount = senderAccount;
		this.receiverAccount = receiverAccount;
		this.transactionId= transactionId;
	}
	
	@Override
	public String toString() {
		return "Transaction ID:"+this.transactionId+ " Type:"+ this.transactionType+ " Ammount: "+this.ammount+ " dollars \n Realated accounts: \n Sender Account:"+ this.senderAccount.toString() + "\n Receiver Account:"+this.receiverAccount.toString();
	}
	
}
