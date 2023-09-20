package com.bablu.specialclock.service;
import com.bablu.specialclock.exception.TimeConversionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeServiceTest {

    private TimeService timeService;

    @BeforeEach
    public void setUp() {
        timeService = new TimeService();
    }

    @Test
    public void testConvertTimeToWords_ValidTime() {
        String inputTime = "08:34";
        String expectedOutput = "It's eight thirty four o'clock";

        String result = timeService.convertTimeToWords(inputTime);

        assertEquals(expectedOutput, result);
    }

    @Test
    public void testConvertTimeToWords_InvalidTime() {
        String inputTime = "invalidTime";

        assertThrows(TimeConversionException.class, () -> {
            timeService.convertTimeToWords(inputTime);
        });
    }
}
