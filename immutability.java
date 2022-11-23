//cannot be changed incase it has been instantiated 
//Most strings are immutable
//Example 1 immutable String
public class Main {

    public static void main(String[] args) {
        String testString1 = "website";
        System.out.println("testString1: " + testString1);
        String testString2 = testString1 + ".com";
        System.out.println("testString2: " + testString2);
        System.out.println("testString1: " + testString1);
    }
}
/*Output

testString1: website
testString2: website.com
testString1: website */

//Example 2 immutable class
final class Student{
	//declare all properties final.
	final String rollNo;

	public Student(String rollNo){
		this.rollNo = rollNo;
	}

	//only create getter method.
	public String getRollNo() {
		return rollNo;
	}
}

public class ImmutableClassExample {
	public static void main(String args[]){
		//creating Student object.
		Student obj = new Student("MCA/07/06");

		System.out.println(obj.getRollNo());
	}
}
/*Output:

MCA/07/06 */

//Immutable objects
public class MainTest {

    public static void main(String[] args) {
        Address address = new Address();
        address.setAddressLine("Address line 1");
        address.setCity("Test City");
        address.setState("Test State");
        address.setPinCode("123456");

        ImmutableEmployee immutableEmployee = new ImmutableEmployee("Jai", 10, address);
        System.out.println(immutableEmployee.getName() +
        		"'s city before modification: " + immutableEmployee.getAddress().getCity());
        address.setCity("Modified City");
        System.out.println(immutableEmployee.getName() +
        		"'s city after modification: " + immutableEmployee.getAddress().getCity());
    }
}
Output:

Jai's city before modification: Test City
Jai's city after modification: Modified City
