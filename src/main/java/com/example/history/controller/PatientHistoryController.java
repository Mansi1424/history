package com.example.history.controller;

import com.example.history.model.PatientHistory;
import com.example.history.service.PatientHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Patient History Controller
 */
@RestController
@RequestMapping("/patHistory")
public class PatientHistoryController {

    private PatientHistoryService patientHistoryService;

//    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public PatientHistoryController(PatientHistoryService patientHistoryService) {
        this.patientHistoryService = patientHistoryService;
//        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    /**
     * POST API - Saves patient note and id
     *
     * @param patId patientId
     * @param note patientNote
     * @return addedPatientHistory
     */
    @PostMapping(path = "/add")
    public ResponseEntity<PatientHistory> saveHistory(@RequestParam String patId, @RequestParam String note) {
        PatientHistory history = new PatientHistory();
        history.setPatId(patId);
        history.setNote(note);

        return new ResponseEntity<>(patientHistoryService.savePatientHistory(history), HttpStatus.CREATED);


    }

    /**
     * GET API - to get patient notes by a patId
     * @param patId patientId set by user
     * @return one patient note by patId
     */
    @GetMapping(path = "/getById")
    @ResponseBody
    public List<PatientHistory> getHistoryById(@RequestParam String patId) {
        return patientHistoryService.getPatientHistoryById(patId);
    }

    /**
     * Get API - to get all patient notes
     *
     * @return Returns all patient history
     */
    @GetMapping("/get")
    public List<PatientHistory> getHistory() {
        return patientHistoryService.getAllPatientHistory();
    }


    /**
     * PUT api to get update all history
     *
     * @param updatedPatients historyBodyToUpdate
     * @return updatedPatientHistory
     */
    @PutMapping("/update")
    @ResponseBody
    public List<PatientHistory> updateMultipleHistory(@RequestBody List<PatientHistory> updatedPatients) {

        return patientHistoryService.updateMultiplePatients((updatedPatients));

    }



}
