package application;

import java.util.ArrayDeque;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		ArrayDeque<String> pilha = new ArrayDeque<String>();
		
		int opcao;
		
		pilha.addFirst("Limpar casa");
		pilha.addFirst("Limpar areia dos gatos");
		pilha.addFirst("Lavar os banheiros");
		pilha.addFirst("Fazer a feira");
		pilha.addFirst("Lavar a louça");
		pilha.addFirst("Estender a roupa");
		pilha.addFirst("Aspirar o tapete");
		
		
		try {	
		do {
			System.out.println("Bem-vindo ao Sistema de Tarefas. Digite uma das opções desejadas:");
			System.out.println("1 - INSERIR UMA TAREFA");
			System.out.println("2 - VERIFICAR PRÓXIMA TAREFA A SER FEITA");
			System.out.println("3 - SAIR");
		
			opcao = sc.nextInt(); 
			
			if (opcao == 1) {
				sc.nextLine();
				System.out.println();
				System.out.println("INSERIR UMA ATIVIDADE:");
				System.out.print("Digite a atividade: ");
				String atividade = sc.nextLine();
				pilha.addFirst(atividade);
				System.out.println("Atividade incluída com sucesso");
				System.out.println();
			}
			
			else if (opcao == 2) {
				System.out.println();
				System.out.println("PRÓXIMA ATIVIDADE:"); 
				System.out.println(pilha.removeFirst());
				System.out.println();
			
			}
		
		}
		while (opcao != 3);
				System.out.println("Você saiu do sistema. Obrigado por utilizar nossos serviços. Volte sempre!\n");
			
		}
		
		catch (NoSuchElementException e) {
			System.out.println("A lista de tarefas está vazia.");
		}
		
		sc.close();

	}

}
