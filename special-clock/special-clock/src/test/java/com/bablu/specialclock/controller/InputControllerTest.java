package com.bablu.specialclock.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(InputController.class)
public class InputControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCheckInput_Midday() throws Exception {
        String input = "Midday";

        mockMvc.perform(MockMvcRequestBuilders.get("/input/check")
                        .param("input", input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("It's Midday"));
    }

    @Test
    public void testCheckInput_Midnight() throws Exception {
        String input = "Midnight";

        mockMvc.perform(MockMvcRequestBuilders.get("/input/check")
                        .param("input", input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("It's Midnight"));
    }

    @Test
    public void testCheckInput_InvalidInput() throws Exception {
        String input = "InvalidInput";

        mockMvc.perform(MockMvcRequestBuilders.get("/input/check")
                        .param("input", input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Invalid input"));
    }
}
