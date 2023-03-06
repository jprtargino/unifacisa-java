package entities;

import java.util.ArrayList;

public class Person {

	private String name;
	private String email;
	private String password;
	public boolean admin;
	
	
	private static ArrayList<Person> listPerson = new ArrayList<Person>();
	
	public Person() {
		
	}


	public Person(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.admin = false;
	}
	
	public Person(String email, String password) {
		this.email = email;
		this.password = password;
		this.admin = false;
	
	}

	public Boolean isAdmin() {
		return this.admin = true;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public void addPerson(Person person) {
		listPerson.add(person);
	}
	
	public boolean searchPerson(Person xerox) {
		if (listPerson.contains(xerox)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public void removePerson(Person person) {
		listPerson.remove(person);
	}
	
	public static void showPerson(Person person) {
		for (Person p: listPerson) {
		System.out.println(p);
		}
	}
	
	public Person verifyLogin(String email, String password) {
		Person y = listPerson.stream().filter(x -> x.getEmail().equals(email) && x.getPassword().equals(password)).findFirst().orElse(null);
		if (y != null) {
			return y;
		}
		else {
			return null;
		}
		
	}
	
	@Override
	public String toString() {
		return "Nome: " + name + " - E-mail: " + email;
	}
	
	
	
	
	
}