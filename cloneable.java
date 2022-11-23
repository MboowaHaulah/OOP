import java.util.ArrayList;

class Example1 {
 int d, g;
}

//cloning
class Example2 implements Cloneable {
 int k, s;

 Example1 ex1 = new Example1();

 public Object clone() throws CloneNotSupportedException {
  return super.clone();
 }
}

public class CloneProgram {
 public static void main(String args[]) throws CloneNotSupportedException {

  Example2 ex2 = new Example2();

  ex2.k = 1;
  ex2.s = 2;
  ex2.ex1.d = 3;
  ex2.ex1.g = 4;

  Example2 ex22 = (Example2) ex2.clone();
  ex22.k = 500;
  ex22.ex1.d = 800;

  System.out.println(ex2.k + " " + ex2.s + " " +
   ex2.ex1.d + " " + ex2.ex1.g);

  System.out.println(ex22.k + " " + ex22.s + " " +
   ex22.ex1.d + " " + ex22.ex1.g);
 }

}

//deep cloning
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
		Customer customer = (Customer) super.clone();
		customer.address = (Address)this.address.clone();
		return customer;
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

			//Changes will not reflect in original object also
			System.out.println("Original Object pincode after changes in cloned object: ");
			System.out.println(originalObj.getAddress().getPinCode());

		}catch(CloneNotSupportedException c){

		}
	}
}
/*Output
Original Object properties:
Vivek
Gurgaon
122001
Cloned Object properties:
Vivek
Gurgaon
122001
Original Object pincode after changes in cloned object:
122001
clone() method of the object class support shallow copy of the object.
In case of deep copy we have to override the clone() method of the object class
 and we also need to ensure that all the member class also implement the Cloneable interface.
There is no difference between shallow and deep copy in java if only
primitive type fields or Immutable objects are there as fields in the original object.
*/
