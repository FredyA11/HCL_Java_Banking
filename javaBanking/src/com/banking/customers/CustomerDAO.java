package com.banking.customers;

import java.util.ArrayList;

import com.banking.accounts.Account;
import com.banking.transactions.Transaction;

public class CustomerDAO {

	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public void linkAccountToCustomer(long clientId,Account account) {
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getClientId()==clientId) {
				customers.get(i).getAccounts().add(account);
			}
		}
	}
	
	public void linkTransactionToCustomer(long clientId,Transaction transaction) {
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getClientId()==clientId) {
				customers.get(i).getTransactions().add(transaction);
			}
		}
	}
	
	public void addCustomer(String name,String lastName,String address,String email,String phone,String password) {
		int customerId = customers.size();
		String fullName = name+ " "+lastName;
		Customer newCustomer= new Customer(customerId,name,lastName,fullName,address,email,phone,password);
		customers.add(newCustomer);
	}
	
	public void deleteCustomer(long clientId) {
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getClientId() == clientId) {
				customers.remove(i);
			}
		}
	}
	
	public boolean verifyLogin(String email,String password) {
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getEmail().equals(email)) {
				if(customers.get(i).getPassword().equals(password)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public long searchClientId(String email) {
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getEmail().equals(email)) {
				return customers.get(i).getClientId();
			}
		}
		return 0;
	}
	
	public void displayCustomerAccounts(long clientId) {
		System.out.println("Current customer's accounts:");
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getClientId() == clientId) {
				for(Account account : customers.get(i).getAccounts()) {
					System.out.println(account.toString());
				}
			}
		}
		System.out.println("---------------------------");
		
	}
}
