* In most String/Array DP problems compare the last characters first, for better top down and bottom up approach
* In Longest Common Subsequence of two strings, for top down, we do recursion and see if s1(i) == s2(j), then
  store lcs(i)(j) = 1 + lcs(i-1)(j-1), else lcs(i)(j) = max(lcs(i-1)(j),lcs(i)(j-1)). For bottom-up, we store
  the results in 2d array lcs(n+1)(m+1), one extra row and column for base cases lcs(0)(?) = 0 and lcs(?)(0) = 0 and
  then return lcs(n)(m).
* LCS can be used in diff utility.
* LCS can be used in Minimum insertions and deletions to convert one string to another.
* LCS can be used in Shortest common super sequence to find out third string which has both string as subsequences in it
  and is shortest (find common, find missing chars of first string and then missing chars of second string in same
  order)
* LCS can be used in longest palindromic subsequence (find common between first string and reverse of first string)
* LCS can be used in longest repeating subsequence, if a subsequence repeats even once, then it is a repeating
  subsequence and you need to find the longest one (take longest common subsequence of s1 with s1, just make sure when
  characters match, they shouldnt be at the same index, else you can take max(lcs(i-1)(j),lcs(i)(j-1)))
* LCS can be used in space optimized version of LCS where you can do it in space complexity of 2 * m or 2 *n
* Printing LCS (you can create a String[][] and append the character if it matches, else take the max length string)
* Number of combinations of coins to get certain sum, we can either include a coin or not include it. So you can
  consider
  a coins array of size N, you can consider the last coin (N, sum - coins(N-1)) or ignore the last coin (N - 1, sum).
  Assuming here that we have infinity coins. Check for index negative in the case of considering the last coin.
  Remember,
  ways(i)(0) will be 1 because we have reached sum 0, even the case when n = 0. Not picking the coin with sum 0 is also
  a way.
* To find the minimum edit distance to convert from one string to another where each operation of insert, delete or
  replace
  will cost you 1 distance, you need to compare the last character of both strings and see if it is equal. If yes, you
  can
  just take the editDist(i-1, j-1), else you can take minimum of insertion (i, j-1), deletion (i - 1, j), and
  replacement
  (i - 1, j -1) and add 1 cost to it. You should also fill the base cases edit(i)(0) and edit(0)(j) in incrementing
  numbers
  because an empty string will take n characters to reach a string of length n.
* To find the longest increasing solution, you need to take an approach which is different from other dynamic solutions,
  initialize a tail array of same length as your array and also a len variable which will go as big as tail elements.
  Tail element means the last element ending with i. Initialize tail(0) = arr(0) and len = 1. Now, iterate over arr.
  If you find arr(i) > tail(len - 1), then tail(len) = arr(i) and do len++; if that condition fails, then you need to
  put
  arr(i) in the right place in the existing sorted array. To do that you need to replace ceil(arr(i)) with arr(i);
  Basically, int c = ceil(tail, 0, len -1, arr(i))
  tail(c) = arr(i); In the end return len. Note that tail will always be sorted at any point but may not contain the
  longest subsequence because we are replacing existing subsequences to save space. We just need the length. If you need
  to print, keep track of predecessors and index. This solution is (N logN) We have another solution which is N^2.
  In this solution we maintain another lis array of size N, where we store the lis(j) ending with j in arr
  We initialize lis(0) = 1 and then for lis(i), we go through all lis(j) where arr(j) <  arr(i), then we find max lis of
  all j and then assign max + 1 to lis(i). When we get all lis(i), we find max of all lis(i), that is the result. Know
  this solution even though it is N^2. This pattern might be useful.
* LIS can be used to find the minimum deletions to make the array sorted. You just need to n - lis(arr)
* LIS can be used to find the max sum increasing subsequence. Here, we use N^2 Lis solution. Instead of finding max lis
  among j such that arr(j) < arr(i) and j < i, we find max sum among j such that arr(j) < arr(i) and then assign it to
  sum(i). In the end, we find the max of all sum(i)