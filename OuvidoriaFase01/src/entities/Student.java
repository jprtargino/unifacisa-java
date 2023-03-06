package entities;

public class Student extends Person {

	public Student(String name, String email, String password) {
		super(name, email, password);
		this.admin = false;
	}
	/* Construtor padrão que segue o modelo do Person*/
	
}