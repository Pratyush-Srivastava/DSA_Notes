package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPrefix {
    private static final Map<Character, Integer> preference = new HashMap<>();
    private static final Map<Character, Associativity> associativity = new HashMap<>();

    public static void main(String[] args) {
        setPreference();
        setAssociativity();
        System.out.println(infixToPrefix("a+b*c-d/e"));
        System.out.println(infixToPrefix("(a+b)*(c-d)"));
        System.out.println(infixToPrefix("a^b^c"));
    }

    private static void setPreference() {
        preference.put(')', 0);
        preference.put('+', 1);
        preference.put('-', 1);
        preference.put('*', 2);
        preference.put('/', 2);
        preference.put('^', 3);
    }

    private static void setAssociativity() {
        associativity.put('+', Associativity.LEFT_TO_RIGHT);
        associativity.put('-', Associativity.LEFT_TO_RIGHT);
        associativity.put('*', Associativity.LEFT_TO_RIGHT);
        associativity.put('/', Associativity.LEFT_TO_RIGHT);
        associativity.put('^', Associativity.RIGHT_TO_LEFT);
    }


    private static String infixToPrefix(String infix) {
        StringBuilder prefix = new StringBuilder();
        Stack<Character> operators = new Stack<>();
        for (int i = infix.length() - 1; i >= 0; i--) {
            char ch = infix.charAt(i);
            if (isOperand(ch)) {
                prefix.append(ch);
            } else if (ch == '(') {
                while (operators.peek() != ')') {
                    prefix.append(operators.pop());
                }
                operators.pop();
            } else if (operators.isEmpty() || ch == ')'
                    || preference.get(ch) > preference.get(operators.peek())
                    || (preference.get(ch).equals(preference.get(operators.peek())) && Associativity.LEFT_TO_RIGHT.equals(associativity.get(ch)))) {
                operators.push(ch);
            } else {
                while (!operators.isEmpty() &&
                        (preference.get(ch) < preference.get(operators.peek())
                                || (preference.get(ch).equals(preference.get(operators.peek())) &&
                                Associativity.RIGHT_TO_LEFT.equals(associativity.get(ch))))) {
                    prefix.append(operators.pop());
                }
                operators.push(ch);
            }
        }
        while (!operators.isEmpty()) {
            prefix.append(operators.pop());
        }
        return prefix.reverse().toString();
    }

    private static boolean isOperand(char ch) {
        int i = ch - 'a';
        return i >= 0 && i < 26;
    }

    private enum Associativity {
        LEFT_TO_RIGHT, RIGHT_TO_LEFT;
    }

}
