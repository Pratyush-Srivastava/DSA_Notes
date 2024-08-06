# DSA_Notes

Data structures and algorithms notes

Make note of

1. Iterative solution present in Mathematics/Power.java
2. Brian Kernighan's algorithm in Bitwise/CountSetBits.java
3. Use of XOR operator in Bitwise/OneOddOccurring.java
4. Finding last set bit in Bitwise/TwoOddOccurring.java
5. Trapping water in Arrays/TrappingWater.java
6. Stack logic of finding previous greater in Stack/StockSpan.java
7. Infix to postfix logic in Stack/InfixToPostfix.java
8. Infix to prefix logic in Stack/InfixToPrefix.java
9. Binary search logic in Searching/SquareRoot.java
10. BinaryTree/SortedArrayToBST.java
11. Bitwise/ReverseBits.java
12. Bitwise/CountSetBits.java
13. LinkedList/ReverseSingleLinkedList.java

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