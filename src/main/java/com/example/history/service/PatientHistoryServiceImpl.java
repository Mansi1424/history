package com.example.history.service;

import com.example.history.model.PatientHistory;
import com.example.history.repo.PatientHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.history.exception.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Patient History Impl class that has logic to get info from repo
 */
@Service
public class PatientHistoryServiceImpl implements PatientHistoryService{


    private PatientHistoryRepo patientHistoryRepo;

    @Autowired
    public PatientHistoryServiceImpl(PatientHistoryRepo patientHistoryRepo) {
        this.patientHistoryRepo = patientHistoryRepo;
    }

    @Override
    public PatientHistory savePatientHistory(PatientHistory patHistory) {
       return patientHistoryRepo.save(patHistory);
    }

    @Override
    public List<PatientHistory> getAllPatientHistory() {
       return patientHistoryRepo.findAll();
    }

    @Override
    public List<PatientHistory> updateMultiplePatients(List<PatientHistory> patients) {


            List<PatientHistory> updatedHistoryList = new ArrayList<>();

            for (PatientHistory updatedHistory : patients) {

                String id = updatedHistory.getId();
                // check whether patient History is in DB or not
                PatientHistory existingHistory = patientHistoryRepo.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("History", "Id", id));

                existingHistory.setNote(updatedHistory.getNote());

                //save existing history to DB
                patientHistoryRepo.save(updatedHistory);

            }
            return updatedHistoryList;

    }
}
