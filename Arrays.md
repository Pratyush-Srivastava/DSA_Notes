* Arrays can be static or dynamic in java. Dynamic lists - arraylist Static lists - array[]. The internal implementation 
  of dynamic list is - the size of the array doubles when the maximum limit is reached.
* List<String> staticArrayList = Arrays.asList("a", "b"); This will be a static array list. You cannot add or remove 
  items
* List<String> dynamicArrayList = new ArrayList<>(Arrays.asList("a", "b")); This will be a dynamic array list. You 
  can add or remove items.
* String[] staticArray = {"a", "b"};. This will be a static array. You cannot add or remove items
* To rotate array by d in-place, reverse first d, reverse last d and then reverse entire array.
* For trapping rain water problem, we need to find min(lmax, rmax)- arr(i)
* To find maximum sub-array sum you need to use Kadane's algorithm for both positive and negative integers. Initialize
  maxEndingHere = 0 and then iterate to do maxEndingHere = max(number, maxEndingHere + number) 
  maxEndingSoFar = max(maxEndingHere, maxEndingSoFar)
* To find maximum circular sub-array you need to find max(maxNormalSubarray, maxCircularSubarray). To find 
  maxCircularSubarray, you need to find totalSum - minCircularSubarray. One edge case would be if all integers are 
  negative. In that case, maxNormalSubarray will be negative, just return that value.
* For finding majority element (which occurs more than n/2 times), you need to assume 0th element is majority and 
  count = 1 increment count if arr(res) == arr(i), else you can decrement the count. If count is 0, then initialize 
  res = i, count = 1.
* For minimum group flips in an array of 0s and 1s, if start and end of array is same then print any group, it will be 
  same. If start and end are different, then difference of groups will be one.
* For finding max sum of K consecutive elements, you need to use window sliding technique. For finding sum of a window,
  you can reduce the old value and add the new value to this window to get new window sum. Find the max of all sums.
* For finding subarray with given sum, you need to store all prefix sums to hashset and check at every stage if 
  prefixSum - givenSum exists or prefixSum exists. Return false after coming out of the loop.