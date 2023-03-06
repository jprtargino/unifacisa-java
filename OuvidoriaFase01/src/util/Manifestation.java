package util;

import java.util.ArrayList;

import entities.Person;
import entities.enums.Type;

public abstract class Manifestation {

	protected Person person;
	protected String description;
	private static int contadorInt = 1;
	protected int id;
	protected Type type;

	public static ArrayList<Manifestation> listManifestations = new ArrayList<Manifestation>();

	public Manifestation() {

	}

	public Manifestation(Person person, String description, Type type) {
		this.person = person;
		this.description = description;
		this.setId(contadorInt++);
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
	
	public static void removeAllManifestations() {
		listManifestations.removeAll(listManifestations);
		System.out.println("Todas as manifestações foram removidas com sucesso.");
	}

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

	public static void showManifestationsForStudents(String email) {
		for (Manifestation m : listManifestations) {
			if (m.getPerson().getEmail().equals(email)) {
				System.out.println(m);
			}
		}
	}

	public static void searchManifestation(Person person, Integer protocol) {
		Manifestation m = listManifestations.stream().filter(x -> x.getId() == protocol).findFirst().orElse(null);
		if (m != null & listManifestations.size() != 0 && person.isAdmin() && listManifestations.contains(m)) {
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