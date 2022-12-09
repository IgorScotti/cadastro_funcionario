package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter department's name: ");
		String departmentName = sc.next();

		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.next();

		System.out.print("Level: ");
		String workerLevel = sc.next();

		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();

		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Department(departmentName));

		System.out.println("How many contracts to this worker?");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			
			System.out.println("Enter contract " + (i + 1) + " data:");
			System.out.print ("Date (DD/MM/YYYY): ");
			Date date = formato.parse(sc.next());
			
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (Hours): ");
			Integer hours = sc.nextInt();
			
			worker.addContract(new HourContract(date, valuePerHour, hours));
		}
		
		System.out.print ("Enter month and year to calculate income (MM/YYYY): ");
		SimpleDateFormat formatoMesEano = new SimpleDateFormat("MM/yyyy");
		
		Calendar c = Calendar.getInstance();
		Date data = formatoMesEano.parse(sc.next());
		c.setTime(data);
		
		int mes =  1 + c.get(Calendar.MONTH);
		int ano =  c.get(Calendar.YEAR);
		
		
		
		System.out.println("Nome " + worker.getName());
		System.out.println("Departamento "+departmentName);
		System.out.println("Renda para: " + worker.income(ano, mes));
		
		
		
		sc.close();

	}

}
