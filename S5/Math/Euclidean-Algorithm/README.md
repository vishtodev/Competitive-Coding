# Greatest Common Divisor (Euclidean Algorithm)

**Topic:** Math  
**Approach:** Recursion

## Problem
Find the greatest common divisor (GCD) of two numbers.

## Logic
1. If `b == 0`, return `a`.
2. Otherwise, recursively call `gcd(b, a % b)`.
3. Continue until the second argument becomes zero.

## Example
Input: `48, 18`  
Output: `6`

## Time Complexity
`O(log(min(a, b)))`

## Space Complexity
`O(log(min(a, b)))`
