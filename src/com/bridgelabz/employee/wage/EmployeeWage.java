package com.bridgelabz.employee.wage;

import java.util.Random;

public class EmployeeWage {

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation Program");
      
		Random random= new Random();
		int attendance=random.nextInt(2);
		
		int wagePerHour =20;
		int fullDayHour =8;
		int wagePerDay =0;
		
		if(attendance == 1) {
			System.out.println("Employee Present..");
		    wagePerDay=wagePerHour*fullDayHour;    
		}else
			System.out.println("Employee Absent..");
		
		System.out.println("Employee Wage Per Day :-"+wagePerDay);
	 }

}
