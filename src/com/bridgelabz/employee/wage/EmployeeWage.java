package com.bridgelabz.employee.wage;

import java.util.Random;

interface IEmployeeWageComputation
{
    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs);

    public void calculateTotalWage();
}

class CompanyEmpWage
{
    // instance constants
    final String companyName;
    final int wagePerHr;
    final int maxWorkingDays;
    final int maxWorkingHrs;
    // instance variable
    int totalEmpWage=0;
	

    CompanyEmpWage(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
    {
    	this.companyName  = companyName;
        this.wagePerHr = wagePerHr;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHrs = maxWorkingHrs;
        
    }

    void setTotalEmployeeWage(int totalEmpWage)
    {
        this.totalEmpWage = totalEmpWage;
    }

    @Override
    public String toString()
    {
        System.out.println("Details of " + companyName + " employee");
        System.out.println("-----------------------------------------------------");
        System.err.println("Wage per hour:" + wagePerHr);
        System.out.println("Maximum working days:" + maxWorkingDays);
        System.out.println("Maximum working hours:" + maxWorkingHrs);
        return "Total wage for a month of " + companyName + " employee is " + totalEmpWage + "\n";
    }
}

public class EmployeeWage implements IEmployeeWageComputation
{
    // class constants
    public static final int partTime = 1;
    public static final int fullTime = 2;
    // instance variables
    int noOfCompanies, index;
    CompanyEmpWage[] companies;

    public EmployeeWage (int noOfCompanies)
    {
        this.noOfCompanies = noOfCompanies;
        companies = new CompanyEmpWage[noOfCompanies];
        index = 0;
    }

    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
    {
        companies[index++] = new CompanyEmpWage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
    }

    int generateEmployeeType()
    {
        return (int) (Math.random() * 100) % 3;
    }

    int getWorkingHrs(int empType)
    {
        switch (empType)
        {
            case fullTime:
                return 8;
            case partTime:
                return 4;
            default:
                return 0;
        }
    }

    public void calculateTotalWage()
    {
        for (CompanyEmpWage company : companies)
        {
            int totalWage = calculateTotalWage(company);
            company.setTotalEmployeeWage(totalWage);
            System.out.println(company);
        }
    }

    int calculateTotalWage(CompanyEmpWage companyEmpWage)
    {
        System.out.println("Computation of total wage of " + companyEmpWage.companyName + " employee");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%5s     %5s     %5s     %5s\n", "Day", "Workinghrs", "Wage", "Total working hrs");

        int workingHrs, totalWage = 0;
        for (int day = 1, totalWorkingHrs = 0; day <= companyEmpWage.maxWorkingDays
                && totalWorkingHrs <= companyEmpWage.maxWorkingHrs; day++, totalWorkingHrs += workingHrs)
        {
            int empType = generateEmployeeType();
            workingHrs = getWorkingHrs(empType);
            int wage = workingHrs * companyEmpWage.wagePerHr;
            totalWage += wage;
            System.out.printf("%5d       %5d      %5d      %5d\n", day, workingHrs, wage, totalWorkingHrs + workingHrs);
        }
        return totalWage;
    }

    public static void main(String args[])
    {
        EmployeeWage manageWageMultipleCompanies = new EmployeeWage (3);
        manageWageMultipleCompanies.addCompany("D-Mart", 20, 20, 100);
        manageWageMultipleCompanies.addCompany("Amazon", 10, 10, 100);
        manageWageMultipleCompanies.calculateTotalWage();
    }

}