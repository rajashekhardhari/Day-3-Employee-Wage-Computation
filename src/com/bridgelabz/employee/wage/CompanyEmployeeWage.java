package com.bridgelabz.employee.wage;

import java.util.ArrayList;

public class CompanyEmployeeWage {

	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;

	public String company;
	public int wagePerHour;
	public int workingDay;
	public int totalWorkHrs;
	public int totalWage;

	public ArrayList<Integer> empDailyWage = new ArrayList<Integer>();

	public CompanyEmployeeWage(String company, int wagePerHour, int workingDay, int totalWorkHrs) {
		this.company = company;
		this.wagePerHour = wagePerHour;
		this.workingDay = workingDay;
		this.totalWorkHrs = totalWorkHrs;
	}

	public void setTotalEmpWage(int totalWage) {
		this.totalWage = totalWage;
	}

	@Override
	public String toString() {
		return "Total Emp Wage for " + company + " is :" + totalWage;

	}
}
