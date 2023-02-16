package application;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;

import entities.Contact;

public class Exercicio01 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Queue <Contact> list = new LinkedList<Contact>();
		
		int opcao;
		
		do {
			System.out.println("Bem-vindo ao Sistema do CALL CENTER. Digite uma das opções desejadas:");
			System.out.println("1 - INSERIR CONTATO");
			System.out.println("2 - VER PRÓXIMO CONTATO");
			System.out.println("3 - SAIR");
		
			opcao = sc.nextInt();
			
			if (opcao == 1) {
				sc.nextLine();
				System.out.println("INSERIR CONTATO");
				System.out.print("Digite o nome: ");
				String name = sc.nextLine();
				System.out.print("Digite o número de contato: ");
				String phoneNumber = sc.nextLine();
				Contact contact = new Contact(name, phoneNumber);
				list.add(contact);
				System.out.println("Contato cadastrado com sucesso!");
				System.out.println(contact);
				System.out.println();
			}
			
			else if (opcao == 2) {
				if (list.size() != 0) {
					System.out.println(list.poll());
					System.out.println();
				}
				
				else {
					System.out.println("Lista vazia.");
					System.out.println();
					
				}
			}
			
			else if (opcao != 1 && opcao != 2 && opcao != 3) {
				System.out.println("Opção inválida. Tente novamente!\n");
			}
		}
		
		while (opcao != 3);
		System.out.println("Você saiu do sistema. Obrigado por utilizar nossos serviços. Volte sempre!\n");
		
		
		
		sc.close();

	}

}
