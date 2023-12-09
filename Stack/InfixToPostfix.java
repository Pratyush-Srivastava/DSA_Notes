package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostfix {
    private static final Map<Character, Integer> preference = new HashMap<>();
    private static final Map<Character, Associativity> associativity = new HashMap<>();

    public static void main(String[] args) {
        setOrderOfPreference();
        setAssociativity();
        System.out.println(infixToPostfix("a+b*c"));
        System.out.println(infixToPostfix("(a+b)*c"));
        System.out.println(infixToPostfix("a^b^c"));
        System.out.println(infixToPostfix("a*b/c"));
        System.out.println(infixToPostfix("a+b/c-d*e"));
    }

    private static void setOrderOfPreference() {
        preference.put('(', 0);
        preference.put('+', 1);
        preference.put('-', 1);
        preference.put('*', 2);
        preference.put('/', 2);
        preference.put('^', 3);
    }

    private static void setAssociativity() {
        associativity.put('(', Associativity.LEFT_TO_RIGHT);
        associativity.put('+', Associativity.LEFT_TO_RIGHT);
        associativity.put('-', Associativity.LEFT_TO_RIGHT);
        associativity.put('*', Associativity.LEFT_TO_RIGHT);
        associativity.put('/', Associativity.LEFT_TO_RIGHT);
        associativity.put('^', Associativity.RIGHT_TO_LEFT);
    }

    private static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if (isOperand(ch)) {
                postfix.append(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    postfix.append(operators.pop());
                }
                operators.pop();
            } else if (operators.isEmpty()
                    || preference.get(ch) > preference.get(operators.peek())
                    || (preference.get(ch).equals(preference.get(operators.peek())) && Associativity.RIGHT_TO_LEFT.equals(associativity.get(ch)))
                    || ch == '(') {
                operators.push(ch);
            } else {
                while (!operators.isEmpty() && (preference.get(ch) < preference.get(operators.peek()) ||
                        (preference.get(ch).equals(preference.get(operators.peek())) && Associativity.LEFT_TO_RIGHT.equals(associativity.get(ch))))) {
                    postfix.append(operators.pop());
                }
                operators.push(ch);
            }
        }
        while (!operators.isEmpty()) {
            postfix.append(operators.pop());
        }
        return postfix.toString();
    }

    private static boolean isOperand(char ch) {
        int i = ch - 'a' + 1;
        return i >= 1 && i <= 26;
    }

    private enum Associativity {
        LEFT_TO_RIGHT, RIGHT_TO_LEFT;
    }
}
