# Leaders in an Array

**Topic:** Arrays  
**Approach:** Right-to-left traversal

## Problem
Find all elements that are strictly greater than every element to their right. The rightmost element is always a leader.

## Logic
1. Start with the rightmost element and store it as a leader.
2. Traverse the array from right to left.
3. If the current element is greater than `maxRight`, add it to the leaders list and update `maxRight`.
4. Reverse the list to restore left-to-right order.

## Example
Input: `[16, 17, 4, 3, 5, 2]`  
Output: `[17, 5, 2]`

## Time Complexity
`O(n)`

## Space Complexity
`O(k)`
