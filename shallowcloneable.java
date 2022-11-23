package com.w3spoint;


class Address implements Cloneable{
	private String city;
	private String pinCode;

	public Address(String city, String pinCode) {
           this.city = city;
           this.pinCode = pinCode;
        }

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}
}

class Customer implements Cloneable {
         private String name;
         private Address address;
         public Customer(String name, Address address) {
            this.name = name;
            this.address = address;
        }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}
}

public class Test {
	public static void main(String args[]){
		try{
			Customer originalObj = new Customer("Vivek", new Address("Gurgaon", "122001"));
			Customer clonedObj=(Customer)originalObj.clone();
			System.out.println("Original Object properties: ");
			System.out.println(originalObj.getName());
			System.out.println(originalObj.getAddress().getCity());
			System.out.println(originalObj.getAddress().getPinCode());
			System.out.println("Cloned Object properties: ");
			System.out.println(clonedObj.getName());
			System.out.println(clonedObj.getAddress().getCity());
			System.out.println(clonedObj.getAddress().getPinCode());

			//Change in cloned object
			clonedObj.getAddress().setPinCode("122002");

			//Changes will reflect in original object also
			System.out.println("Original Object pincode after changes in cloned object: ");
			System.out.println(originalObj.getAddress().getPinCode());

		}catch(CloneNotSupportedException c){

		}
	}
}
/*
Output
Original Object properties:
Vivek
Gurgaon
122001
Cloned Object properties:
Vivek
Gurgaon
122001
Original Object pincode after changes in cloned object:
122002 */

2

class Customer implements Cloneable {
         private String name;
         private Address address;
         public Customer(String name, Address address) {
            this.name = name;
            this.address = address;
        }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}
}
