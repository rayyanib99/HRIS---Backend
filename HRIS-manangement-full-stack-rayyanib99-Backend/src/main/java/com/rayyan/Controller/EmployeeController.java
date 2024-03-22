package com.rayyan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rayyan.Exceptions.ResourceNotFoundException;
import com.rayyan.Model.Employee;
import com.rayyan.Repository.EmployeeRepository;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController 
{
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping("/employee/search")
    public ResponseEntity<List<Employee>> searchTraining(@RequestParam("query") String query)
    {
        return ResponseEntity.ok(employeeRepository.searchTraining(query));
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }
    
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
    {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) throws NoSuchAlgorithmException 
    {
    	// Create MessageDigest instance for MD5
    	MessageDigest md = MessageDigest.getInstance("MD5");

        // Add password bytes to digest
        md.update(employee.getPassword().getBytes());

        // Get the hash's bytes
        byte[] bytes = md.digest();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) 
        {
        	sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        employee.setPassword(sb.toString());
        return employeeRepository.save(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employeeDetails) 
    {
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setAge(employeeDetails.getAge());
        updateEmployee.setEmail(employeeDetails.getEmail());
        updateEmployee.setPhoneNumber(employeeDetails.getPhoneNumber());
        updateEmployee.setJobTitle(employeeDetails.getJobTitle());
        updateEmployee.setAddress(employeeDetails.getAddress());
        updateEmployee.setCity(employeeDetails.getCity());
        updateEmployee.setState(employeeDetails.getState());
        updateEmployee.setCountry(employeeDetails.getCountry());
        updateEmployee.setZipCode(employeeDetails.getZipCode());
        updateEmployee.setRole(employeeDetails.getRole());
        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }
    
    @PutMapping("/employee/access/{id}")
    public String updateAccess(@RequestBody String adminAccess, @PathVariable int id) 
    {
	    Employee emp = employeeRepository.findById(id).get();
	    emp.setRole(adminAccess.substring(1, adminAccess.length() - 1));
	    employeeRepository.save(emp);
	    return adminAccess.substring(1, adminAccess.length() - 1);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int id)
    {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
