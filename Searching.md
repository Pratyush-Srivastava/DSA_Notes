* Binary search can be done in a sorted array by running a while loop of while(l <= r). Assign
  mid = low + (high - low)/2. This makes sure there is no overflow if low + high is too big. If a(mid) == num, then you
  found it, if num is greater, then update l = mid + 1, if num is smaller, then update r = mid - 1
* To count the occurrences of a number in a sorted list, then find the last occurrence - first occurrence + 1. First and
  last occurrence can be found in log(n)
* To find the square root of a number, you need to binary search with low = 1 and high = x and then check if we found
  the sqrt at each mid.
* To find a number in a rotated sorted array, note that one half will always be sorted. So find the sorted half and
  check if your number lies in that and ignore the remaining half else consider the remaining half. This will take
  log(n)
* To find the peak element (number greater than neighbors), you need to use binary search even though the array is not
  sorted. If previous element is greater than mid, then peak will be on the left side, else the peak will be on the
  right side. If a corner element is greater than just one neighbor, it will be still called a peak element. You can
  return any one peak element in this problem.
* To find a pair of elements whose sum is x in a sorted array, you can use two pointer approach. If sum of last pointer
  and first pointer is greater than x, then reduce the last pointer else increase the first pointer. keep doing this
  until you find this pair.
* To find a triplet of elements whose sum is x in a sorted array, you can consider each element part of the triplet and
  use the two pointer approach for the remaining elements. This will take O(n^2)
* To find median of two sorted arrays, you need to do binary search on smaller size sorted array. Put low1 = 0 and
  high1 = 1, while(low1 <= high1), mid1 = (low + high)/2 and mid2 = (n1 + n2 + 1)/2 - mid1. Assign mid1 to minRight1
  and calculate the rest accordingly
  maxLeft1 = (mid1 == 0) ? MIN_VALUE: a1(mid1 - 1);
  minRight1 = (mid1 == n1)? MAX_VALUE: a1(mid1);
  maxLeft2 = (mid2 == 0) ? MIN_VALUE: a2(mid2 - 1);
  minRight2 = (mid2 == n2)? MAX_VALUE: a2(mid2);
  if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1), if it is odd then take max of maxLeft1, maxLeft2. if it is even
  take average of max of both lefts and min of both rights. else if maxLeft1 > minRight2, high1 = mid1 - 1 else
  low1 = mid1 + 1. If it comes out of the loop it is not sorted.
* To minimize the maximum pages allocated to a student where every student needs to be allocated atleast one book and
  the books are to be allocated in contiguous fashion. First create a method to return the number of students needed
  with allowedMax. Note the last subArray might not get considered so add +1. Now you are ready to do binary search with
  low = max of all elements and high = totalSum. while(low<high) you can call your method with mid. If
  allowedStudents = k, then do high = mid because we need to minimize the value. if allowedStudents > k, then
  low = mid + 1, else high = mid - 1. In the end, return high. Also, if m > array size, then return -1 because few
  students won't be allocated books.