package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
		
		private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		private String name;
		private Integer registrationNumber;
		private Date birthDate;
		
		
		public Student() {
		}
		
		public Student(String name, Integer registrationNumber, Date birthDate) {
			this.name = name;
			this.registrationNumber = registrationNumber;
			this.birthDate = birthDate;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getRegistrationNumber() {
			return registrationNumber;
		}

		public void setRegistrationNumber(Integer registrationNumber) {
			this.registrationNumber = registrationNumber;
		}

		public Date getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
		}
		
		public String toString() {
			return registrationNumber + " - " + name + " - " + sdf.format(birthDate);
		}
		
		
}
