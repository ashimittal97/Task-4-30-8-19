package com.worldpay.MenuDriven;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
	int eno;
	String name;
	int salary;
	String desg;
	String dept;

	static ArrayList<Employee> list = new ArrayList<>();
	private static int sal;

	Employee() {

	}

	Employee(int eno, String name, int salary, String desg, String dept) {
		this.eno = eno;
		this.name = name;
		this.salary = salary;
		this.desg = desg;
		this.dept = dept;

	}

	void employeeDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many employee's you want to add??");
		int count = sc.nextInt();
		for (int i = 0; i < count; i++) {
			System.out.println("Enter the eno:");
			eno = sc.nextInt();

			System.out.println("Enter the name of employee:");
			sc.nextLine();
			name = sc.nextLine();

			System.out.println("Enter the salary of employee:");
			salary = sc.nextInt();

			System.out.println("Enter the desigination of employee :");
			sc.nextLine();
			desg = sc.nextLine();

			System.out.println("Enter the departement of the employee [IT/ACCOUNTS/MARKETING/HR]");
			dept = sc.nextLine();
			Employee eobj = new Employee(eno, name, salary, desg, dept);
			list.add(eobj);

		}
		System.out.println("employee added");
	}

	public static void ViewAll(ArrayList<Employee> empList) {
		for (Employee list : list) {
			System.out.println(list.eno);
			System.out.println(list.name);
			System.out.println(list.salary);
			System.out.println(list.desg);
			System.out.println(list.dept);
		}
		System.out.println("This  are all employee");
	}

	public static int Remove(int id) {
		for (int i = 0; i <= list.size(); i++)
			if (list.get(i).eno == id) {
				list.remove(list.get(i));

			}
		System.out.println("Empolyee deleted");
		return 0;
	}

	public static void clearData() {
		list.clear();
	}

	public void changeSalary(int sal, int amount) {
		sal = sal + amount;
		salary = sal;
	}

	public static void searchEmployee(int id) {
		for (int i = 0; i <= list.size(); i++) {
			if (list.get(i).eno == id) {
				System.out.println("E no:" + list.get(i).eno);
				System.out.println("E name:" + list.get(i).name);
				System.out.println("E salary:" + list.get(i).salary);
				System.out.println("E desg:" + list.get(i).desg);
				System.out.println("E dept:" + list.get(i).dept);

			}
		}
	}

	public void deptWise() {
		Scanner sc2 = new Scanner(System.in);
		String c = sc2.nextLine();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).dept.equals(c)) {
				System.out.println("E no:" + list.get(i).eno);
				System.out.println("E name:" + list.get(i).name);
				System.out.println("E salary:" + list.get(i).salary);
				System.out.println("E desg:" + list.get(i).desg);
				System.out.println("E dept:" + list.get(i).dept);
			}
		}

	}

	public static void main(String[] args) {

		Scanner sc1 = new Scanner(System.in);
		Employee emp = new Employee();
		int choice;
		while (true) {
			System.out.println("\n");
			System.out.println("Menu:");
			System.out.println("1.Add Employee");
			System.out.println("2.View all Employee");
			System.out.println("3.Remove Employee");
			System.out.println("4.Clear Data");
			System.out.println("5.Change Salary");
			System.out.println("6.Search Employee");
			System.out.println("7.view departement wise list:");
			System.out.println("8.Exit");
			System.out.println("Enter your Choice:");
			choice = sc1.nextInt();
			switch (choice) {
			case 1:
				emp.employeeDetails();
				break;
			case 2:
				ViewAll(list);
				break;
			case 3:
				System.out.println("Enter the id you want to remove");
				Remove(sc1.nextInt());
				break;
			case 4:
				clearData();
				break;
			case 5:
				System.out.println("Enter amount you want to add in salary");
				int amount = sc1.nextInt();
				emp.changeSalary(sal, amount);
				break;

			case 6:
				System.out.println("Enter the id you want to search");
				searchEmployee(sc1.nextInt());
				break;

			case 7:
				emp.deptWise();
				break;
			case 8:
				System.exit(0);
			default:
				break;
			}
		}

	}

}
