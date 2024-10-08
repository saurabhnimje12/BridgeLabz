package BridgeLabs_Collection_Map;

import java.util.TreeMap;

public class Phone_Book {
	private TreeMap<String, Long> phoneBook;

	public Phone_Book() {
		phoneBook = new TreeMap<String, Long>();
	}

	public void addContact(String name, long num) {
		phoneBook.put(name, num);
		System.out.println("Contact Addded Successfully");
	}

	public void removeContact(String name) {
		if (phoneBook.containsKey(name)) {
			phoneBook.remove(name);
			System.out.println("Remove contact Successfully : " + name);
		} else {
			System.out.println("Contact NOT Found");
		}
	}

	public void searchContact(String name) {
		if (phoneBook.containsKey(name)) {
			System.out.println("Name - " + name + " : " + "Mobile No - " + phoneBook.get(name));
		} else {
			System.out.println("Contact NOT Found");
		}

	}

	public static void main(String[] args) {

		Phone_Book phoneBook = new Phone_Book();
		phoneBook.addContact("John", 12345);
		phoneBook.addContact("Smith", 98765);
		phoneBook.addContact("Roy", 34567);
		phoneBook.addContact("Charlie", 76543);

		phoneBook.removeContact("Roy");
		phoneBook.searchContact("Smith");
	}

}
