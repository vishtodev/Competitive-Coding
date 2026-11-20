# Maximum Product Subarray

**Topic:** Arrays  
**Approach:** Prefix and Suffix Products

## Problem
Find the maximum product of a contiguous subarray.

## Logic
1. Traverse the array from both directions using prefix and suffix products.
2. Reset a product to 1 whenever it becomes 0.
3. Update the maximum product using the current prefix and suffix products.
4. Print the maximum product.

## Example
Input: `[2, 3, -2, 4]`  
Output: `6`

## Time Complexity
`O(n)`

## Space Complexity
`O(1)`
