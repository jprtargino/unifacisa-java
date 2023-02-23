package application;

import java.util.EmptyStackException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Stack<String> pilha = new Stack<String>();
		
		int opcao;
		
		pilha.push("Limpar casa");
		pilha.push("Limpar areia dos gatos");
		pilha.push("Lavar os banheiros");
		pilha.push("Fazer a feira");
		pilha.push("Lavar a louça");
		pilha.push("Estender a roupa");
		pilha.push("Aspirar o tapete");
		
		
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
				pilha.push(atividade);
				System.out.println("Atividade incluída com sucesso");
				System.out.println();
			}
			
			else if (opcao == 2) {
				System.out.println();
				System.out.println("PRÓXIMA ATIVIDADE:"); 
				System.out.println(pilha.pop());
				System.out.println();
			
			}
		
		}
		while (opcao != 3);
				System.out.println("Você saiu do sistema. Obrigado por utilizar nossos serviços. Volte sempre!\n");
			
		}
		
		catch (EmptyStackException e) {
			System.out.println("A lista de tarefas está vazia.");
		}
		
		sc.close();
	

}
}
