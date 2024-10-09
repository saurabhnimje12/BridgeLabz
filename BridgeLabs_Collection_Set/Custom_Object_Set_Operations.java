package BridgeLabs_Collection_Set;

import java.util.HashSet;

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}

public class Custom_Object_Set_Operations {

	public static void main(String[] args) {
		Person p1 = new Person("Alice", 30);
		Person p2 = new Person("Bob", 25);
		Person p3 = new Person("Alice", 30);

		HashSet<Person> set = new HashSet<Person>();
		set.add(p1);
		set.add(p2);

		for (Person person : set) {
			if (set.contains(person)) {
				System.out.println(person.name + " , " + person.age + " is present in SET");
			}
		}
	}
}
