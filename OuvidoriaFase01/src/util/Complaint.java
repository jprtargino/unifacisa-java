package util;

import entities.Person;
import entities.enums.Type;

public class Complaint extends Manifestation{

	
	/* Construtor padrão que segue o modelo da Manifestação, mas, no toString(), segue informando as características de uma reclamação*/
	
	public Complaint(Person person, String description, Type type) {
		super(person, description, type);
		
	}

		@Override
		public String toString() {
			return "Protocolo nº " 
					+ id 
					+ " - Nome do reclamante: " 
					+ person.getName()
					+ " - Reclamação: "
					+ description;
		}
}