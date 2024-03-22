package com.rayyan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rayyan.Model.ATS;
import com.rayyan.Repository.ATSRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class AtsController 
{
    @Autowired
    private ATSRepository atsRepository;
    
    @GetMapping("/ats/search")
    public ResponseEntity<List<ATS>> searchTraining(@RequestParam("query") String query)
    {
        return ResponseEntity.ok(atsRepository.searchTraining(query));
    }
    
    @GetMapping("/ats")
    public List<ATS> getAllATS() 
    {
        return atsRepository.findAll();
    }

    @GetMapping("/ats/{id}")
    public ATS getATSById(@PathVariable int id) 
    {
        return atsRepository.findById(id).get();
    }
    
    @PostMapping("/ats")
    public ATS createAts(@RequestBody ATS ats)
    {
    	ats.setDateFormat();
    	ats.setDefault();
        return atsRepository.save(ats);
    }

    @PutMapping("/ats")
    public ATS updateAts(@RequestBody ATS ats) 
    {
        return atsRepository.save(ats);
    }
    
    @PutMapping("/ats/{id}")
    public String updateStatus(@RequestBody String status, @PathVariable int id) 
    {
	    ATS applicant = atsRepository.findById(id).get();
	    applicant.setAppStatus(status.substring(1, status.length() - 1));
	    atsRepository.save(applicant);
        return status.substring(1, status.length() - 1);
    }

    @DeleteMapping("/ats/{id}")
    public ResponseEntity<HttpStatus> deleteAtsById(@PathVariable int id) 
    {
        atsRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
