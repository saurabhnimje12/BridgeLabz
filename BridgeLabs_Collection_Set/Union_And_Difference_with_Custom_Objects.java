package BridgeLabs_Collection_Set;

import java.util.Arrays;
import java.util.TreeSet;

class Per implements Comparable<Per> {
	String name;
	int age;

	public Per(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Per p) {
		int nameComparison = this.name.compareTo(p.name);
		if (nameComparison != 0) {
			return nameComparison;
		}
		return Integer.compare(this.age, p.age);
	}
}

public class Union_And_Difference_with_Custom_Objects {

	public static TreeSet<Per> union(TreeSet<Per> setA, TreeSet<Per> setB) {
		TreeSet<Per> newTreeSet = new TreeSet<Per>(setA);
		newTreeSet.addAll(setB);
		return newTreeSet;
	}

	public static TreeSet<Per> difference(TreeSet<Per> setA, TreeSet<Per> setB) {
		TreeSet<Per> newTreeSet = new TreeSet<Per>(setA);
		newTreeSet.removeAll(setB);
		return newTreeSet;
	}

	public static void main(String[] args) {
		Per p1 = new Per("Alice", 30);
		Per p2 = new Per("Bob", 20);
		TreeSet<Per> setA = new TreeSet<Per>(Arrays.asList(p1, p2));

		Per p3 = new Per("Charlie", 35);
		TreeSet<Per> setB = new TreeSet<Per>(Arrays.asList(p2, p3));

		System.out.println("===== Union =====");
		TreeSet<Per> union = union(setA, setB);
		for (Per person : union) {
			System.out.println(person.name + " : " + person.age);
		}

		System.out.println("===== Difference =====");
		TreeSet<Per> difference = difference(setA, setB);
		for (Per person : difference) {
			System.out.println(person.name + " : " + person.age);
		}
	}
}
