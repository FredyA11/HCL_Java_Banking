package com.banking.bank;

public class Bank {

	private String name;
	private String address;
	private String bankCode;
	
	public Bank(String name,String address,String bankCode) {
		this.name=name;
		this.address=address;
		this.bankCode=bankCode;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	
	
}
