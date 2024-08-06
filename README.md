# DSA_Notes

Data structures and algorithms notes

Make note of

1. Brian Kernighan's algorithm in Bitwise/CountSetBits.java
2. Use of XOR operator in Bitwise/OneOddOccurring.java
3. Finding last set bit in Bitwise/TwoOddOccurring.java
4. Trapping water in Arrays/TrappingWater.java
5. Stack logic of finding previous greater in Stack/StockSpan.java
6. Infix to postfix logic in Stack/InfixToPostfix.java
7. Infix to prefix logic in Stack/InfixToPrefix.java
8. Binary search logic in Searching/SquareRoot.java
9. BinaryTree/SortedArrayToBST.java
10. Bitwise/ReverseBits.java
11. Bitwise/CountSetBits.java
12. LinkedList/ReverseSingleLinkedList.java

LRU (least recently used) Cache uses doubly linked list with head and tail pointer and hash table
(check geeks for geeks video)

java.util.Stack = new Stack() -> push, pop, peek, size, isEmpty
Deque<Integer> stack = new ArrayDeque<>();
java.util.Queue = new ArrayDeque() -> offer, poll, peek, size, isEmpty
java.util.Deque = new ArrayDeque() -> offerFirst, offerLast, pollFirst, pollLast, peekFirst, peekLast, size, isEmpty,
stack functions are also supported -> pop, push, peek, size, isEmpty

Try using StringBuilder instead of concatenating strings like str = str + char/str. It improves the time consumed
drastically
Use Deque<Integer> stack = new ArrayDeque<>(); as stack to get lesser time.
Use the same above for queue. So just remember this both stack and queue.