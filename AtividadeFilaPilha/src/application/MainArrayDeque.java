package application;

import java.util.ArrayDeque;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainArrayDeque {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		/*Só por questão de organização mesmo, coloco como padrão a entrada de valores em US, muito embora, no caso em questão
		não tenha entrada de números (double)*/
		
		Scanner sc = new Scanner(System.in);
		
		ArrayDeque<String> pilha = new ArrayDeque<String>();
		
		/*Ao verificar que o Stack ficou em desuso e que o ArrayDeque se tornou uma opção mais interessante, por permitir
		que desenvolvedor possa adicionar e retirar itens tanto no início quanto no final da "lista", apenas mudei a inerface
		fazendo a instanciação para o ArrayDeque, mantendo a estrutura da questão anterior feita no Stack*/
		
		int opcao;
		
		pilha.addFirst("Limpar casa");
		pilha.addFirst("Limpar areia dos gatos");
		pilha.addFirst("Lavar os banheiros");
		pilha.addFirst("Fazer a feira");
		pilha.addFirst("Lavar a louça");
		pilha.addFirst("Estender a roupa");
		pilha.addFirst("Aspirar o tapete");
		pilha.addLast("Aspirar o tapete");
		
		/*Fiz um teste e coloquei um "addLast" para verificar o funcionamento do ArrayDeque
		Aproveitei e já adicionei vários objetos para evitar ter que adicionar todos com o uso do menu 
		quando fosse fazer o teste */
		
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
				System.out.println(pilha.removeLast());
				System.out.println();
			
			}
		/* Já que a atividade consiste tão somente em adicionar tarefas e mostrar as próximas, não achei necessário criar
		uma classe para configurar os atributos das atividades. Preferi deixar tudo no main mesmo.*/
		}
		while (opcao != 3);
				System.out.println("Você saiu do sistema. Obrigado por utilizar nossos serviços. Volte sempre!\n");
			
		}
		
		catch (NoSuchElementException e) {
			System.out.println("A lista de tarefas está vazia.");
		}
		//Para testar o tratamento de exceções, acrescentei esse ponto para evitar dar erro ao "printar" a lista sem elementos
		
		sc.close();

	}

}