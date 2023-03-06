package application;

	
	import java.util.Locale;
	import java.util.PriorityQueue;
	import java.util.Scanner;

	import entities.Client;
	import entities.ClientComparator;

	public class MainPriorityQueue {

		public static void main(String[] args) {
			
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			
			PriorityQueue<Client> list = new PriorityQueue<Client>(2, new ClientComparator());
			
			list.add(new Client("João", 2));
			list.add(new Client("José", 2));
			list.add(new Client("Joaquim", 2));
			list.add(new Client("Pedro", 1));
			list.add(new Client("Júnior", 2));
			list.add(new Client("Jânio", 2));
			list.add(new Client("Genivaldo", 2));
			list.add(new Client("Josias", 1));
			list.add(new Client("Josué", 1));
			list.add(new Client("Gilvan", 1));
			
			/*
			Já adicionei várias opções na lista para evitar ter que adicionar pelo menu e testar a saída (3 prioritárias para 1 normal)
			 */
			
			int opcao;
			
			do {
				System.out.println("Bem-vindo ao Sistema de Senha. Digite uma das opções desejadas:");
				System.out.println("1 - INSERIR UMA SENHA");
				System.out.println("2 - CHAMAR PRÓXIMA SENHA");
				System.out.println("3 - SAIR");
				
			//Coloquei apenas três opções de interações já que o objetivo é apenas determinar prioritário ou normal e chamar de acordo
				
				opcao = sc.nextInt(); 
				
				if (opcao == 1) {
					sc.nextLine();
					System.out.println();
					System.out.println("INSERIR UMA SENHA:");
					System.out.print("O atendimento é normal (1) ou preferencial (2)? Digite 1 ou 2: ");
					Integer priority = sc.nextInt();
					sc.nextLine();
					System.out.print("Digite o nome do cliente: ");
					String name = sc.nextLine();
					Client client = new Client (name, priority);
					list.add(client);
					System.out.println("Senha registrada com sucesso");
					System.out.println(client);
					System.out.println();
					
				}
				
				else if (opcao == 2) {
					System.out.println();
					System.out.println("SENHA CHAMADA:");
					
					do {
						for (int i = 0; i < 3; i++) {					
							if (list.size() > 0) {
							System.out.println(list.poll());
							System.out.println("Digite qualquer valor para chamar a próxima senha: ");
							sc.next();
							
							//Como é para sair a senha prioritária, utilizei o comando .poll() normal
							
							 }
						}
						
						Client cli = list.stream().filter(x-> x.getPriority() == 1).findFirst().orElse(null);
						if (list.contains(cli)) {
							System.out.println(cli);
							list.remove(cli);
							System.out.println("Digite qualquer valor para chamar a próxima senha: ");
							sc.next();}
						
						/*Nesse caso, criei um stream para vasculhar a lista e, ao encontrar uma senha não prioritária, salvar ela numa variável
						e, em seguida, imprimir ela e, por fim, deletá-la da lista*/
						
						}
					while (list.size() > 0);
						
					if (list.size() == 0) {
						System.out.println();
						System.out.println("Não há mais senhas pendentes de atendimento. ");
						}
					
					//Assim que a lista atingir o valor de 0, deverá ser mostrada no Console que não há mais senhas
			
			}
			}
			while (opcao != 3);
				System.out.println("Você saiu do sistema. Obrigado por utilizar nossos serviços. Volte sempre!\n");
			

			sc.close();

			


	}
	}

