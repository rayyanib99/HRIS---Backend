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
@Table(name = "Insurance")
public class Insurance 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int empId;
    private double healthPrem;
    private double lifePrem;
    private double dentalPrem;
    
    @Column(name = "last_Update")
    @Temporal(TemporalType.DATE)
    private Date lastUpdate = new Date();

    public Insurance(int empId, double healthPrem, double lifePrem, double dentalPrem) 
    {
        this.empId = empId;
        this.healthPrem = healthPrem;
        this.lifePrem = lifePrem;
        this.dentalPrem = dentalPrem;
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
