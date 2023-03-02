package util;

import entities.Person;

public class Suggestion extends Manifestation{

	
	public Suggestion(Person person, String description) {
		super(person, description);
	}
	
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public String toString() {
		return "Protocolo nº " 
				+ listManifestations.indexOf(getDescription()) + 1 
				+ " - Nome do sugeridor: " 
				+ person.getName() 
				+ " - Sugestão: " 
				+ description;
	}
	
}
