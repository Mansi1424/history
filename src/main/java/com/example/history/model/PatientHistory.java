package com.example.history.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Patient History Model
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "patientHistory")
public class PatientHistory {


    @Id
    private String id;

    private String patId;

    private String note;

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }



}
