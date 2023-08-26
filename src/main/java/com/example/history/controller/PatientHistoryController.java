package com.example.history.controller;

import com.example.history.model.PatientHistory;
import com.example.history.service.PatientHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/patHistory")
public class PatientHistoryController {

    private PatientHistoryService patientHistoryService;

    @Autowired
    public PatientHistoryController(PatientHistoryService patientHistoryService) {
        this.patientHistoryService = patientHistoryService;
    }


    @PostMapping(path = "/add")
    public ResponseEntity<PatientHistory> saveHistory(@RequestParam int patId, @RequestParam String note) {
        PatientHistory history = new PatientHistory();
        history.setPatId(patId);
        history.setNote(note);

        return new ResponseEntity<>(patientHistoryService.savePatientHistory(history), HttpStatus.CREATED);


    }

    @GetMapping("/get")
    public List<PatientHistory> getHistory() {
        return patientHistoryService.getAllPatientHistory();
    }

    @PutMapping("/update")
    @ResponseBody
    public List<PatientHistory> updateMultipleHistory(@RequestBody List<PatientHistory> updatedPatients) {

        return patientHistoryService.updateMultiplePatients((updatedPatients));

    }



}
