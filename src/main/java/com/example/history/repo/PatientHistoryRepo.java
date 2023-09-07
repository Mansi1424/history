package com.example.history.repo;

import com.example.history.model.PatientHistory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientHistoryRepo extends MongoRepository<PatientHistory, String> {


    List<PatientHistory> findByPatId(String patId);
}
