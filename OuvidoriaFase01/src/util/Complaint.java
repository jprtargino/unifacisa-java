package util;

import entities.Person;

public class Complaint extends Manifestation{

	
		public Complaint(Person person, String description) {
			super(person, description);
		}
		

@Override
public String toString() {
	return "Protocolo nº " + protocolNumber(null) + " - Nome do reclamante: " + person + " - Reclamação: " + description;
}
}
