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
@Table(name = "Training")
public class Training 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int empId;
    private String trainingName;
    private String completed;

    @Column(name = "last_Update")
    @Temporal(TemporalType.DATE)
    private Date lastUpdate = new Date();
    
    public Training(int empId, String name, String completed)
    {
        this.empId = empId;
        this.trainingName = name;
        this.completed = completed;
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
