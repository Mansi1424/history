package com.example.history.Controller;

import com.example.history.controller.PatientHistoryController;
import com.example.history.repo.PatientHistoryRepo;
import com.example.history.service.PatientHistoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PatientHistoryController.class)
public class PatientHistoryControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PatientHistoryRepo patientHistoryRepo;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientHistoryService patientHistoryService;

    @Test
    public void testGetAllHistory() throws Exception {
        mockMvc.perform(get("/patHistory/get")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }


}
