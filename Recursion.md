* For finding subsequences of a string, you need to use recursion which will take 2^n. Pass n and the string. Find the
  sub problem of n - 1 and string and traverse through that list. For each item you either concatenate with current
  character or you don't. Add both cases to the list and return it. If n is 0, then return an array list of one empty
  string. Note subset and subsequences are the same thing.
* For finding subset of an array, use the same approach. If you want to find the number of subsets whose sum is K,
  then you can keep adding while traversing and you can store sum of each subset. You can use DP with sum and n as two 
  variables.
* For solving tower of hanoi problem, you need to move from A to C using B as auxiliary problem with n. So first you
  call sub-problem n - 1 from A to B using C as auxiliary. Move n from A to C. Then, you call sub-problem n - 1 from B
  to C using A as auxiliary. 
* TODO Josephus problem
* For printing permutations of a problem, you need to find the permutations of the sub-problem, you need to iterate over
  all those permutations and insert current character at each place to get all permutations. This would be n