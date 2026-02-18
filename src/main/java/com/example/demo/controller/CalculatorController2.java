package com.example.demo.controller;

import com.example.demo.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class CalculatorController2 {
    private final CalculatorService calculatorService;

    public CalculatorController2(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/name")
    public ResponseEntity<String> input(@RequestParam String name, @RequestParam int age) {
        if (age <= 0) {
            return ResponseEntity.badRequest().body("Error: Age cannot be less than zero!.");
        }
        if (name.length()>24) {
            return ResponseEntity.badRequest().body("Error: Please write a shorter name!.");
        }
        // https://stackoverflow.com/questions/3820602/how-to-check-whether-a-int-is-not-null-or-empty//
        //this is how i found out how to make empty validation
        if (name.isEmpty()) {
            return ResponseEntity.badRequest().body("Error: Please write a valid name!.");
        }
        return ResponseEntity.ok(calculatorService.input(name, age));
    }
}