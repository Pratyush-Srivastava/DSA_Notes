* Count digits of a number - n%10 will give you last digit and n/10 will remove the last digit. keep doing this in a
  loop.
* Reverse of a number - you can do reverse = (reverse * 10) + lastDigit. This can be done in a loop for all digits.
* Trailing zeros in Factorial - Number of zeros will be number of times 5 has come. every 5th element will give you one
  zero. Every 25th element will give you another. Every 125th element will give you another zero. so calculate that.
* GCD can be found by assigning a to remainder and b to a and then returning a. Here, b is the larger element.
* LCM * GCD = a * b
* If a number is prime or not can be found by if (n%i==0) where i ranges from 2 to Math.sqrt(n)
* For finding prime factors of a number, just iterate from 2 to sqrt(n) (i*i <= n). If n%i == 0 then have a while loop
  to consume all i and keep doing n = n/i, in this case the only things will satisfy ahead will be prime factors. Incase
  of prime numbers you need to print n as well
* For finding all divisors of a number, know that divisors exist in pairs, so you need to iterate from i = 2 to sqrt(n)
  to get all divisors
* If you need to find prime numbers less than n, then you can take an array till n and fill multiples of 2, 3, 4 (4 is
  not required because it is already marked as true). This is called sieve of eratosthenes which takes n log (log n)
* For computing power using iteration, you need to use bitwise. You are passed (base, exponent). while(exponent > 0)
  Iterate the bits. If bit is 1, then res = res * base. After if, do exponent = exponent/2 to iterate all bits.
  Do base = base * base. You will have your result in res. 