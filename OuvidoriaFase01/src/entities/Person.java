package entities;

import java.util.ArrayList;

public class Person {

	private String name;
	private String email;
	private String password;
	public boolean admin;
	
	
	private static ArrayList<Person> listPerson = new ArrayList<Person>();
	
	/* Criei uma lista própria em Person para receber todos os usuários. Isso permitirá que o Admin possa ver todos os cadastrados*/
	
	public Person() {
		
	}

	
	
	public Person(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.admin = false;
	}
	
	/* Criei um construtora de Person com dois argumentos (email e senha) para utilizar na etapa de verificar o Login*/
	/* A ideia inicial seria utilizar o Person como uma classe abstrata, mas como não consegui pensar em instanciar temporariamente em outro objeto
	 * para verificar o Login, tive que tirar o "abstrato" e permitir a instaciação de Person apenas para esse objetivo específico */
	
	public Person(String email, String password) {
		this.email = email;
		this.password = password;
		this.admin = false;
	
	}

	/* Método para atribuir poderes de admin. Dessa forma, não será preciso instanciar como Admin toda vez*/
	
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
	
	/* Essas funções de remover e mostrar pessoa poderão ser utilizadas numa versão futura, em que o Admin, além de poder remover manifestações,
	 também poderá retirar os usuários (estudantes) e mostrar quem está cadastrado	 */
	
	public void removePerson(Person person) {
		listPerson.remove(person);
	}
	
	public static void showPerson(Person person) {
		for (Person p: listPerson) {
		System.out.println(p);
		}
	}
	
	/* Para verificar o login e validar a entrada do usuário, coloquei como argumentos de entrada o email e a senha*/
	
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