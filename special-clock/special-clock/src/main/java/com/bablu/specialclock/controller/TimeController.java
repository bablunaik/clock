package com.bablu.specialclock.controller;

import com.bablu.specialclock.exception.TimeConversionException;
import com.bablu.specialclock.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time")
public class TimeController {
    @Autowired
    private TimeService timeService;

    @GetMapping("/convert")
    public ResponseEntity<String> convertTimeToWords(@RequestParam String time) {
        try {
            String result = timeService.convertTimeToWords(time);
            return ResponseEntity.ok(result);
        } catch (TimeConversionException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

//
//@RestController
//@RequestMapping("/time")
//public class TimeController {
//
//    @Autowired
//    private TimeService timeService;
//
//    @GetMapping("/convert")
//    @ApiOperation(value = "Convert time to words", response = String.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully converted time to words"),
//            @ApiResponse(code = 400, message = "Bad request")
//    })
//    public ResponseEntity<String> convertTimeToWords(@RequestParam String time) {
//        try {
//            String result = timeService.convertTimeToWords(time);
//            return ResponseEntity.ok(result);
//        } catch (TimeConversionException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
//}
//
