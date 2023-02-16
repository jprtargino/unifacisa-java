package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		ArrayList <Employee> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <=n; i++) {
			System.out.println("\nEmployee #" + i + ":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			Employee employee = new Employee(id, name, salary);
			list.add(employee);
		}
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idSalario = sc.nextInt();
		
		Employee emp = list.stream().filter(x->x.getId()==idSalario).findFirst().orElse(null);
				
		if (emp == null) {
			System.out.println("This id does not exist!");			
			
		}
		
		else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		
		System.out.println();
		System.out.println("List of Employees: ");
		for (Employee o: list) {
			System.out.println(o);
		}
		
		
		
		
		
		
		sc.close();

	}

}
