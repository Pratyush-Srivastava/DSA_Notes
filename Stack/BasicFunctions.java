package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BasicFunctions {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("Pushing " + stack.push(30));
        System.out.println("Pushing " + stack.push(40));
        System.out.println("Peek " + stack.peek());
        System.out.println("Pop " + stack.pop());
        System.out.println("Size " + stack.size());
        System.out.println("isEmpty " + stack.isEmpty());
        System.out.println("Using Deque and ArrayDeque");
        Deque<Integer> st = new ArrayDeque<>();
        System.out.println("Pushing 30");
        st.push(30);
        System.out.println("Pushing 40");
        st.push(40);
        System.out.println("Peek " + st.peek());
        System.out.println("Pop " + st.pop());
        System.out.println("Size " + st.size());
        System.out.println("isEmpty " + st.isEmpty());
    }
}
