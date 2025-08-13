package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        calc.Menu(scan);
        String input = calc.parseExpression(scan, choice);
       List<String> output =  calc.toPostfix(input);
        System.out.println("Given string postfix is "+ String.join(" ", output));
    }
}