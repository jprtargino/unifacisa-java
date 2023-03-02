package util;

import entities.Person;

public class Complaint extends Manifestation{

	
		public Complaint(Person person, String description) {
			super(person, description);
		}
		

		@SuppressWarnings("unlikely-arg-type")
		@Override
		public String toString() {
			return "Protocolo nº " 
					+ (listManifestations.indexOf(getDescription()) + 1) 
					+ " - Nome do reclamante: " 
					+ person.getName() 
					+ " - Reclamação: " 
					+ description;
		}
}
