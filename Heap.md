* PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  minHeap.offer(10);
  minHeap.offer(8);
  minHeap.offer(6);
  minHeap.offer(4);
  minHeap.offer(2);
  while (!minHeap.isEmpty()) {
  System.out.print(minHeap.poll() + " ");
  }
* PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  maxHeap.add(9);
  maxHeap.add(8);
  maxHeap.add(7);
  maxHeap.add(6);
  maxHeap.add(5);
  maxHeap.add(50);
  while (!maxHeap.isEmpty()) {
  System.out.print(maxHeap.poll() + " ");
  }