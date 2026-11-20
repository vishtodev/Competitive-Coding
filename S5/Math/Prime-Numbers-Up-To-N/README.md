# Prime Numbers Up to N

**Topic:** Math  
**Approach:** Simple Sieve of Eratosthenes

## Problem
Find all prime numbers from 2 up to N.

## Logic
1. Create a boolean array of size `n + 1` and initially mark every position as true.
2. Mark positions 0 and 1 as false because they are not prime.
3. For each number from 2 through `sqrt(n)), check whether it is still marked prime.
4. If it is prime, mark all its multiples starting from `i * i` as false.
5. Print all positions that remain true.

## Example
For `n = 20`, output: `2 3 5 7 11 13 17 19`

## Time Complexity
`O(n log log n)`

## Space Complexity
`O(n)`
