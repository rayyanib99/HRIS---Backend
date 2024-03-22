package com.rayyan.Model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Payroll")
public class Payroll 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int empID;
    private int weeklyHours;
    private int ptoHours;
    private double hourlyRate;
    private double grossSalary;
    private double salary;
    private double yearlyBonus;
    private double stateTax ;
    private double federalTax;
    private String employmentType;
    private String payCycle;
    
    @Column(name = "Effective_Date")
    @Temporal(TemporalType.DATE)
    private Date effectiveDate = new Date();

    public Payroll(int empID, int weeklyHours, int ptoHours, double hourlyRate,  double salary, double yearlyBonus, double federalTax, String employmentType, String payCycle) 
    {
        this.empID = empID;
        this.weeklyHours = weeklyHours;
        this.ptoHours = ptoHours;
        this.hourlyRate = hourlyRate;
        this.salary = salary;
        this.yearlyBonus = yearlyBonus;
        this.federalTax = federalTax;
        this.employmentType = employmentType;
        this.payCycle = payCycle;
    }

    public Date getEffectiveDate() 
    {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) 
    {
        this.effectiveDate = effectiveDate;
    }
}

