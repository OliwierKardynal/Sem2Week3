package com.example.demo.controller;

import com.example.demo.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/calc")
public class CalculatorController {
    private  final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public ResponseEntity<Integer> add(@RequestParam int a, @RequestParam int b) {
       int result = calculatorService.add(a,b);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/divide")
    public ResponseEntity<?> divide(@RequestParam int a, @RequestParam int b) {

        if (b==0) {
            return ResponseEntity.badRequest().body("Division by zero is not allowed!");
        }
        int result = calculatorService.divide(a,b);
        return ResponseEntity.ok(result);
    }
}
