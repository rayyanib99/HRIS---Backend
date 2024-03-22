package com.rayyan.Model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Calendar;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Applicants")
public class ATS 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    
    @Column(name = "dob")
    private String dateOfBirth;
    
    private int age;
    private String gender;
    private String race;
    private String position;
    private String address;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    private String email;
    
    @Column(name = "legal_status")
    private String legal;
    
    @Column(name = "desired_salary")
    private Double desirePay;
    
    @Column(name = "highest_ed")
    private String highestEducation;
    
    @Column(name = "relevant_exp")
    private String relExp;
    
    @Column(name = "applied_date")
    private String date;
    
    @Column(name = "app_status")
    private String appStatus;
    
    @Column(name = "last_updated")
    @Temporal(TemporalType.DATE)
    private Date lastUpdate = new Date();

    public ATS(String fullName, String dateOfBirth, int age, String gender, String race, String position, String address, String phoneNumber, String email, String legal, Double desirePay, String highestEducation, String relExp, String date) 
    {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.gender = gender;
        this.race = race;
        this.position = position;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.legal = legal;
        this.desirePay = desirePay;
        this.highestEducation = highestEducation;
        this.relExp = relExp;
        this.date = date;
        this.appStatus = "Under Review.";
    }

    public void setDefault() 
    {
        this.appStatus = "Under Review.";
    }
    
    public void setDateFormat()
    {
    	String month = this.getDateOfBirth().substring(5, 7);
    	String day = this.getDateOfBirth().substring(8, 10);
    	String year = this.getDateOfBirth().substring(0, 4);
    	this.setDateOfBirth(month + "/" + day + "/" + year);
    	
    	String month2 = this.getDate().substring(5, 7);
    	String day2 = this.getDate().substring(8, 10);
    	String year2 = this.getDate().substring(0, 4);
    	this.setDate(month2 + "/" + day2 + "/" + year2);
    	
    	this.setAge(Calendar.getInstance().get(Calendar. YEAR) - Integer.parseInt(year));
    }

    public void setLastUpdate(Date lastUpdate) 
    {
        this.lastUpdate = lastUpdate;
    }
}
