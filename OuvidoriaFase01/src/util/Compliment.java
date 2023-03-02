package util;

import entities.Person;

public class Compliment extends Manifestation{

	
	public Compliment(Person person, String description) {
		super(person, description);
	}
	
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public String toString() {
		return "Protocolo nº " 
				+ listManifestations.indexOf(getDescription()) + 1 
				+ " - Nome do elogiante: " 
				+ person.getName() 
				+ " - Elogio: " 
				+ description;
	}
}
