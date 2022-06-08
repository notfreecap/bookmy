package com.homesource.bookmy.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RandomController.class)
class RandomControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void testingRandomController() throws Exception {

        mockMvc.perform(get("/random"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}