package Stack;

import java.util.Map;
import java.util.Stack;

public class EvaluationOfPostfix {

    public static final String EMPTY_SPACE = " ";

    public static void main(String[] args) {
        System.out.println(evaluatePostfix("10 2 * 3 +"));
        System.out.println(evaluatePostfix("10 2 + 3 *"));
        System.out.println(evaluatePostfix("10 2 3 ^ ^"));
    }

    private static int evaluatePostfix(String postfix) {
        Stack<Integer> operands = new Stack<>();
        String[] s = postfix.split(EMPTY_SPACE);
        for (int i = 0; i < s.length; i++) {
            String item = s[i];
            if (isNumber(item)) {
                operands.push(Integer.parseInt(item));
            } else {
                int secondOperand = operands.pop();
                int firstOperand = operands.pop();
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
