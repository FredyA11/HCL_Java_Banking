package com.banking.transactions;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDateTime;
import com.banking.accounts.Account;
import com.banking.accounts.CurrentAccount;
import com.banking.accounts.MortgaugeAccount;
import com.banking.accounts.SavingsAccount;
import com.banking.customers.Customer;
import com.banking.transactions.Transaction;

public class TransactionProcessor {
	
	
	public TransactionProcessor() {
		
	}
	
	private Account findAccount(long id,ArrayList<Account> accounts) {
		for(int i=0;i<accounts.size();i++) {
			if(accounts.get(i).getAccountId() ==id) {
				return accounts.get(i);
			}
		}
		
		return null;
	}
	
	

	public Transaction startNewTransaction(ArrayList<Customer> customers, ArrayList<Transaction> transactions , ArrayList<Account> accounts , Scanner sc) {
		System.out.println("Please enter the customer's ID:");
		int id= sc.nextInt();
		boolean found=false;
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getClientId() ==id) {
				found=true;
				break;
			}
		}
		System.out.println("Select type of transaction 1)Debit 2)Credit");
		int transactionType= sc.nextInt();
		switch(transactionType) {
			case 1:
				System.out.println("Available debit transactions:");
				System.out.println("SAVING ACCOUNTS: 1)Add funds  2)Withdraw");
				System.out.println("CURRENT ACCOUNTS: 3)Add funds 4)Withdraw");
				int operation= sc.nextInt();
				if(operation==1) {
					System.out.println("Enter account id:");
					int accountId= sc.nextInt();
					SavingsAccount account = (SavingsAccount)findAccount(accountId,accounts);
					System.out.println("Enter ammount to deposit:");
					float ammount = sc.nextFloat();
					int transactionId = transactions.size();
					Transaction transaction= new Deposit(account,id,transactionId,ammount);
					transaction.doTransaction();
					return transaction;
				}else if(operation==2) {
					System.out.println("Enter account id:");
					int accountId= sc.nextInt();
					SavingsAccount account = (SavingsAccount)findAccount(accountId,accounts);
					System.out.println("Enter ammount to withdraw:");
					float ammount = sc.nextFloat();
					int transactionId = transactions.size();
					Transaction transaction= new Withdraw(account,id,transactionId,ammount);
					transaction.doTransaction();
					return transaction;
				}else if(operation==3) {
					System.out.println("Enter account id:");
					int accountId= sc.nextInt();
					CurrentAccount account = (CurrentAccount)findAccount(accountId,accounts);
					System.out.println("Enter ammount to deposit:");
					float ammount = sc.nextFloat();
					int transactionId = transactions.size();
					Transaction transaction= new Deposit(account,id,transactionId,ammount);
					transaction.doTransaction();
					return transaction;
				}else if(operation==4) {
					System.out.println("Enter account id:");
					int accountId= sc.nextInt();
					SavingsAccount account = (SavingsAccount)findAccount(accountId,accounts);
					
					System.out.println("Enter ammount to withdraw:");
					float ammount = sc.nextFloat();
					int transactionId = transactions.size();
					Transaction transaction= new Withdraw(account,id,transactionId,ammount);
					transaction.doTransaction();
					return transaction;
				}
				break;
			case 2:
				System.out.println("Available credit transactions:");
				System.out.println("MORTGAUGE ACCOUNT: 1)Pay debt");
				int op= sc.nextInt();
				if(op==1) {
					System.out.println("Enter account id:");
					int accountId= sc.nextInt();
					MortgaugeAccount account = (MortgaugeAccount)findAccount(accountId,accounts);
					System.out.println("Enter ammount to pay:");
					float ammount = sc.nextFloat();
					int transactionId = transactions.size();
					Transaction transaction= new DebtPay(account,id,transactionId,ammount);
					transaction.doTransaction();
					return transaction;
				}
		}
		
		return null;
	}
}
