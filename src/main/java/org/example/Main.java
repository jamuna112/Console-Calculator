package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        calc.Menu(scan, choice);
        String inp = "";
        calc.parseExpression(inp, scan, choice);
    }
}