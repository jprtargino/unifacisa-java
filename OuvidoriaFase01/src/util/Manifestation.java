package util;

import java.util.ArrayList;

import entities.Person;

public abstract class Manifestation {

	protected Person person;
	protected String description;
	
	public static ArrayList<Manifestation> listManifestations = new ArrayList<Manifestation>();
	
	public Manifestation () {
		
	}
	
	
	public Manifestation(Person person, String description) {
		this.person = person;
		this.description = description;
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
		
	public void removeManifestation(Manifestation manifestation) {
		if (person.isAdmin()) {
			listManifestations.remove(manifestation);
		}
	}
	
	public int protocolNumber(Manifestation manifestation) {
		return (listManifestations.indexOf(manifestation) + 1);
	}
	
	public static void showManifestations() {
		for (Manifestation m: listManifestations) {
			System.out.println(m);
		}
	}
	
	public static void showManifestationsForStudents(String email) {
		Manifestation z = listManifestations.stream().filter(x-> x.getPerson().getEmail() == email).findFirst().orElse(null);
		if (listManifestations.contains(z)) {
			for (Manifestation z1: listManifestations) {
				System.out.println(z1);
			}
		}
	}
	
	public static Manifestation searchManifestation(Person person, Integer protocol) {
		if (listManifestations.size() != 0) {
		Manifestation m = listManifestations.stream().filter(x-> x.protocolNumber(x) == protocol).findFirst().orElse(null);
		if (person.isAdmin() && listManifestations.contains(m)) {
			return m;
		}
			else if (m.getPerson().equals(person)) {
				return m;
			}
		}
		return null;
		
	}
	


	public String toString() {
		return "Protocolo nº " + listManifestations.indexOf(getDescription()) + " - Nome do manifestante: " + person + " - Manifestação: " + description;
	}
	
	
}
