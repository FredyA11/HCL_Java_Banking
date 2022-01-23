package com.banking.transactions;

import java.util.ArrayList;

import com.banking.accounts.Account;
import com.banking.accounts.CurrentAccount;
import com.banking.accounts.MortgaugeAccount;
import com.banking.accounts.SavingsAccount;

public class TransactionDAO {

	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	public Transaction makeDepositToSavings(ArrayList<Account> accounts,long accountId, float ammount) {
		for(int i=0;i<accounts.size();i++) {
			if(accounts.get(i).getAccountType().equals("Savings Account") && accounts.get(i).getAccountId() == accountId) {
				SavingsAccount account = (SavingsAccount)accounts.get(i);
				float balance = account.getAccountBalance();
				balance+= ammount;
				account.setAccountBalance(balance);
				long transactionId =  transactions.size();
				Deposit deposit = new Deposit(account,account.getClientId(),transactionId,ammount);
				transactions.add(deposit);
				return deposit;
			}
		}
		return null;
	}
	
	public Transaction newDepositTransaction(Account account, float ammount) {
		long transactionId =  transactions.size();
		Deposit deposit = new Deposit(account,account.getClientId(),transactionId,ammount);
		transactions.add(deposit);
		return deposit;
		
	}
	
	public Transaction newWithdrawTransaction(Account account,float ammount) {
		long transactionId =  transactions.size();
		Withdraw withdraw = new Withdraw(account,account.getClientId(),transactionId,ammount);
		transactions.add(withdraw);
		return withdraw;
	}
	
	public Transaction newWireTransferTransaction(Account senderAccount,Account receiverAccount,float ammount) {
		long transactionId =  transactions.size();
		WireTransfer wireTransfer = new WireTransfer(senderAccount,receiverAccount,transactionId,ammount);
		transactions.add(wireTransfer);
		return wireTransfer;
	}
	
	public Transaction newDebtPayTransaction(Account account,float ammount) {
		long transactionId =  transactions.size();
		DebtPay debtpay = new DebtPay(account,account.getClientId(),transactionId,ammount);
		transactions.add(debtpay);
		return debtpay;
	}
	
	public Transaction makeWithdrawFromSavings(ArrayList<Account> accounts,long accountId, float ammount) {
		for(int i=0;i<accounts.size();i++) {
			if(accounts.get(i).getAccountType().equals("Savings Account") && accounts.get(i).getAccountId() == accountId) {
				SavingsAccount account = (SavingsAccount)accounts.get(i);
				float balance = account.getAccountBalance();
				if(balance-ammount>=0) {
					balance = balance-ammount;
					account.setAccountBalance(balance);
					long transactionId =  transactions.size();
					Withdraw withdraw = new Withdraw(account,account.getClientId(),transactionId,ammount);
					transactions.add(withdraw);
					return withdraw;
				}
				
			}
		}
		return null;
	}
	
	public Transaction makeDepositToCurrent(ArrayList<Account> accounts,long accountId, float ammount) {
		for(int i=0;i<accounts.size();i++) {
			if(accounts.get(i).getAccountType().equals("Current Account") && accounts.get(i).getAccountId() == accountId) {
				CurrentAccount account = (CurrentAccount)accounts.get(i);
				float balance = account.getAccountBalance();
				balance+= ammount;
				account.setAccountBalance(balance);
				long transactionId =  transactions.size();
				Deposit deposit = new Deposit(account,account.getClientId(),transactionId,ammount);
				transactions.add(deposit);
				return deposit;
			}
		}
		return null;
	}
	
	public Transaction makeWithdrawFromCurrent(ArrayList<Account> accounts,long accountId, float ammount) {
		for(int i=0;i<accounts.size();i++) {
			if(accounts.get(i).getAccountType().equals("Current Account") && accounts.get(i).getAccountId() == accountId) {
				CurrentAccount account = (CurrentAccount)accounts.get(i);
				float balance = account.getAccountBalance();
				if(balance-ammount>=0) {
					balance = balance-ammount;
					account.setAccountBalance(balance);
					long transactionId =  transactions.size();
					Withdraw withdraw = new Withdraw(account,account.getClientId(),transactionId,ammount);
					transactions.add(withdraw);
					return withdraw;
				}
				
			}
		}
		return null;
	}
	
	public Transaction payMortagaugeAmmount(ArrayList<Account> accounts,long accountId,float ammount) {
		for(int i=0;i<accounts.size();i++) {
			if(accounts.get(i).getAccountType().equals("Mortgauge Account") && accounts.get(i).getAccountId() == accountId) {
				MortgaugeAccount account = (MortgaugeAccount)accounts.get(i);
				float currentDebt = account.getDebt();
				currentDebt-=ammount;
				account.setDebt(currentDebt);
				long transactionId =  transactions.size();
				DebtPay debtpay = new DebtPay(account,account.getClientId(),transactionId,ammount);
				transactions.add(debtpay);
				return debtpay;
			}
		}
		return null;
	}
}
