package org.example;

import java.util.*;

public class Calculator {

    public static final String GREETING_TEXT = "Welcome To Console Calculator";

    public String parseExpression(Scanner scan) {

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

    public Double evaluatePostfix(List<String> postfixExpression) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfixExpression) {
            if (token.matches("\\d+")) {
                stack.push(Double.parseDouble(token));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = 0;

                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        if (operand2 != 0) {
                            result = operand1 / operand2;
                        } else {
                            System.out.println("Error: Division by zero");
                            return Double.NaN;
                        }
                        break;
                    default:
                        System.out.println("Unknown operator: " + token);
                        return Double.NaN;
                }

                stack.push(result);
            }
        }

        return stack.pop();
    }

}
