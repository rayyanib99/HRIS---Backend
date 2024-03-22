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
@Table(name = "Retirement")
public class Retirement 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int empId;
    private double amount_401k;
    private double amount_403b;
    private double amount_457b;
    
    @Column(name = "last_Update")
    @Temporal(TemporalType.DATE)
    private Date lastUpdate = new Date();

    public Retirement(int empId, double amount_401k, double amount_403b, double amount_457b) 
    {
        this.empId = empId;
        this.amount_401k = amount_401k;
        this.amount_403b = amount_403b;
        this.amount_457b = amount_457b;
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
