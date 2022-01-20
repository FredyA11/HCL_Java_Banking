package com.banking.bank;

import java.util.ArrayList;
import java.util.Scanner;

import com.banking.accounts.Account;
import com.banking.accounts.CurrentAccount;
import com.banking.accounts.SavingsAccount;
import com.banking.accounts.MortgaugeAccount;
import com.banking.transactions.Transaction;
import com.banking.transactions.TransactionProcessor;
import com.banking.customers.Customer;

public class BankManager {
	
	private static final String BANK_NAME= "BBVA Mexico";
	private static final String BANK_ADDRESS = "Santa Fe, Mexico";
	private static final String BANK_CODE= "002";
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	private static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	TransactionProcessor transactionProcessor = new TransactionProcessor();
	Scanner sc= new Scanner(System.in);
	
	public void runBankSystem() {
		int option=0;
		
		while(option!=7) {
			
			System.out.println("Welcome to "+BANK_NAME +" ("+BANK_ADDRESS+"), please select a service below:");
			System.out.println("1) New customer");
			System.out.println("2) New account");
			System.out.println("3) Make a Transaction");
			System.out.println("4) See all customers");
			System.out.println("5) See all transactions");
			option= Integer.parseInt(sc.next());
			switch(option) {
				case 1:
					newCustomer();
					//sc.nextLine();
					break;
				case 2: 
					newAccount();
					break;
				case 3:
					newTransaction();
					break;
				case 4:
					consultCustomers();
					break;
				case 5:
					consultTransactions();
					
			}
			System.out.println("------------------------------");
		}
	}
	
	private boolean findCustomer(int id) {
		boolean found=false;
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getClientId() ==id) {
				found=true;
				break;
			}
		}
		return found;
	}
	
	private void consultTransactions() {
		for(Transaction t: transactions) {
			System.out.println(t.toString());
		}
	}
	
	private void consultCustomers() {
		for(Customer c: customers) {
			System.out.println("Client ID:"+c.getClientId()+" Name:"+c.getFullName());
		}
	}
	
	private void newTransaction() {
		Transaction transaction = transactionProcessor.startNewTransaction(customers,transactions,accounts,sc);
		transactions.add(transaction);
	}
	
	private void newAccount() {
		boolean found=false;
		System.out.println("Please enter the customer's ID:");
		int id = sc.nextInt();
		
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getClientId() ==id) {
				found=true;
				break;
			}
		}
		if(!found) {
			System.out.println("Client ID not found , try again . . .");
			return;
		}
		
		System.out.println("Please enter the account type 1)Savings 2)Current 3)Mortgauge:");
		int accountType = sc.nextInt();
		int accountId = accounts.size();
		switch(accountType) {
		case 1:
			SavingsAccount account = new SavingsAccount(id,accountId);
			accounts.add(account);
			System.out.println(account.toString()+ "created");
			break;
		case 2:
			CurrentAccount currAccount = new CurrentAccount(id,accountId);
			System.out.println(currAccount.toString()+ "created");
			accounts.add(currAccount);
			break;
		case 3:
			System.out.println("Please enter the ammount of money for the mortgauge:");
			float debt = sc.nextFloat();
			MortgaugeAccount mortAccount = new MortgaugeAccount(id,accountId,debt);
			System.out.println(mortAccount.toString()+ " created");
			accounts.add(mortAccount);
			break;
		}
	}
	
	private void newCustomer() {
		Scanner sc= new Scanner(System.in);
		int clientId = customers.size();
		System.out.println("Please enter the customer's first name:");
		String customerName = sc.next();
		System.out.println("Please enter the customer's last name:");
		String customerLastName = sc.next();
		String fullName= customerName+ " "+ customerLastName;
		System.out.println("Please enter the customer's address:");
		String address = sc.next();
		Customer customer = new Customer(clientId,customerName,customerLastName,fullName,address);
		customers.add(customer);
		System.out.println(customer.toString());
	}


}
