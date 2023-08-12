package com.example.history.repo;

import com.example.history.model.PatientHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientHistoryRepo extends MongoRepository<PatientHistory, Integer> {
}
