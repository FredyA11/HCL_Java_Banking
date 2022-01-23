package com.banking.accounts;

import java.util.ArrayList;
import java.util.Calendar;

import com.banking.customers.CustomerDAO;
import com.banking.transactions.Withdraw;

public class AccountDAO {

	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	public Account addSavingsAccount(long clientId) {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		int accountId = accounts.size();
		SavingsAccount savingsAccount = new SavingsAccount(clientId,accountId,today.getTime());
		accounts.add(savingsAccount);
		return savingsAccount;
	}
	
	public Account addCurrentAccount(long clientId) {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		int accountId = accounts.size();
		CurrentAccount currentAccount = new CurrentAccount(clientId,accountId,today.getTime());
		accounts.add(currentAccount);
		return currentAccount;
	}
	
	public Account addMortgaugeAccount(long clientId,float ammount,int months) {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		int accountId = accounts.size();
		MortgaugeAccount mortgaugeAccount = new MortgaugeAccount(clientId,accountId,months,ammount,today.getTime());
		accounts.add(mortgaugeAccount);
		return mortgaugeAccount;
	}
	
	
	public Account addFundsToAccount(String accountType,long accountId,float ammount) {
		for(int i=0;i<accounts.size();i++) {
			if(accounts.get(i).getAccountType().equals(accountType) && accounts.get(i).getAccountId() == accountId) {
				Account account = accounts.get(i);
				float balance = account.getAccountBalance();
				balance+= ammount;
				account.setAccountBalance(balance);
				return account;
			}
		}
		return null;
		
	}
	
	public Account withdrawFromAccount(String accountType,long accountId, float ammount) {
		for(int i=0;i<accounts.size();i++) {
			if(accounts.get(i).getAccountType().equals(accountType) && accounts.get(i).getAccountId() == accountId) {
				Account account = accounts.get(i);
				float balance = account.getAccountBalance();
				if(balance-ammount>=0) {
					balance = balance-ammount;
					account.setAccountBalance(balance);
					return account;
				}
				
			}
		}
		return null;
	}
	
	public Account payDebtFromAccount(long accountId,float ammount) {
		for(int i=0;i<accounts.size();i++) {
			if(accounts.get(i).getAccountType().equals("Mortgauge Account") && accounts.get(i).getAccountId() == accountId) {
				MortgaugeAccount account = (MortgaugeAccount)accounts.get(i);
				float debt = account.getDebt();
				if(debt-ammount>0) {
					debt-= ammount;
					account.setDebt(debt);
					
					return account;
				}
				else {
					System.out.println("The total debt has been payed");
					return account;
				}
				
			}
		}
		return null;
	}
	
	public Account[] transferFundsToAccount(String accountType,long senderAccountId,long receiverAccountId,float ammount) {
		Account[] transferAccounts = new Account[2];
		for(int i=0;i<accounts.size();i++) {
			if(accounts.get(i).getAccountType().equals(accountType) && accounts.get(i).getAccountId() == senderAccountId) {
				Account account = accounts.get(i);
				float balance = account.getAccountBalance();
				if(balance-ammount>=0) {
					balance = balance-ammount;
					account.setAccountBalance(balance);
					transferAccounts[0]= account;
				}	
			}
			else if(accounts.get(i).getAccountType().equals(accountType) && accounts.get(i).getAccountId() == receiverAccountId) {
				Account account = accounts.get(i);
				float balance = account.getAccountBalance();
				balance+= ammount;
				account.setAccountBalance(balance);
				transferAccounts[1] = account;
			}
			
		}
		
		return transferAccounts;
		
	}
	

	public Account getAccountDetails(String accountType,long accountId) {
		
		for(int i=0;i<accounts.size();i++) {
			if(accounts.get(i).getAccountType().equals(accountType) && accounts.get(i).getAccountId()==accountId) {
				return accounts.get(i);
			}
		}
		return null;
	}
	
	public float getMonthlyPaymentLoan(long accountId) {
		for(int i=0;i<accounts.size();i++) {
			if(accounts.get(i).getAccountType().equals("Mortgauge Account") && accounts.get(i).getAccountId()==accountId) {
				return ((MortgaugeAccount)accounts.get(i)).getPayments();
			}
		}
		return 0f;
	}
	

		
	public ArrayList<Account> getAccounts(){
		return this.accounts;
	}
	
}
