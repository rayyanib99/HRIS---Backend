package com.rayyan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rayyan.Model.Payroll;
import com.rayyan.Repository.PayrollRepository;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class PayrollController 
{
    @Autowired
    private PayrollRepository payrollRepository;

    @GetMapping("/payroll")
    public List<Payroll> getAllPayroll() 
    {
        return payrollRepository.findAll();
    }

    @GetMapping("/payroll/{id}")
    public Payroll getPayrollById(@PathVariable int id) 
    {
        return payrollRepository.findById(id).get();
    }

    @PostMapping("/payroll")
    public Payroll savePayrollDetails(@RequestBody Payroll payroll) 
    {
        return payrollRepository.save(payroll);
    }

    @PutMapping("/payroll")
    public Payroll updatePayroll(@RequestBody Payroll payroll) 
    {
        return payrollRepository.save(payroll);
    }

    @DeleteMapping("/payroll/{id}")
    public ResponseEntity<HttpStatus> deletePayrollById(@PathVariable int id) 
    {
        payrollRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

