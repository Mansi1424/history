package com.example.history.service;

import com.example.history.model.PatientHistory;
import com.example.history.repo.PatientHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientHistoryServiceImpl implements PatientHistoryService{

    @Autowired
    private PatientHistoryRepo patientHistoryRepo;
    @Override
    public PatientHistory savePatientHistory(PatientHistory patHistory) {
       return patientHistoryRepo.save(patHistory);
    }
}
