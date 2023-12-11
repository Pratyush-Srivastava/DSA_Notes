package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(5);
        queue.offer(10);
        queue.offer(15);
        queue.offer(20);
        queue.offer(25);
        System.out.println("Before reverse: " + queue);
        reverseQueueIterative(queue);
        System.out.println("After reverse: " + queue);
        System.out.println("Before reverse: " + queue);
        reverseQueueRecursive(queue);
        System.out.println("After reverse: " + queue);
    }

    private static void reverseQueueRecursive(Queue<Integer> queue) {
        if (!queue.isEmpty()) {
            int element = queue.poll();
            reverseQueueIterative(queue);
            queue.offer(element);
        }
    }

    private static void reverseQueueIterative(Queue<Integer> queue) {
        Stack<Integer> temp = new Stack<>();
        while (!queue.isEmpty()) {
            temp.push(queue.poll());
        }
        while (!temp.isEmpty()) {
            queue.offer(temp.pop());
        }
    }
}
