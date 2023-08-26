package com.example.history.repo;

import com.example.history.model.PatientHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientHistoryRepo extends MongoRepository<PatientHistory, Integer> {
}
