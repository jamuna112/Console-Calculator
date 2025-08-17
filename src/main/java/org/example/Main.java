package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scan = new Scanner(System.in);
        String input = calc.parseExpression(scan);
       List<String> output =  calc.toPostfix(input);

       double res =  calc.evaluatePostfix(output);
        System.out.println("Given string postfix is "+ res);

    }
}