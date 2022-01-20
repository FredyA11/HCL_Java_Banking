package com.banking.customers;

public class Customer {

	private long clientId;
	private String firstName;
	private String lastName;
	private String fullName;
	private String address;
	
	public Customer(long clientId,String firstName,String lastName,String fullName, String address) {
		this.clientId= clientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.address = address;
	}
	
	public long getClientId() {
		return clientId;
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
		return "Client: Id: "+this.clientId+","+ this.fullName + "," + " Adress:"+this.address+ " was created";
	}
	
	
}
