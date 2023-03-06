package util;

import java.util.ArrayList;

import entities.Person;
import entities.enums.Type;

public abstract class Manifestation {
	/*Coloquei como abstrato para evitar a instanciação, o objetivo é que toda manifestação seja adicionada pela instanciação nas classes filhas*/
	
	protected Person person;
	protected String description;
	private static int counterInt = 1;
	protected int id;
	protected Type type;

	/*Na superclasse de Manifestações, criei o atributo Person, descrição e o tipo. Para fazer com que o número de protocolo não seja de responsabilidade do
	 usuário, coloquei uma contagem automática, iniciando-se a partir do número 1 (por isso o contador estático)*/
	
	public static ArrayList<Manifestation> listManifestations = new ArrayList<Manifestation>();

	/*Também achei interessante deixar o arraylist de manifestação dentro da própria classe de manifestação, para evitar "floodar" o Main com código que não
	 é pertinente*/
	
	public Manifestation() {

	}

	public Manifestation(Person person, String description, Type type) {
		this.person = person;
		this.description = description;
		this.setId(counterInt++);
		this.setType(type);
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addManifestation(Manifestation manifestation) {
		listManifestations.add(manifestation);
	}

	/*Como esse método remover uma manifestação ou todas só é acessável pelo Admin, não precisei fazer diferenciação ou criar alguma barreira aqui*/
	
	public static void removeManifestation(Integer id) {
		Manifestation m = listManifestations.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (listManifestations.contains(m)) {
			listManifestations.remove(m);
			System.out.println("Manifestação removida com sucesso. ");
		}
		else {
			System.out.println("Protocolado não encontrado.");
		}
	}
	
	/* Como no enunciado da tarefa pedir que o Admin tivesse poder para remover todas as manifestações, incrementei tal possibilidade pelo método seguinte*/
	
	public static void removeAllManifestations() {
		listManifestations.removeAll(listManifestations);
		System.out.println("Todas as manifestações foram removidas com sucesso.");
	}
	/* Esse método é exclusivo para o Admin. Para os estudantes, há o método showManifestationsForStudents mais abaixo*/
	
	public static void showManifestations() {
		for (Manifestation m : listManifestations) {
			System.out.println(m);
		}
	}
	

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/* Para que o estudante apenas veja as manifestações dele próprio, criei o critério de verificação pelo email*/
	
	public static void showManifestationsForStudents(String email) {
		for (Manifestation m : listManifestations) {
			if (m.getPerson().getEmail().equals(email)) {
				System.out.println(m);
			}
		}
	}
	/* O admin pode procurar qualquer manifestação, mas o estudante só pode procurar as manifestações que sejam dele próprio*/
	
	public static void searchManifestation(Person person, Integer protocol) {
		Manifestation m = listManifestations.stream().filter(x -> x.getId() == protocol).findFirst().orElse(null);
		if (m != null && listManifestations.size() != 0 && person.isAdmin() && listManifestations.contains(m)) {
			System.out.println(m);
		} else if (m != null && m.getPerson().equals(person)) {
			System.out.println(m);
		}
		else if (listManifestations.size() == 0) {
			System.out.println("A lista está vazia.");
		}
		else {
			System.out.println("Protocolo não encontrado.");
		}

		}

}