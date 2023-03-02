package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Admin;
import entities.Person;
import entities.Student;
import util.Complaint;
import util.Compliment;
import util.Manifestation;
import util.Suggestion;

public class Program {

	

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Admin admin = new Admin("João Paulo", "joao.targino@maisunifacisa.com.br", "senha123");
		admin.addPerson(admin);
		Student stu = new Student("Paulo", "paulo@hotmail.com", "senha456");
		Student stu2 = new Student("x", "x", "x");
		stu.addPerson(stu);
		stu.addPerson(stu2);
		
		int option;
		
		
		do {
			System.out.println("Bem-vindo ao Sistema de Ouvidoria");
			System.out.println("1 - CADASTRAR");
			System.out.println("2 - LOGIN");
			System.out.println("3 - SAIR");
			option = sc.nextInt();
			sc.nextLine();
		
			switch (option) {
			
			case 1:
				System.out.println("Insira as informações para efetuar seu cadatro:");
				System.out.print("Nome: ");
				String name = sc.nextLine();
				System.out.print("E-mail: ");
				String email = sc.nextLine();
				System.out.print("Senha: ");
				String password = sc.nextLine();
				System.out.print("Você é funcionário? (y/n)");
				char answer = sc.next().charAt(0);
					if (answer == 'y') {
						Admin admin2 = new Admin(name, email, password);
						admin2.addPerson(admin2);
						System.out.println("Cadastro realizado com sucesso. ");
					}
					else {
						Student student = new Student(name, email, password);
						student.addPerson(student);
						System.out.println("Cadastro realizado com sucesso. ");
					}
				break;
				
			case 2:
				Person p;
				String email2;
				String password2;
				int optionMenu;
				do {
					System.out.println("Insira as informações para efetuar seu login:");
					System.out.print("E-mail: ");
					email2 = sc.nextLine();
					System.out.print("Senha: ");
					password2 = sc.nextLine();
					p = new Person(email2, password2);
					if (p.verifyLogin(email2, password2) == true) {
					System.out.println("Login efetuado com sucesso. Seja bem-vindo.");
					System.out.println();
					
					if (p.getClass().isInstance(admin)) {
						do {
							System.out.println("MENU DE MANIFESTAÇÕES");
							System.out.println("1 - LISTAR TODAS AS MANIFESTAÇÕES");
							System.out.println("2 - PESQUISAR UMA MANIFESTAÇÃO");
							System.out.println("3 - REMOVER UMA MANIFESTAÇÃO");
							System.out.println("4 - SAIR");
							System.out.println("Selecione uma das opções desejadas:");
							optionMenu = sc.nextInt();
							
							switch (optionMenu) {
							
							case 1:
								System.out.println("Lista de manifestações");
								if (Manifestation.listManifestations.size() != 0) {
									Manifestation.showManifestations();
								}
								else {
									System.out.println("Não há manifestações na lista.");
								}
								
								break;
								
							case 2:
								System.out.println("Pesquisa de manifestações");
								System.out.print("Digite o número do protocolo: ");
								int protocol = sc.nextInt();
								Manifestation.searchManifestation(p, protocol);
								if (Manifestation.searchManifestation(p, protocol) == null) {
									System.out.println("Protocolo não encontrado.");
								}
								break;
								
							case 3:
								System.out.println("Remoção de manifestação");
								System.out.print("Digite o número do protocolo: ");
								int protocol2 = sc.nextInt();
								Manifestation m = Manifestation.searchManifestation(p, protocol2);
								m.removeManifestation(m);
								break;
							}
							
						}
						
						while (optionMenu != 4);
					}
					
					
					else if (!p.getClass().isInstance(admin)) {
						do {
							System.out.println("MENU DE MANIFESTAÇÕES");
							System.out.println("1 - CADASTRAR UMA MANIFESTAÇÃO");
							System.out.println("2 - LISTAR AS SUAS MANIFESTAÇÕES");
							System.out.println("3 - PESQUISAR UMA MANIFESTAÇÃO SUA");
							System.out.println("4 - SAIR");
							System.out.println("Selecione uma das opções desejadas:");
							optionMenu = sc.nextInt();
							
							switch (optionMenu) {
							
							case 1:
								System.out.println("Digite as informações da manifestação");
								System.out.println("A sua manifestação é uma reclamação (1), sugestão (2) ou elogio (3)?");
								int optionManifestation = sc.nextInt();
								sc.nextLine();
								System.out.println("Informe o ocorrido: ");
								String description = sc.nextLine();
								
								if (optionManifestation == 1) {
									Complaint complaint = new Complaint(p, description);
									complaint.addManifestation(complaint);
									System.out.println("Reclamação cadastrada com sucesso. Número de protocolo: " + complaint.protocolNumber(complaint));
								}
								else if (optionManifestation == 2) {
									Suggestion suggestion = new Suggestion(p, description);
									suggestion.addManifestation(suggestion);
									System.out.println("Sugestão cadastrada com sucesso. Número de protocolo: " + suggestion.protocolNumber(suggestion));
								}
								else if (optionManifestation == 3) {
									Compliment compliment = new Compliment(p, description);
									compliment.addManifestation(compliment);
									System.out.println("Reclamação cadastrada com sucesso. Número de protocolo: " + compliment.protocolNumber(compliment));
								}
								
								break;
							case 2:
								System.out.println("Lista de suas manifestações");
								Manifestation.showManifestationsForStudents(p.getEmail());
								break;
								
							case 3:
								System.out.println("Pesquisa de suas manifestações");
								System.out.print("Digite o número do protocolo: ");
								int protocol = sc.nextInt();
								Manifestation.searchManifestation(p, protocol);
								break;
								

							}
							
						}
						
						while (optionMenu != 4);
					}
					
					
					
				}
					else {
					System.out.println("As credenciais estão incorretas. Tente novamente.");
				}
				
				}
				while (p.verifyLogin(email2, password2) == false);
				break;
			
		}
		
		
		}
		while (option !=3);
		
		
		
		
		sc.close();

	
		}

}
