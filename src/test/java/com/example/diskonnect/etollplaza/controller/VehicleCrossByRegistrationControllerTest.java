package com.example.diskonnect.etollplaza.controller;

import com.example.diskonnect.etollplaza.model.VehicleRegistrationNumber;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(VehicleCrossByRegistrationController.class)
class VehicleCrossByRegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldAcknowledgeVehicleCrossByGivenAVehicleCrossesTheTollPlaza() throws Exception {
        this.mockMvc.perform(post("/vehicles/cross-by/registration")
                        .content(objectMapper.writeValueAsString(new VehicleRegistrationNumber("MH 48 P 6529")))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldThrowAnErrorGivenTheVehicleNumberIsNull() throws Exception {
        this.mockMvc.perform(post("/vehicles/cross-by/registration")
                        .content(objectMapper.writeValueAsString(new VehicleRegistrationNumber()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(jsonPath("$.number").value("must not be null"));
    }

    @Test
    void shouldThrowAnErrorGivenTheVehicleNumberIsEmpty() throws Exception {
        this.mockMvc.perform(post("/vehicles/cross-by/registration")
                        .content(objectMapper.writeValueAsString(new VehicleRegistrationNumber("")))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(jsonPath("$.number").value("must not be empty"));
    }
}