package com.rayyan.Model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
    private String firstName;
    private String lastName;
    private String age;
    private String email;
    private String phoneNumber;
    private String password;
    private String jobTitle;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String role;
    
    @Column(name = "last_Update")
    @Temporal(TemporalType.DATE)
    private Date lastUpdate = new Date();

    public Employee(String firstName, String lastName, String age, String email, String phoneNumber, String password, String title, String address, String city, String state, String country, String zipCode, String role) throws NoSuchAlgorithmException 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        
        // Create MessageDigest instance for MD5
    	MessageDigest md = MessageDigest.getInstance("MD5");

        // Add password bytes to digest
        md.update(password.getBytes());

        // Get the hash's bytes
        byte[] bytes = md.digest();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) 
        {
        	sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        this.password = sb.toString();
        
        this.jobTitle = title;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.role = role;
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

