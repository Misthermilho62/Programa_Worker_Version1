package application;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department´s name: ");
		String nameDepartment = sc.nextLine();
		
		Department department = new Department(nameDepartment);
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String nameWorker = sc.nextLine();
		System.out.print("Level: ");
		String levelWorker = sc.next();
		System.out.print("Base salary: ");
		double baseSalaryWorker = sc.nextDouble();
		
		Worker worker = new Worker(nameWorker, WorkerLevel.valueOf(levelWorker), baseSalaryWorker, department);
		
		System.out.print("How many contracts to this worker? ");
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			System.out.println("Enter contract #" + (i + 1) + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date dateContract = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHourContract = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int durationContract = sc.nextInt();
			
			HourContract contract = new HourContract(dateContract, valuePerHourContract, durationContract);
			worker.addContract(contract);
			
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();

	}

}
