package com.bablu.specialclock.controller;

import com.bablu.specialclock.service.TimeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TimeController.class)
public class TimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TimeService timeService;

    @Test
    public void testConvertTimeToWords() throws Exception {
        String inputTime = "08:34";
        String expectedOutput = "It's eight thirty four o'clock";

        Mockito.when(timeService.convertTimeToWords(inputTime)).thenReturn(expectedOutput);

        mockMvc.perform(MockMvcRequestBuilders.get("/time/convert")
                        .param("time", inputTime)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedOutput));
    }
}
