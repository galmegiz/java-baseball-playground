package string_calculator;

import java.util.Deque;
import java.util.LinkedList;

public class StringCalculator {

    public static String calculateString(String mathExpression) {
        String[] tokens = mathExpression.split(" ");
        Deque<String> stack = new LinkedList<>(); // local variable so thread safe

        for(String token : tokens){
            stack.add(token);
            if (stack.size() == 3) {
                String operand1 = stack.pop();
                String operator = stack.pop();
                String operand2 = stack.pop();
                String result = calculate(operand1, operator, operand2);
                stack.add(result);
            }
        }

        return stack.pop();
    }

    private static String calculate(String operand1, String operator, String operand2) {
        if (operator.equals("+")) {
            return plus(operand1, operand2);
        } else if (operator.equals("-")) {
            return minus(operand1, operand2);
        } else if (operator.equals("*")) {
            return multiply(operand1, operand2);
        } else if (operator.equals("/")) {
            return divide(operand1, operand2);
        } else {
            throw new IllegalArgumentException("not supported operation");
        }
    }

    public static String plus(String operand1, String operand2) {
        double number1 = Double.parseDouble(operand1);
        double number2 = Double.parseDouble(operand2);

        return String.valueOf(number1 + number2);
    }

    public static String minus(String operand1, String operand2) {
        double number1 = Double.parseDouble(operand1);
        double number2 = Double.parseDouble(operand2);

        return String.valueOf(number1 - number2);
    }

    public static String divide(String operand1, String operand2) {
        double number1 = Double.parseDouble(operand1);
        double number2 = Double.parseDouble(operand2);
        if (number2 == 0) {
            throw new IllegalArgumentException("operand2 cannot be 0");
        }

        return String.valueOf(number1 / number2);
    }

    public static String multiply(String operand1, String operand2) {
        double number1 = Double.parseDouble(operand1);
        double number2 = Double.parseDouble(operand2);

        return String.valueOf(number1 * number2);
    }
}
