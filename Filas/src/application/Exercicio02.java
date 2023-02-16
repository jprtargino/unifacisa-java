package application;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;
import entities.Pacient;

public class Exercicio02 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Queue <Pacient> list = new LinkedList<Pacient>();
		
		int opcao;
		
		do {
			System.out.println("Bem-vindo ao Sistema de Atendimento. Digite uma das opções desejadas:");
			System.out.println("1 - INSERIR UM PACIENTE");
			System.out.println("2 - CHAMAR PRÓXIMO PACIENTE");
			System.out.println("3 - VERIFICAR SE HÁ PACIENTES NA LISTA");
			System.out.println("4 - VERIFICAR PRÓXIMO PACIENTE PARA SER ATENDIDO");
			System.out.println("5 - INFORMAR QUANTOS PACIENTES ESTÃO NA FILA DE ESPERA");
			System.out.println("6 - SAIR");
		
			opcao = sc.nextInt();
			
			if (opcao == 1) {
				sc.nextLine();
				System.out.println();
				System.out.println("INSERIR PACIENTE NA LISTA DE ESPERA:");
				System.out.print("Digite o nome: ");
				String name = sc.nextLine();
				list.add(new Pacient(name));
				System.out.println("Paciente incluído na lista de espera!");
				System.out.println();
			}
			
			else if (opcao == 2) {
				System.out.println();
				System.out.println("PACIENTE CHAMADO:");
				System.out.println(list.poll());
				System.out.println();
			}
			
			else if (opcao == 3) {
				if (list.size() != 0) {
					System.out.println();
					System.out.println("Há paciente na fila de espera.");
					System.out.println();
				}
				
				else {
					System.out.println();
					System.out.println("Lista vazia.");
					System.out.println(); 
				}
			}
				
			
			else if (opcao == 4) {
				System.out.println();
				System.out.println("PRÓXIMO PACIENTE A SER CHAMADO:");
				if (list.size() != 0) {
					System.out.println();
					System.out.println(list.peek());
					System.out.println();
				}
				
				else {
					System.out.println();
					System.out.println("Lista vazia.");
					System.out.println(); 
				
				}
			}
			
			else if (opcao == 5) {
				System.out.println();
				System.out.println("NÚMERO DE PACIENTES NA FILA DE ESPERA: " + list.size());
				System.out.println();
			}
			
			else if (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao !=5  && opcao != 6) {
				System.out.println("Opção inválida. Tente novamente!\n");
			}
		}
		
		while (opcao != 6);
		System.out.println("Você saiu do sistema. Obrigado por utilizar nossos serviços. Volte sempre!\n");
		
		
		
		sc.close();

	}

}
