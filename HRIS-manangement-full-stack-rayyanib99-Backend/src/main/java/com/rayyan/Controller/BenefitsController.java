package com.rayyan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rayyan.Model.Benefits;
import com.rayyan.Repository.BenefitsRepository;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class BenefitsController 
{
    @Autowired
    private BenefitsRepository benefitsRepository;

    @GetMapping("/benefits")
    public List<Benefits> getAllBenefits() 
    {
        return benefitsRepository.findAll();
    }

    @GetMapping("/benefits/{id}")
    public Benefits getUserById(@PathVariable int id) 
    {
        return benefitsRepository.findById(id).get();
    }

    @PostMapping("/benefits")
    public Benefits saveBenefitsDetails(@RequestBody Benefits benefits) 
    {
        return benefitsRepository.save(benefits);
    }

    @PutMapping("/benefits")
    public Benefits updateBenefits(@RequestBody Benefits benefits) 
    {
        return benefitsRepository.save(benefits);
    }

    @DeleteMapping("/benefits/{id}")
    public ResponseEntity<HttpStatus> deleteBenefitsById(@PathVariable int id) 
    {
        benefitsRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

