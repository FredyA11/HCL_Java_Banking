package com.banking.bank;
import com.banking.customers.CustomerDAO;

import java.util.Scanner;

import com.banking.accounts.Account;
import com.banking.accounts.AccountDAO;
import com.banking.accounts.SavingsAccount;
import com.banking.transactions.Transaction;
import com.banking.transactions.TransactionDAO;

public class CustomerService {

	private static final String BANK_NAME= "BBVA Mexico";
	private static final String BANK_ADDRESS = "Santa Fe, Mexico";
	private static CustomerDAO customerManager = new CustomerDAO();
	private static AccountDAO accountsManager = new AccountDAO();
	private static TransactionDAO transactionManager = new TransactionDAO();
	static Scanner sc= new Scanner(System.in);
	
	private static void startService() {
		int option=0;
		
		while(option!=3) {
			
			System.out.println("Welcome to "+BANK_NAME +" ("+BANK_ADDRESS+"), please select a service below:");
			System.out.println("1) Register");
			System.out.println("2) Login");
			System.out.println("3) Exit");
			option= Integer.parseInt(sc.next());
			switch(option) {
				case 1:
					System.out.println("Please enter your name: ");
					String name = sc.next();
					System.out.println("Please enter your last name: ");
					String lastName= sc.next();
					System.out.println("Please enter your address: ");
					String address = sc.next();
					System.out.println("Please enter your email: ");
					String email = sc.next();
					System.out.println("Please enter your phone: ");
					String phone = sc.next();
					System.out.println("Please set up a password: ");
					String password = sc.next();
					customerManager.addCustomer(name, lastName, address, email, phone,password);
					break;
				case 2:
					System.out.println("next enter your email: ");
					String loginEmail = sc.next();
					System.out.println("Please enter your password: ");
					String loginPassword= sc.next();
					if(customerManager.verifyLogin(loginEmail, loginPassword)) {
						long clientId = customerManager.searchClientId(loginEmail);
						int serviceOption = 0;
						while(serviceOption!=4) {
							System.out.println("Welcome back, Available services:");
							System.out.println("1) Open new account");
							System.out.println("2) Make a transaction");
							System.out.println("3) Accounts details");
							System.out.println("4) Logout");
							 
							serviceOption = sc.nextInt();
							if(serviceOption==1) {
								System.out.println("Please select one of the optios below");
								System.out.println("1) Savings Account");
								System.out.println("2) Current Account");
								System.out.println("3) Mortgauge Account");
								int accountOpt = sc.nextInt();
								if(accountOpt==1) {
									customerManager.linkAccountToCustomer(clientId, accountsManager.addSavingsAccount(clientId));
									System.out.println("---------New Savings Account created--------"); 
								}
								else if(accountOpt==2) {
									customerManager.linkAccountToCustomer(clientId, accountsManager.addCurrentAccount(clientId));
									System.out.println("---------New Current Account created--------");
								}
								else if(accountOpt==3) {
									System.out.println("Loan ammmount:");
									float ammount = sc.nextFloat();
									System.out.println("Loan months payment:");
									int months = sc.nextInt();
									customerManager.linkAccountToCustomer(clientId, accountsManager.addMortgaugeAccount(clientId,ammount,months));
									System.out.println("---------New mortgauge Account created--------");
								}
								
							}
							else if(serviceOption==2) {
								System.out.println("Please select one of the options below");
								System.out.println("1) Savings Account transactions");
								System.out.println("2) Current Account transactions");
								System.out.println("3) Mortgauge Account transactions");
								System.out.println("4) Transfer to account");
								int transactionOpt = sc.nextInt();
								if(transactionOpt==1) {
									System.out.println("Please select one of the options below");
									System.out.println("1) Deposit");
									System.out.println("2) Withdraw");
									int typeOption = sc.nextInt();
									if(typeOption==1) {
										customerManager.displayCustomerAccounts(clientId);
										System.out.println("Enter account id:");
										int actId = sc.nextInt();
										System.out.println("Enter ammount to deposit:");
										float ammount = sc.nextFloat();
										Account account = accountsManager.addFundsToAccount("Savings Account",actId, ammount);
										Transaction newTransaction = transactionManager.newDepositTransaction(account, ammount);
										customerManager.linkTransactionToCustomer(clientId, newTransaction);
										System.out.println("--------- New deposit to savings account transaction completed --------");
									}
									else if(typeOption==2) {
										customerManager.displayCustomerAccounts(clientId);
										System.out.println("Enter account id:");
										int actId = sc.nextInt();
										System.out.println("Enter ammount to withdraw:");
										float ammount = sc.nextFloat();
										Account account = accountsManager.withdrawFromAccount("Savings Account", actId, ammount);
										Transaction newTransaction  = transactionManager.newWithdrawTransaction(account, ammount);
										customerManager.linkTransactionToCustomer(clientId,  newTransaction);
										System.out.println("--------- New withdraw from savings account transaction completed --------");
									}
								}
								else if(transactionOpt==2) {
									System.out.println("Please select one of the options below");
									System.out.println("1) Deposit");
									System.out.println("2) Withdraw");
									int typeOption = sc.nextInt();
									if(typeOption==1) {
										customerManager.displayCustomerAccounts(clientId);
										System.out.println("Enter account id:");
										int actId = sc.nextInt();
										System.out.println("Enter ammount to deposit:");
										float ammount = sc.nextFloat();
										Account account = accountsManager.addFundsToAccount("Current Account",actId, ammount);
										Transaction newTransaction = transactionManager.newDepositTransaction(account, ammount);
										customerManager.linkTransactionToCustomer(clientId, newTransaction);
										System.out.println("--------- New deposit to current account transaction completed --------");
									}
									else if(typeOption==2) {
										customerManager.displayCustomerAccounts(clientId);
										System.out.println("Enter account id:");
										int actId = sc.nextInt();
										System.out.println("Enter ammount to withdraw:");
										float ammount = sc.nextFloat();
										Account account = accountsManager.withdrawFromAccount("Current Account",actId, ammount);
										Transaction newTransaction = transactionManager.newWithdrawTransaction(account, ammount);
										customerManager.linkTransactionToCustomer(clientId, newTransaction);
										System.out.println("--------- New withdraw from savings account transaction completed --------");
									}
								}else if(transactionOpt==3) {
									System.out.println("Please select one of the options below");
									System.out.println("1) Debt pay");
									int typeOption = sc.nextInt();
									if(typeOption==1) {
										System.out.println("Account id:");
										int accountId = sc.nextInt();
										System.out.println("Enter savings account id for monthly payment:");
										int accountIdPayment = sc.nextInt();
										float ammount = accountsManager.getMonthlyPaymentLoan(accountId);
										if(accountsManager.withdrawFromAccount("Savings Account", accountIdPayment, ammount) != null) {
											Account account = accountsManager.payDebtFromAccount(accountId, ammount);
											Transaction newTransaction = transactionManager.newDebtPayTransaction(account, ammount);
											customerManager.linkTransactionToCustomer(clientId, newTransaction);
											System.out.println("--------- Monthly payment of debt completed succesfully --------");
										}
										
									}
								}else if(transactionOpt==4) {
									System.out.println("Enter sender account id:");
									int senderAccountId = sc.nextInt();
									System.out.println("Enter receiver account id:");
									int receiverAccountId = sc.nextInt();
									System.out.println("Enter ammount to transfer");
									float ammount = sc.nextFloat();
									Account[] accounts = accountsManager.transferFundsToAccount("Savings Account", senderAccountId, receiverAccountId, ammount);
									Transaction newTransaction= transactionManager.newWireTransferTransaction(accounts[0], accounts[1], ammount);
									customerManager.linkTransactionToCustomer(clientId, newTransaction);
									System.out.println("--------- New wire transfer transaction completed --------");
								}
								
							}
							else if(serviceOption==3) {
								customerManager.displayCustomerAccounts(clientId);
								
							}
						
							
					}
						
					}else {
						System.out.println("Email or password not correct . . . ");
					}
					
			}
			System.out.println("------------------------------");
		}
	}
	
	
	public static void main(String[] args) {
		startService();
	}
}
