package com.bridgelabz.employee.wage;

import java.util.Random;

import java.util.ArrayList;

public class EmployeeWage {
	public interface IfComputeEmpWage {

		public void addEmployeeWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHourPerMonth);

		public void computeCompanyWage();
	}

	public static class CompWage {
		public String company;
		public int empRatePerHour;
		public int numWorkingDays;
		public int maxHourPerMonth;
		public int totalWage;

		public CompWage(String company, int empRatePerHour, int numWorkingDays, int maxHourPerMonth) {
			this.company = company;
			this.empRatePerHour = empRatePerHour;
			this.numWorkingDays = numWorkingDays;
			this.maxHourPerMonth = maxHourPerMonth;
		}

		public void setTotalWage(int totalwage) {
			this.totalWage = totalwage;
		}

		public String toString() {
			return "Total emp wage for company: " + company + " is " + totalWage;
		}
	}

	public static class EmpBuilder implements IfComputeEmpWage {
		static final int fullTime = 2;
		static final int partTime = 1;
		public ArrayList<CompWage> compempwagelist;
		private int n = 0;

		public EmpBuilder() {
			compempwagelist = new ArrayList();

		}

		public void addEmployeeWage(String company, int empRatePerHour, int numWorkingDays, int maxHourPerMonth) {
			CompWage c = new CompWage(company, empRatePerHour, numWorkingDays, maxHourPerMonth);
			compempwagelist.add(c);
		}

		public void computeCompanyWage() {
			for (int i = 0; i < compempwagelist.size(); i++) {
				CompWage c1 = compempwagelist.get(i);
				c1.setTotalWage(this.ComputeWage(c1));
				System.out.println(c1.totalWage);
			}
		}

		public int ComputeWage(CompWage c) {
			int employeehrs = 0;
			int totalworkdays = 0;
			int totalemphrs = 0;
			// int totalwage=0;

			while (totalemphrs <= c.maxHourPerMonth && totalworkdays < c.numWorkingDays) {
				totalworkdays++;
				int empcheck = (int) Math.floor(Math.random() * 10) % 3;

				switch (empcheck) {
				case 1:
					employeehrs = 4;
					break;
				case 2:
					employeehrs = 8;
					break;
				default:
					employeehrs = 0;
				}
				totalemphrs += employeehrs;
				System.out.println("Emp hrs for day " + totalworkdays + " is: " + employeehrs);
			}
			return totalemphrs * c.empRatePerHour;
		}
	}

	public static void main(String[] args) {
		IfComputeEmpWage e = new EmpBuilder();
		e.addEmployeeWage("D-Mart", 20, 20, 100);
		e.addEmployeeWage("Amazon", 10, 10, 100);
		e.computeCompanyWage();

	}

}