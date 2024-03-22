package com.rayyan;

import com.rayyan.Model.*;
import com.rayyan.Repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class UserAppApplication implements CommandLineRunner 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(UserAppApplication.class, args);
	}
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	BenefitsRepository benefitsRepository;

	@Autowired
	RetirementRepository retirementRepository;

	@Autowired
	InsuranceRepository insuranceRepository;

	@Autowired
	TrainingRepository trainingRepository;

	@Autowired
	ATSRepository atsRepository;

	@Autowired
	PayrollRepository payrollRepository;

	@Override
	public void run(String... args) throws Exception 
	{
		/*
		 * Manual Test Data.
		*/
		employeeRepository.save(new Employee("Kamarel", "Malanda", "27", "kamarelngunda@gmail.com", "111-222-3333", "Kamarel0", "QA Analyst", "123 Capstone St.", "Raleigh", "North Carolina", "United States", "27605", "Employee"));
		employeeRepository.save(new Employee("Javier", "Subina", "25", "javisub@yahoo.com", "441-222-3733", "Javier01", "Web Developer", "123 Junior Rd.", "Frisco", "Texas", "United States", "75008", "Employee"));
		atsRepository.save(new ATS("Rayyan Abdulmunib", "12/11/1999", 22, "Male", "Asian", "Software Developer", "123 HCL Rd. Cary, NC 27890", "123-456-7890", "ray@gmail.com", "US Citizen", 90000.00,  "Associates Degree", "2-5 Years", "09/16/2022"));
		atsRepository.save(new ATS("Kamarel Malanda", "09/06/1995", 27, "Male", "African", "Software Engineer", "123 Capstone St. Raleigh, NC 22345", "111-222-3333", "kam@yahoo.com", "US Citizen", 80000.00,  "HS Diploma", "0-2 Years", "09/18/2022"));
		atsRepository.save(new ATS("Jacob Murray", "07/11/1994", 28, "Male", "Caucasian", "Network Engineer", "123 Laughter Ct. Apex, NC 24567", "444-555-6666", "murrayj@hotmail.com", "US Citizen", 92000.00,  "Associates Degree", "2-5 Years", "11/02/2022"));
		atsRepository.save(new ATS("Samir Williams", "08/12/1994", 28, "Male", "Hispanic", "QA Analyst", "123 Cool Blvd. Raleigh, NC 22345", "666-777-8888", "williams@outlook.com", "US Citizen", 75000.00,  "HS Diploma", "0-2 Years", "11/02/2022"));
		atsRepository.save(new ATS("Justin Rodney", "10/21/1997", 25, "Male", "African-American", "Support Agent", "123 Reader Ave. Dallas, TX 75004", "999-000-1111", "rodneyj@gmail.com", "US Citizen", 95000.00,  "Associates Degree", "2-5 Years", "11/02/2022"));
		atsRepository.save(new ATS("Kennadi Hunter", "05/15/2002", 20, "Female", "African-American", "Data Analyst", "123 Jeopardy Ln. Los Angles, CA 90001", "223-334-5556", "hunterk@yahoo.com", "US Citizen", 80000.00,  "HS Diploma", "0-2 Years", "11/02/2022"));
		atsRepository.save(new ATS("Cameron Nelson", "06/01/2001", 21, "Male", "Caucasian", "Business Analyst", "123 Hardy Dr. Birmingham, AL 35223", "334-665-7778", "nelsonc@hotmail.com", "US Citizen", 90000.00,  "Associates Degree", "2-5 Years", "11/02/2022"));
		atsRepository.save(new ATS("Delores El-Amin", "07/03/2001", 21, "Female", "African-American", "Data Engineer", "123 Fancy Rd. Manhattan, NY 10282", "998-556-4343", "elamind@outlook.com", "US Citizen", 65000.00,  "HS Diploma", "0-2 Years", "11/02/2022"));
		atsRepository.save(new ATS("Jordan Pickett", "02/23/1992", 30, "Male", "Undisclosed", "DevOps Engineer", "123 Retreat St. Cary, NC 27890", "505-456-5464", "pickettj@gmail.com", "US Citizen", 90000.00,  "Associates Degree", "2-5 Years", "11/02/2022"));
		atsRepository.save(new ATS("Detavius Niblack", "01/29/1998", 24, "Male", "African-American", "Test Engineer", "123 Java Ct. Seattle, WA 98101", "702-222-3353", "niblackd@yahoo.com", "US Citizen", 85000.00,  "HS Diploma", "0-2 Years", "11/02/2022"));
		atsRepository.save(new ATS("Julian Gaston", "04/17/2000", 22, "Male", "Undisclosed", "Software Developer", "123 SQL Blvd. Chicago, IL 60007", "909-456-7890", "gastonj@hotmail.com", "US Citizen", 83000.00,  "Associates Degree", "2-5 Years", "11/02/2022"));
		atsRepository.save(new ATS("Jose Fernandez", "09/24/1987", 35, "Male", "Hispanic", "Project Manager", "123 React Ave. Raleigh, NC 22345", "203-112-3333", "fernandezj@outlook.com", "US Citizen", 100000.00,  "Masters Degree", "5+ Years", "11/02/2022"));
	}
}
