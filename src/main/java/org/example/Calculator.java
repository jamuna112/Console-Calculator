package org.example;

import java.util.Scanner;

public class Calculator {

    public static final String GREETING_TEXT = "Welcome To Console Calculator";

    public void Menu(Scanner scan, int choice){
        System.out.println("List of Operations");
        System.out.println("1. Enter Expression: ");
        System.out.println("2. View History: ");
        System.out.println("3. Clear History");
        System.out.println("4. Exit");
        System.out.print("Enter what you want to perform: ");
        choice = scan.nextInt();
        scan.nextLine();
    }

    public void parseExpression(String input, Scanner scan, int choice) {

        System.out.println("Please enter expression: ");
        input = scan.nextLine();
        System.out.println("you entered "+ input);

    }
}
