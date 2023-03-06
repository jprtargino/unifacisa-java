package util;

import entities.Person;
import entities.enums.Type;

public class Suggestion extends Manifestation{

	
	public Suggestion(Person person, String description, Type type) {
		super(person, description, type);
		
	}

		@Override
		public String toString() {
			return "Protocolo nº " 
					+ id 
					+ " - Nome do sugeridor: " 
					+ person.getName() 
					+ " - Sugestão: "
					+ description;
		}
	
}

