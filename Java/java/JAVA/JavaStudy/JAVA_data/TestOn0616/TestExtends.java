package TestOn0616;

public class TestExtends {

	public static void main(String[] args) {
		Employee e = new Employee("123");
		System.out.print(e.empID);
	}

}
class Person{
	String name = "No name";
	Person(){};
	public Person(String nm) {
		name = nm;
	}
}
class Employee extends Person{
	String empID = "0000";
	public Employee(String id) {
		empID = id;
	}
}
