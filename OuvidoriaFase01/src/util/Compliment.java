package util;

import entities.Person;
import entities.enums.Type;

public class Compliment extends Manifestation{

	
	public Compliment(Person person, String description, Type type) {
		super(person, description, type);
		
	}

		@Override
		public String toString() {
			return "Protocolo nº " 
					+ id 
					+ " - Nome do elogiador: " 
					+ person.getName() 
					+ " - Elogio: "
					+ description;
		}
}