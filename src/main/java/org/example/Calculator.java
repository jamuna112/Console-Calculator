package org.example;

import java.util.*;

public class Calculator {

    public static final String GREETING_TEXT = "Welcome To Console Calculator";

    public Integer Menu(Scanner scan){
        System.out.println("List of Operations");
        System.out.println("1. Enter Expression with spaces: ");
        System.out.println("2. View History: ");
        System.out.println("3. Clear History");
        System.out.println("4. Exit");
        System.out.print("Enter what you want to perform: ");
       int choice = scan.nextInt();
        scan.nextLine();

        return choice;
    }

    public String parseExpression(Scanner scan, int choice) {

        System.out.println("Please enter expression: ");
        String input = scan.nextLine();
        System.out.println("you entered "+ input);

        return input;
    }

    public List<String> toPostfix(String expression){
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();

        Map<String, Integer> precedence = new HashMap<>();

        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);

        String[] tokens = expression.split(" ");

        for (String token: tokens){
            if (token.matches("\\d+")) {
                output.add(token);

            } else if (precedence.containsKey(token)) {
                while (!operators.isEmpty() && precedence.getOrDefault(operators.peek(), 0) >= precedence.get(token)) {
                    output.add(operators.pop());
                }
                operators.push(token);
                }
            }
        while (!operators.isEmpty()){
            output.add(operators.pop());
        }
        return output;
    }
}
