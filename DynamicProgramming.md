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
  put arr(i) in the right place in the existing sorted array. To do that you need to replace ceil(arr(i)) with arr(i);
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
* LIS can be used to find the longest bitonic subsequence(first increasing and then decreasing) You need to construct
  lis array ending with i and lds array starting with i and then take the max of lis(i) + lds(i) - 1 because i was
  considered twice. For lds you just need to lis by traversing in a reverse way. This will take N^2. This can be done in
  NlogN by using tail array method. Try to modify that method to get this.
* LIS can be used in the bridges problem. If we have parallel points where 1 is opposite to 1 and 2 is opposite to 2 and
  so on. If we have pairs like (6,2),(4,3),(2,6),(1,5) where we need to construct max bridges without inter-crossing.
  First, we need to sort based on 1st value and if 1st value is same, then sort by second value. Now you can construct
  LIS based on second value. It need not be longest strictly increasing, just increasing is fine. We can do it in NLogN
* LIS can be used in the longest chain problem. We are given pairs of element (a,b) such that (a<b). (a,b) can form a
  chain with (c,d) if b < c. First we need to sort by first values and then do LIS. While comparing two pairs, compare
  b < c and then only calculate LIS. Doing this by tail method can be complicated because pairs p (5,24) q(15,28) r(
  27,40)
  Here, p > q and q > r but p < r. For n log n you need to sort second values instead of first values.
* Maximum cuts in a rod with certain allowed lengths is a problem like number of combinations of coins to get certain
  sum. At each point, we need to either consider a specific length or not consider it all. If you consider it, you need
  to add 1 to it and if you do not consider it you have to reduce that length from allowed lengths,
  Math.max(1 + maxCuts(i)(j - allowedLengths(i - 1)), maxCuts(i - 1)(j)). Also take care of results with -1. A problem
  of recursion could be of two types, one is consider that item/ not consider that item at all. Another type would be
  consider each item and reduce for all the items. Certain problems will alow only one option. If you take number of
  combinations of coins problem (1,1,2) is same as (2, 1, 1) so be careful will selecting that approach.
* Minimum coins to make a value when you are given a list of denominations. You can take both recursive approaches
  but approach of selecting each item can gives you space complexity of O(n).
  For minimumCoins(n) = Min(minimumCoins(n - den(0)) + 1, minimumCoins(n - den(1)) + 1, minimumCoins(n - den(2)) + 1...)
  Loop through all denominations and find the minimum coins. If it doesn't reach by reducing certain denominations,
  it will return Max.
* Minimum number of jumps to reach end. You are given an array of integers where a(i) represents the max jump you can
  take from i, which means you can reach max of i + a(i). You could choose to take lesser steps too.
  Minimum number of jumps can be solved by dynamic programming in O(n^2) and in greedy solution in O(n).
  If you want to solve by dynamic programming, you need to build a dynamic array in reverse because dp(n) = 0 and your
  answer will be in dp(0). For dp(n-1), you can take min of (dp(n) till arr(n - 1) values). For dp (n-2), you take min
  of dp(n -1), dp(n) ... arr(n-2) values. In this fashion you can reach dp(0). This solution will be O(n^2)
  If you want to solve by greedy algorithm, you need to have a while loop with i = 0; Go through all the possible jump
  values of arr(i), see with which value (i+j), you are farthest element a(i+j)+(i+j) will improve. We are adding index
  as well because to find the farthest we do i+a(i). Once you found the value with farthest reach, jump to that and
  update i value. keep doing this until you reach the end. This will take O(n)
* In 0-1 knapsack max value problem, we either consider an item or not consider it. If we consider it, reduce the weight
  from the total weight and also reduce that item from that list. if you dont consider it, dont reduce the weight from
  the total weight and reduce that item from that list. value(i)(j) = 
  Math.max(val(i - 1) + value(i - 1)(j - wt(i - 1), value(i - 1)(j));
* In Optimal strategy of a game, an array of integer is given, you will pick one of the corner coins such that in 
  the end you have max coins, your opponent also plays like that. You will not max of corner coins if you are exposing 
  a bigger coin for the opponent.In the case of (2, 3, 15, 7). You will pick 2, opponent will take 7, you will take 15
  opponent will take 3. For this, pass an array, starting index i, ending index j, aTurn (boolean to 
  store if it is our turn or not). Since you are filling i, j in the fashion of (0,0) ,(1,1).. first and then
  (0,1), (1,2), (2,3) and so on, we will fill the dp array such that diff = 0 till n - 1. If last turns is A, then you 
  will fill dp(i, i) with all arr(i) values else you will keep it 0 because that was B's turn. If it is A's turn, then
  take Math.max(arr(i) + maxAmount(i + 1)(j), arr(j) + maxAmount(i)(j - 1)). If it is B's turn, then dont add array
  values and now you take the min because B would have taken the max Math.min(maxAmount(i + 1)(j), maxAmount(i)(j - 1))
  Flip aTurn after you have completed an iteration of diff.
* 
  