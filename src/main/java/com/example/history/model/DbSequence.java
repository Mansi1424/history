package com.example.history.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "db_sequence")
public class DbSequence {

    @Transient
    private static final String SEQUENCE_NAME="patient_sequence";

    @Id
    private String id;
    private int seqNo;
}
