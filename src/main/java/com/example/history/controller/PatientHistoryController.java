package com.example.history.controller;

import com.example.history.model.PatientHistory;
import com.example.history.repo.PatientHistoryRepo;
import com.example.history.service.PatientHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patHistory")
public class PatientHistoryController {

    @Autowired
    private PatientHistoryRepo repository;

    @Autowired
    private PatientHistoryService patientHistoryService;

    @PostMapping(path="/add")
    public ResponseEntity<PatientHistory> saveHistory(@RequestParam int id, @RequestParam String notes) {
            PatientHistory history = new PatientHistory();
            history.setPatId(id);
            history.setNote(notes);

            // Save data to the repository
            repository.save(history);

            return new ResponseEntity<PatientHistory>(patientHistoryService.savePatientHistory(history), HttpStatus.CREATED);


    }

    @GetMapping()
    public List<PatientHistory> getBooks() {
        return repository.findAll();
    }

}
