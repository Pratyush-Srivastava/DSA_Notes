package Stack;

import java.util.Stack;

public class EvaluationOfPrefix {
    public static final String EMPTY_SPACE = " ";

    public static void main(String[] args) {
        System.out.println(evaluatePrefix("* + 10 2 - 5 3") == 24);
        System.out.println(evaluatePrefix("- + 2 * 3 1 / 8 4") == 3);
        System.out.println(evaluatePrefix("^ 10 ^ 2 3") == 100000000);
    }

    private static int evaluatePrefix(String postfix) {
        Stack<Integer> operands = new Stack<>();
        String[] s = postfix.split(EMPTY_SPACE);
        for (int i = s.length - 1; i >= 0; i--) {
            String item = s[i];
            if (isNumber(item)) {
                operands.push(Integer.parseInt(item));
            } else {
                int firstOperand = operands.pop();
                int secondOperand = operands.pop();
                switch (item.charAt(0)) {
                    case '+':
                        operands.push(firstOperand + secondOperand);
                        break;
                    case '-':
                        operands.push(firstOperand - secondOperand);
                        break;
                    case '*':
                        operands.push(firstOperand * secondOperand);
                        break;
                    case '/':
                        operands.push(firstOperand / secondOperand);
                        break;
                    case '^':
                        operands.push((int) Math.pow(firstOperand, secondOperand));
                        break;
                }
            }
        }
        return operands.pop();
    }

    private static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
