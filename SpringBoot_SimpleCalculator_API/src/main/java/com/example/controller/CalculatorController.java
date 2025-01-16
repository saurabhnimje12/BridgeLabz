package com.example.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    @GetMapping("/add")
    public String adding(@RequestParam double num1, @RequestParam double num2) {
        double result = num1 + num2;
        return "Adding " + num1 + " + " + num2 + " : " + result;
    }

    @GetMapping("/sub")
    public String subtract(@RequestParam double num1, @RequestParam double num2) {
        double result = num1 - num2;
        return "Subtraction " + num1 + " - " + num2 + " : " + result;
    }

    @GetMapping("/multi")
    public String multiply(@RequestParam double num1, @RequestParam double num2) {
        double result = num1 * num2;
        return "Multiplication " + num1 + " * " + num2 + " : " + result;
    }

    @GetMapping("/div")
    public String divide(@RequestParam double num1, @RequestParam double num2) {

        if (num2 > 0) {
            double result = num1 / num2;
            return "Dividing " + num1 + " / " + num2 + " : " + result;
        }
        return "Error: Num2 is Invalid!! Enter Greater Than 0";
    }
}
