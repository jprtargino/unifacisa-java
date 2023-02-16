package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Student;

public class Program2 {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		ArrayList <Student> list = new ArrayList<>();
		
		int opcao;
		
		do {
			System.out.println("Bem-vindo ao Sistema Escolar. Digite uma das opções desejadas:");
			System.out.println("1 - CADASTRAR ALUNO");
			System.out.println("2 - LISTAR ALUNOS");
			System.out.println("3 - PESQUISAR ALUNO");
			System.out.println("4 - REMOVER ALUNO");
			System.out.println("5 - SAIR");
			opcao = sc.nextInt();
			
			if (opcao == 1) {
				sc.nextLine();
				System.out.println("CADASTRAR ALUNO");
				System.out.print("Digite o nome: ");
				String name = sc.nextLine();
				System.out.print("Digite a matrícula: ");
				int registrationNumber = sc.nextInt();
				System.out.print("Digite a data de nascimento (DD/MM/AAAA): ");
				Date birthDate = sdf.parse(sc.next());
				Student student = new Student(name, registrationNumber, birthDate);
				list.add(student);
				System.out.println("Aluno cadastrado com sucesso!");
				System.out.println(student);
				System.out.println();
			}
			
			if (opcao == 2) {
				System.out.println("LISTAR TODOS");
				if (list.size() != 0) {
					for (Student stu: list) {
					System.out.println(stu);
					System.out.println();
					}
				}
				else {
					System.out.println("Não há alunos cadastrados.\n");
					}
			}
			
			if (opcao == 3) {
				System.out.println("PESQUISAR");
				System.out.print("Digite a matrícula do aluno: ");
				int regist = sc.nextInt();
				
				Student stu = list.stream().filter(x-> x.getRegistrationNumber() == regist).findFirst().orElse(null);
						
				if (stu == null) {
					System.out.println("Essa matrícula não existe!\n");			
				}
				else {
					System.out.println(stu);
				}
			}
			//
			if (opcao == 4) {
				System.out.println("REMOVER ALUNO");
				System.out.print("Digite a matrícula do aluno: ");
				int regist2 = sc.nextInt();
				
				Student stu2 = list.stream().filter(x-> x.getRegistrationNumber() == regist2).findFirst().orElse(null);
						
				if (stu2 == null) {
					System.out.println("Essa matrícula não existe!\n");			
				}
				else {
					list.remove(stu2);
					System.out.println("Aluno removido.\n");
				}
			}
			
			if (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5) {
				System.out.println("Opção inválida. Tente novamente!\n");
			}
		}
		
		while (opcao != 5);
		System.out.println("Obrigado por utilizar nossos serviços. Volte sempre!\n");
		
		sc.close();

	}

}
