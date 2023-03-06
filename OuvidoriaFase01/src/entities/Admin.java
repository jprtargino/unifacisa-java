package entities;


public class Admin extends Person{

	public Admin(String name, String email, String password) {
		super(name, email, password);
		isAdmin();
	}
	/* Achei muito interessante a criação de método para definir se um usuário é admin ou não, pois desse modo, posso, numa edição futura do programa
	 atribuir configuração de Admin para um usuário já criado */
	
	
	
}