package entities;

import java.util.ArrayList;

public class Person {

	private String name;
	private String email;
	private String password;
	protected boolean admin;
	
	
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
	
	}

	public boolean isAdmin() {
		return admin = true;
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
	
	public void removePerson(Person person) {
		listPerson.remove(person);
	}
	
	public static void showPerson(Person person) {
		for (Person p: listPerson) {
		System.out.println(p);
		}
	}
	
	public boolean verifyLogin(String email, String password) {
		for (Person p: listPerson) {
			if (p.getEmail().equals(email) && getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Nome: " + name + " - E-mail: " + email;
	}
	
	
	
	
	
}
