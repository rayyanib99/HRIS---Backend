package com.rayyan.Controller;

import com.rayyan.Model.Training;
import com.rayyan.Repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RequestMapping("/api/v1")
@RestController
public class TrainingController 
{
    @Autowired
    private TrainingRepository trainingRepository;

    @GetMapping("/training/search")
    public ResponseEntity<List<Training>> searchTraining(@RequestParam("query") String query)
    {
        return ResponseEntity.ok(trainingRepository.searchTraining(query));
    }
    
    @PostMapping("/training")
    public Training createTraning(@RequestBody Training training)
    {
        return trainingRepository.save(training);
    }
}

