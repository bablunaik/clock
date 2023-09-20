package com.bablu.specialclock.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/input")
public class InputController {
    @GetMapping("/check")
    public ResponseEntity<String> checkInput(@RequestParam String input) {
        if ("Midday".equalsIgnoreCase(input)) {
            return ResponseEntity.ok("It's Midday");
        } else if ("Midnight".equalsIgnoreCase(input)) {
            return ResponseEntity.ok("It's Midnight");
        } else {
            return ResponseEntity.badRequest().body("Invalid input");
        }
    }
}
