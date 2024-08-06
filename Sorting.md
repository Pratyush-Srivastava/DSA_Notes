* You can use Arrays.sort for all kinds of arrays but comparator can be used only for Objects (Integer[] but not for
  int[]).
* You can use Collections.sort for all kinds of array lists and comparator can be used for Objects
* Arrays.sort(new Integer[]{1, 2}, (a, b) -> {
  return b - a;
  });
  Collections.sort(Arrays.asList(1, 2, 3), (a, b) -> {
  return b - a; //reverse sorting
  });
* Stability in sorting means if order of same elements remain same as original array.
  Stable: bubble sort, insertion sort, merge sort
  Unstable: selection sort, quick sort, heap sort
* In Bubble sort, we compare adjacent elements and swap if first is bigger than second. In the end of first iteration,
  the last position is set. In the second iteration, the second last position is set. In this way, all elements are
  sorted. This is a stable sorting algo because it doesn't swap if they are equal. O(n^2)
* In selection sort, we find max of all elements and swap it with last unsorted element. In the end of first iteration,
  the max element is at the last. Keep doing this until all elements are sorted. This is unstable sort O(n^2). It
  does less number of writes but cycle sort is most optimal for less number of writes.
* Insertion sort is used for smaller arrays. It is stable. You have two parts in an array. The left part is sorted. The
  right part is unsorted. Initially have only one element in sorted. With each iteration, the sorted array grows. In
  each iteration, push the first element from unsorted array back to sorted array until it reaches its correct place.
  Move every element to the front by one step until you reach smaller element. In the final step, place the unsorted
  element. In worst case, O(n^2). Best case O(n)
* Merge sort runs on divide and conquer algorithm. First divide the array into two parts using mid and then merge two
  sorted arrays. When the recursion starts, it keeps dividing and becomes small. While combining those small arrays,
  you need to sort and conquer them. While returning, you will get a sorted array. This will be done in O(n log n). This
  is a stable sort.
* Count inversions (where a(i) > a(j) but i < j) can be done in O(n^2) by naive method but it can be done in O(nlogn) by
  implementing merge sort and making changes in merge sorted lists method. If right element is smaller than any left
  array element, it will be smaller than all left elements after that. So increase the count of inversions for all those
  elements and return. countInversions += (high1 - i1 + 1)
* For quick sort, you need to use lomuto partition in which we consider the last element as pivot and traverse j from
  start to pivot-1. Also maintain i = -1 which is the last element of window smaller than pivot.
  if (arr(iterator) < arr(pivot)) {
  lastSmallElementIndex++;
  swap(arr, lastSmallElementIndex, iterator);
  }
  Call partition method from quick sort to know the exact position of the pivot element. Once partition method is
  called, the pivot element is placed in the correct position. Then all you need to do is call quick sort for both
  halves around partition point. This is O(nlogn) in average case and O(n^2) in worst case (when array is sorted).
  Quick sort is tail recursive unlike merge sort. Quick sort doesn't need extra array like merge sort. The partition
  method in quick sort is in-place. Quick sort requires memory because of recursion call stack.
* To find Kth smallest (or largest) element, use the partition method of quick sort. In the end, it will put the pivot
  in the correct position p. Like binary search run a while loop and see if p < k - 1, then you can search in right half
  else you can search in left half. Time complexity will be O(nlogn) but will be better in avg case.
* In chocolate distribution problem, you need to pick m packets in an array such that max - min should be the least
  possible Sort the array, Using window technique, you can find the difference of max - min. Store the min value and
  return it.
* To Segregate positive and negative numbers, or segregate odd and even numbers, we can use partition method of quick
  sort to solve this problem in O(n) and O(1). For positive and negative numbers, your pivot will be 0.
* To Segregate into three partitions when given a range (lowRange, highRange). You need to modify the partition method
  to include lastSmallElementIndex = -1 and also firstHighElementIndex = n. In case of swapping with
  firstHighElementIndex don't change the j value because there is a chance you are swapping an unknown which might be
  part of lastSmallElementIndex.
* If you are given intervals of time at which each guests arrive, and you need to find the maximum people you can meet
  by reaching at a point. Then to find the max guests, you can sort all arrivals and departures and then traverse
  together like merge function of mergeSort. If arrival is smaller than departure you can increase the count of guests,
  else you can reduce it. The max value ever reached will be your answer.
* TODO Cycle sort does minimum memory writes. Use it when writing is costly. It is unstable. Does minimum swapping.
* Heap sort is an extension of selection sort. In selection sort, we find the max element and place it in last place.
  To find the max element, we used linear algo. Here we will use a max heap. First, we need to build a heap from an
  existing array. For that iterate from the last internal node (parent of last leaf. The last leaf of a complete tree is
  n-1. Parent of any child will be (child-1)/2. A parent will have two children. Left = 2 * parent + 1
  Right = 2 * parent + 2. So last internal node will be (n-2)/2). Iterate from last internal node till i=0 which is root
  Call maxHeapify for each internal node. MaxHeapify is called for parents generally. In MaxHeapify, we calculate
  left and right child values if they exist and compare their value with largest. If largest is not parent, we swap that
  child with parent and call maxHeapify for that swapped child because may be the parent can be very small which needs
  to traverse further. After building heap, we will have max element as first element. Like selection sort with each
  iteration, the last element will be at its place, and we will reduce the heap size (IMPORTANT) in maxHeapify function
  because if we don't, the last element will traverse up again. In the end, we will get sorted array in O(nlog n)
* In counting sort, we have a small range K where all the elements are present, we traverse through the array and store
  the counts in count array, and then we traverse through count array to print the sorted array. This will take O(n + k)
* In Radix sort, we sort all the last digits and then the middle digits and so on till first digits. To sort digits, we
  can use counting sort because digits vary from 0 to 9. Number of passes is equal to number of digits. O(nd)
* We use bucket sort when the elements are equally distributed. In bucket sort, we define few buckets and traverse
  through each element to store it in respective buckets and then do insertion sort which is used for smaller number
  of elements. It will take O(n) in average