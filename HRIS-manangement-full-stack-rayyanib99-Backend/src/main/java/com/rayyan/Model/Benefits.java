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
@Table(name = "Benefits")
public class Benefits 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String healthInsurance;
    private String lifeInsurance;
    private String dentalInsurance;
    private String retirementPlan;
    private String pto;
    private String tuitionAssistance;
    private int empId;
    
    @Column(name = "last_Update")
    @Temporal(TemporalType.DATE)
    private Date lastUpdate = new Date();

    public Benefits(int empId, String healthInsurance, String lifeInsurance, String dentalInsurance, String retirementPlan, String pto, String tuitionAssistance) 
    {
        this.healthInsurance = healthInsurance;
        this.lifeInsurance = lifeInsurance;
        this.dentalInsurance = dentalInsurance;
        this.retirementPlan = retirementPlan;
        this.pto = pto;
        this.tuitionAssistance = tuitionAssistance;
        this.empId = empId;
    }

    public Date getLastUpdate() 
    {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) 
    {
        this.lastUpdate = lastUpdate;
    }
}

