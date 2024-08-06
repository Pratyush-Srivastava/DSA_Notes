package PriorityQueue;


import java.util.*;

public class priorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(9);
        maxHeap.add(8);
        maxHeap.add(7);
        maxHeap.add(6);
        maxHeap.add(5);
        maxHeap.add(50);
        System.out.println("Printing max heap of size " + maxHeap.size());
		while (!maxHeap.isEmpty()) {
			System.out.print(maxHeap.poll() + " ");
		}
		System.out.println();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(10);
        minHeap.offer(8);
        minHeap.offer(6);
        minHeap.offer(4);
        minHeap.offer(2);
        System.out.println("Printing min heap of size " + minHeap.size());
		while (!minHeap.isEmpty()) {
			System.out.print(minHeap.poll() + " ");
		}
		System.out.println();
    }

}
