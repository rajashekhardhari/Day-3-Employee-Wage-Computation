package com.bridgelabz.employee.wage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EmployeeWage implements InterfaceEmployeeWage {

	static final int EMP_FULL_TIME = 1;
	static final int EMP_PART_TIME = 2;

	private ArrayList<CompanyEmployeeWage> companyEmployeeWageArrayList;
	private Map<String, CompanyEmployeeWage> companyToEmployeeWageMap;

	public EmployeeWage() {
		companyEmployeeWageArrayList = new ArrayList<CompanyEmployeeWage>();
		companyToEmployeeWageMap = new HashMap<>();
	}

	public void addCompanyEmpWage(String company, int wagePerHour, int workingDay, int totalWorkHrs) {

		CompanyEmployeeWage companyEmployeeWage = new CompanyEmployeeWage(company, wagePerHour, workingDay,
				totalWorkHrs);
		companyEmployeeWageArrayList.add(companyEmployeeWage);
		companyToEmployeeWageMap.put(company, companyEmployeeWage);
	}

	public void calculateEmpWage() {
		for (int i = 0; i < companyEmployeeWageArrayList.size(); i++) {
			CompanyEmployeeWage companyEmployeeWage = companyEmployeeWageArrayList.get(i);
			companyEmployeeWage.setTotalEmpWage(this.calculateEmpWage(companyEmployeeWage));
			System.out.println("Company Name :" + companyEmployeeWage.company);
			displayDailyWageForCompany(companyEmployeeWage);
			System.out.println(companyEmployeeWage.company + " Total Wage is " + companyEmployeeWage.totalWage);
		}
	}

	@Override
	public int getTotalWage(String company) {
		return companyToEmployeeWageMap.get(company).totalWage;
	}

	public void displayDailyWageForCompany(CompanyEmployeeWage companyEmployeeWage) {
		for (int i = 0; i < companyEmployeeWage.empDailyWage.size(); i++) {
			int day = i + 1;
			System.out.println("Daily Wage For Day" + day + ":" + companyEmployeeWage.empDailyWage.get(i));
		}
	}

	public int calculateEmpWage(CompanyEmployeeWage companyEmployeeWage) {

		int empWage = 0;
		int totalWorkingHours = 0;
		int totalWorkingDays = 0;

		while (totalWorkingDays < companyEmployeeWage.workingDay
				&& totalWorkingHours < companyEmployeeWage.totalWorkHrs) {

			Random random = new Random();
			int empPresent = random.nextInt(3);
			System.out.println("Random Value for Employee Attendance is :" + empPresent);

			int x;
			switch (empPresent) {

			case EMP_FULL_TIME:

				x = companyEmployeeWage.wagePerHour * 8;
				empWage = empWage + x;
				totalWorkingHours = totalWorkingHours + 8;
				System.out.println("Employee is present and the wage is : " + empWage);
				System.out.println("Daily Wage For Day :" + x);
				totalWorkingDays++;
				break;

			case EMP_PART_TIME:
				x = companyEmployeeWage.wagePerHour * 4;
				empWage = empWage + x;
				totalWorkingHours = totalWorkingHours + 4;
				System.out.println("Employee is Part time present and the wage is : " + empWage);
				System.out.println("Daily Wage For Day :" + x);
				totalWorkingDays++;
				break;

			default:
				System.out.println("Employee is absent and the wage is : " + empWage);
				break;

			}

		}

		System.out.println("Total Working Days :" + totalWorkingDays);
		System.out.println("Total Working Hours :" + companyEmployeeWage.totalWorkHrs);
		System.out.println("Total Employee Wage for company " + companyEmployeeWage.company + " is :" + empWage);

		return empWage;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage calculation");
		EmployeeWage empWage = new EmployeeWage();
		empWage.addCompanyEmpWage("BIG BASKET", 40, 22, 140);
		empWage.addCompanyEmpWage("AMAZON", 90, 21, 222);
		empWage.addCompanyEmpWage("TARGET", 58, 22, 175);
		empWage.calculateEmpWage();
		System.out.println();
		System.out.println("Total Wage for BIG BASKET:" + empWage.getTotalWage("BIG BASKET"));
		System.out.println("Total Wage for AMAZON:" + empWage.getTotalWage("AMAZON"));
		System.out.println("Total Wage for TARGET:" + empWage.getTotalWage("TARGET"));

	}

	@Override
	public void calculateEmployeeWage() {
		// TODO Auto-generated method stub

	}

}