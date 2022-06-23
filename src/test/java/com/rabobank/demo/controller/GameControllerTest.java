package com.rabobank.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabobank.demo.model.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static com.rabobank.demo.model.Hand.ROCK;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author horman
 */
@SpringBootTest
@AutoConfigureMockMvc
class GameControllerTest {
    ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test getGameResponse valid request parameter ROCK returns a response")
    void test1() throws Exception {
        Response response = om.readValue(mockMvc.perform(get("/game?playerHand=" + ROCK))
                .andExpect(status().isAccepted())
                .andReturn()
                .getResponse()
                .getContentAsString(), Response.class);
        assertTrue(response.getGameResult() != null);
        assertTrue(response.getComputerHand() != null);
    }

    @Test
    @DisplayName("Test getGameResponse invalid request parameter BANANA returns BAD REQUEST")
    void test2() throws Exception {
        mockMvc.perform(get("/game?playerHand=" + "BANANA"))
                .andExpect(status().isBadRequest())
                .andReturn();
    }
}