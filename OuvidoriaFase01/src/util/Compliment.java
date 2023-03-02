package util;

import entities.Person;

public class Compliment extends Manifestation{

	
	public Compliment(Person person, String description) {
		super(person, description);
	}
	
	
	@Override
	public String toString() {
		return "Protocolo nº " + protocolNumber(null) + " - Nome do elogiante: " + person + " - Elogio: " + description;
	}
}
