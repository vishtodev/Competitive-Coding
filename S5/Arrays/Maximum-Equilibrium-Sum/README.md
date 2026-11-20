# Maximum Equilibrium Sum

**Topic:** Arrays  
**Approach:** Two nested loops

## Problem
Find the maximum sum among all equilibrium indices. An index is an equilibrium index when the sum of elements to its left equals the sum of elements to its right. The centre element is excluded from both sums.

## Logic
1. Consider each array index as a possible equilibrium index.
2. Calculate the left sum using elements before the index.
3. Calculate the right sum using elements after the index.
4. If both sums are equal, update the maximum equilibrium sum.
5. Report the maximum sum, or indicate that no equilibrium index exists.

## Example
Input: `[5, 1, 1, -3, 7]`  
Output: `7`

## Time Complexity
`O(n²)`

## Space Complexity
`O(1)`
