package com.bridgelabz.employee.wage;

public interface InterfaceEmployeeWage {

	public void addCompanyEmpWage(String company, int wagePerHour, int workingDay, int totalWorkHrs);

	public void calculateEmployeeWage();

	public int getTotalWage(String company);

}
