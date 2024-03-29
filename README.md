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

Arrays can be static or dynamic in java. 
Dynamic lists - arraylist 
Static lists- array[]
The internal implementation of dynamic list is - the size of the array doubles when the maximum limit is reached.

Stability in sorting means if order of same elements remain same as original array.
Stable: bubble sort, insertion sort, merge sort
Unstable: selection sort, quick sort, heap sort

LRU (least recently used) Cache uses doubly linked list with head and tail pointer and hash table

java.util.Stack = new Stack() -> push, pop, peek, size, isEmpty
java.util.Queue = new ArrayDeque() -> offer, poll, peek, size, isEmpty
java.util.Deque = new ArrayDeque() -> offerFirst, offerLast, pollFirst, pollLast, peekFirst, peekLast, size, isEmpty

Binary tree traversals - 
Inorder - left, root, right
Preorder - root, left, right 
Postorder - left, right, root

Try using StringBuilder instead of concatenating strings like str = str + char/str. It improves the time consumed drastically
Use Deque<Integer> stack = new ArrayDeque<>(); as stack to get lesser time.
Use the same above for queue. So just remember this both stack and queue.