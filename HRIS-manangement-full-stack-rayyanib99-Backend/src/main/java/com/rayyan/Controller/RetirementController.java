package com.rayyan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rayyan.Model.Retirement;
import com.rayyan.Repository.RetirementRepository;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class RetirementController 
{
    @Autowired
    private RetirementRepository retirementRepository;

    @GetMapping("/retirement")
    public List<Retirement> getAllRetirement() 
    {
        return retirementRepository.findAll();
    }

    @GetMapping("/retirement/{id}")
    public Retirement getRetirementById(@PathVariable int id) 
    {
        return retirementRepository.findById(id).get();
    }

    @PostMapping("/retirement")
    public Retirement saveRetirementDetails(@RequestBody Retirement retirement) 
    {
        return retirementRepository.save(retirement);
    }

    @PutMapping("/retirement")
    public Retirement updateRetirement(@RequestBody Retirement retirement) 
    {
        return retirementRepository.save(retirement);
    }

    @DeleteMapping("/retirement/{id}")
    public ResponseEntity<HttpStatus> deleteRetirementById(@PathVariable int id) 
    {
        retirementRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
