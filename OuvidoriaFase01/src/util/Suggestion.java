package util;

import entities.Person;

public class Suggestion extends Manifestation{

	
	public Suggestion(Person person, String description) {
		super(person, description);
	}
	
	@Override
	public String toString() {
		return "Protocolo nº " + protocolNumber(null) + " - Nome do sugeridor: " + person + " - Sugestão: " + description;
	}
}
