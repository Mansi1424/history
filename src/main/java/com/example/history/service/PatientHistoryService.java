package com.example.history.service;

import com.example.history.model.PatientHistory;

import java.util.List;

public interface PatientHistoryService {
    PatientHistory savePatientHistory(PatientHistory patHistory);

    List<PatientHistory> getAllPatientHistory();

    List<PatientHistory> getPatientHistoryById(String patId);

    List<PatientHistory> updateMultiplePatients(List<PatientHistory> patients);
}
