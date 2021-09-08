package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		int num = 1;
		for(int i=0; i<n; i++) {
			System.out.println();
			System.out.println("Emplyoee #" + num + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			
			while (hasId(list, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			list.add(new Employee(id, name, salary));
			num++;
			
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		Integer id2 = sc.nextInt();
	
		Employee emp = list.stream().filter(x -> x.getId() == id2).findFirst().orElse(null);
		
		if (emp == null) {
			System.out.println("This id does not exist!");
			//id2 = sc.nextInt();
		}
		
		else {
			System.out.print("Enter the percentage: ");
			Double perecentage = sc.nextDouble();
			emp.increaseSalary(perecentage);
					
		}
		
		System.out.println();
		System.out.println("List of employees:");
		for(Employee result : list) {
			System.out.println(result);
		}

		
		sc.close();

	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}


