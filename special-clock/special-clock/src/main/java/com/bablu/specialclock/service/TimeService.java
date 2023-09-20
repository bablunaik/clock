package com.bablu.specialclock.service;
import com.bablu.specialclock.exception.TimeConversionException;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeService {

    public String convertTimeToWords(String time) throws TimeConversionException {
        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime localTime = LocalTime.parse(time, formatter);


            int hours = localTime.getHour();
            int minutes = localTime.getMinute();


            String hourWords = convertToWords(hours);
            String minuteWords = convertToWords(minutes);


            String result = "It's " + hourWords + " " + (minutes != 0 ? minuteWords + " " : "") + "o'clock";
            return result;
        } catch (Exception e) {
            throw new TimeConversionException("Invalid time format or time out of range.");
        }
    }

    private String convertToWords(int number) {
        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen"};

        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty"};

        if (number < 20) {
            return units[number];
        } else {
            return tens[number / 10] + (number % 10 != 0 ? " " + units[number % 10] : "");
        }
    }
}
