# Karatsuba Multiplication

**Topic:** Divide and Conquer  
**Approach:** Karatsuba Algorithm

## Problem
Multiply two numbers using three recursive multiplications at each divide-and-conquer step.

## Logic
1. Return the direct product when either number is a single digit.
2. Split both numbers into two parts using a power of 10.
3. Calculate three products: `a × c`, `b × d`, and `(a + b) × (c + d)`.
4. Calculate the middle term as `z1 - z2 - z0`.
5. Combine the three results to get the product.

## Example
Input: `12 × 34`  
Output: `408`

## Time Complexity
`O(n^1.585)`

## Space Complexity
`O(log n)`
