package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BasicFunctions {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(12);
        queue.offer(57);
        queue.offer(19);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(12);
        deque.offerLast(15);
        deque.offerFirst(56);
        deque.offerLast(67);
        System.out.println(deque);
        deque.pollFirst();
        deque.pollLast();
        System.out.println(deque);
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.isEmpty());
        System.out.println(deque.size());
    }
}
