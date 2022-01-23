package com.banking.customers;

import java.util.ArrayList;

import com.banking.accounts.Account;
import com.banking.transactions.Transaction;

public class Customer {

	private long clientId;
	private String firstName;
	private String lastName;
	private String fullName;
	private String address;
	private String email;
	private String phone;
	private String password;
	private ArrayList<Account> accounts;
	private ArrayList<Transaction> transactions;
	
	public Customer(long clientId,String firstName,String lastName,String fullName, String address,String email,String phone,String password) {
		this.clientId= clientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.address = address;
		this.email= email;
		this.phone=phone;
		this.password=password;
		this.accounts = new ArrayList<Account>();
		this.transactions = new ArrayList<Transaction>();
	}
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getClientId() {
		return this.clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		return "Client: Id: "+this.clientId+","+ this.fullName + "," + " Adress:"+this.address;
	}
	
	
}
