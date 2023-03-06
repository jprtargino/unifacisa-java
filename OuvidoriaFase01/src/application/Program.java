package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Admin;
import entities.Person;
import entities.Student;
import entities.enums.Type;
import util.Complaint;
import util.Compliment;
import util.Manifestation;
import util.Suggestion;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Person p1 = new Admin("João", "joao@maisunifacisa.com.br", "senha123");
		p1.addPerson(p1);
		Person p2 = new Student("w", "w", "w");
		p2.addPerson(p2);
		Person p3 = new Student("x", "x", "x");
		p3.addPerson(p3);
		Person p4 = new Admin("y", "y", "y");
		p4.addPerson(p4);
		
		
		Manifestation m1 = new Complaint(p2, "Falta papel higiênico no banheiro", Type.COMPLAINT);
		m1.addManifestation(m1);

		Manifestation m2 = new Suggestion(p2, "Adicionar nova cafeteira na cantina", Type.SUGGESTION);
		m2.addManifestation(m2);

		Manifestation m3 = new Compliment(p3, "A organização das salas é muito boa", Type.COMPLIMENT);
		m3.addManifestation(m3);

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
					Person p = new Admin(name, email, password);
					p.addPerson(p);
					System.out.println("Cadastro realizado com sucesso. ");
				} else {
					Person s = new Student(name, email, password);
					s.addPerson(s);
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
					Person p9 = p.verifyLogin(email2, password2);
					if (p9 != null) {
						System.out.println("Login efetuado com sucesso. Seja bem-vindo.");
						System.out.println();

						if (p9.admin == true) {
							do {
								System.out.println("MENU DE MANIFESTAÇÕES PARA ADMINISTRADOR");
								System.out.println("1 - LISTAR TODAS AS MANIFESTAÇÕES");
								System.out.println("2 - PESQUISAR UMA MANIFESTAÇÃO");
								System.out.println("3 - REMOVER MANIFESTAÇÃO");
								System.out.println("4 - SAIR");
								System.out.println("Selecione uma das opções desejadas:");
								optionMenu = sc.nextInt();

								switch (optionMenu) {

								case 1:
									System.out.println("Lista de manifestações");
									if (Manifestation.listManifestations.size() != 0) {
										Manifestation.showManifestations();
									} else {
										System.out.println("Não há manifestações na lista.");
									}
									break;

								case 2:
									System.out.println("Pesquisa de manifestações");
									System.out.print("Digite o número do protocolo: ");
									int protocol = sc.nextInt();
									Manifestation.searchManifestation(p, protocol);
									break;

								case 3:
									System.out.println("Remoção de manifestação");
									System.out.println("Você deseja remover apenas uma manifestação (1) ou todas (2)?" );
									int remove = sc.nextInt();
									if (remove == 1) {
										System.out.print("Digite o número do protocolo: ");
										int protocol2 = sc.nextInt();
										Manifestation.removeManifestation(protocol2);
									}
									else {
										Manifestation.removeAllManifestations();
									}
									
									break;
								}

							}

							while (optionMenu != 4);
						}

						else if ((p9.admin == false)) {
							do {
								System.out.println("MENU DE MANIFESTAÇÕES PARA ESTUDANTE");
								System.out.println("1 - CADASTRAR UMA MANIFESTAÇÃO");
								System.out.println("2 - LISTAR AS SUAS MANIFESTAÇÕES");
								System.out.println("3 - PESQUISAR UMA MANIFESTAÇÃO SUA");
								System.out.println("4 - SAIR");
								System.out.println("Selecione uma das opções desejadas:");
								optionMenu = sc.nextInt();

								switch (optionMenu) {

								case 1:
									System.out.println("Digite as informações da manifestação");
									System.out.println(
											"A sua manifestação é uma reclamação (1), sugestão (2) ou elogio (3)?");
									int optionManifestation = sc.nextInt();
									sc.nextLine();
									System.out.println("Informe o ocorrido: ");
									String description = sc.nextLine();

									if (optionManifestation == 1) {
										Manifestation manifestation = new Complaint(p9, description, Type.COMPLAINT);
										manifestation.addManifestation(manifestation);
										System.out.println("Reclamação cadastrada com sucesso. Número de protocolo: "
												+ manifestation.getId());
									} else if (optionManifestation == 2) {
										Manifestation manifestation = new Suggestion(p9, description, Type.SUGGESTION);
										manifestation.addManifestation(manifestation);
										System.out.println("Sugestão cadastrada com sucesso. Número de protocolo: "
												+ manifestation.getId());
									} else if (optionManifestation == 3) {
										Manifestation manifestation = new Compliment(p9, description, Type.COMPLIMENT);
										manifestation.addManifestation(manifestation);
										System.out.println(p9);
										System.out.println("Elogio cadastrado com sucesso. Número de protocolo: "
												+ manifestation.getId());
									}

									break;
								case 2:
									System.out.println("Lista de suas manifestações");
									Manifestation.showManifestationsForStudents(p9.getEmail());
									break;

								case 3:
									System.out.println("Pesquisa de suas manifestações");
									System.out.print("Digite o número do protocolo: ");
									int protocol = sc.nextInt();
									Manifestation.searchManifestation(p9, protocol);
									break;

								}

							}

							while (optionMenu != 4);
						}

					} else {
						System.out.println("As credenciais estão incorretas. Tente novamente.");
					}

				} while (p.verifyLogin(email2, password2) == null);
				break;

			}

		} while (option != 3);

		sc.close();

	}

}