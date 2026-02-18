package com.example.demo.service;

import org.springframework.stereotype.Service;


@Service
    public class CalculatorService {
        public int add(int a, int b) {
            return a + b;
        }

        public int divide(int a, int b) {
            return a / b;
        }

        public String input(String name, int age) {
            return "Hello, my name is " + name + " and i am " + age + " years old";
        }
    }

