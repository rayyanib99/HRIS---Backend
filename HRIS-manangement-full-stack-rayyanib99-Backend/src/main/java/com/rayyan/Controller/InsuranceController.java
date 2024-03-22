package com.rayyan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rayyan.Model.Insurance;
import com.rayyan.Repository.InsuranceRepository;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class InsuranceController 
{
    @Autowired
    private InsuranceRepository insuranceRepository;

    @GetMapping("/insurances")
    public List<Insurance> getAllInsurance() 
    {
        return insuranceRepository.findAll();
    }

    @GetMapping("/insurances/{id}")
    public Insurance getInsuranceById(@PathVariable int id) 
    {
        return insuranceRepository.findById(id).get();
    }

    @PostMapping("/insurances")
    public Insurance saveInsuranceDetails(@RequestBody Insurance insurance) 
    {
        return insuranceRepository.save(insurance);
    }

    @PutMapping("/insurances")
    public Insurance updateInsurance(@RequestBody Insurance insurance) 
    {
        return insuranceRepository.save(insurance);
    }

    @DeleteMapping("/insurances/{id}")
    public ResponseEntity<HttpStatus> deleteInsuranceById(@PathVariable int id) 
    {
        insuranceRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

