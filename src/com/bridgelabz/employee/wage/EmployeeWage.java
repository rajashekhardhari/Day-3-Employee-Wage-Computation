package com.bridgelabz.employee.wage;

import java.util.Random;

public class EmployeeWage {

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation Program");

		Random random = new Random();

		int wagePerHour = 20;
		int fullDayHour = 8;
		int partTimeHour = 4;
		int wagePerDay = 0;
		int monthlySalary = 0;
		int monthlyHour = 0;
		int days = 0;

		while (monthlyHour != 100 || days != 20) {

			days++;

			int attendance = random.nextInt(3); // Generate 3 random number 0,1,2
			wagePerDay = 0;
			switch (attendance) {

			case 0:
				System.out.println("Employee Absent");
				break;

			case 1:
				System.out.println("Employee Part Time Present");
				wagePerDay = partTimeHour * wagePerHour;
				monthlyHour = monthlyHour + partTimeHour;
				break;
			default:
				System.out.println("Employee Full Day Present..");
				wagePerDay = wagePerHour * fullDayHour;
				monthlyHour = monthlyHour + fullDayHour;
				break;
			}

			monthlySalary = monthlySalary + wagePerDay;
			System.out
					.println("Day: " + days + " :MonthlyHours: " + monthlyHour + ": Monthly Salary: " + monthlySalary);
		}

	}
}