# Maximum Consecutive Ones III

**Topic:** Arrays  
**Approach:** Sliding Window

## Problem
Find the maximum length of a contiguous subarray containing at most `k` zeros.

## Logic
1. Expand the window by moving `right`; count a zero when `arr[right] == 0`.
2. While the window contains more than `k` zeros, move `left` forward and decrease the zero count when the leaving element is zero.
3. Calculate the current window length using `right - left + 1`.
4. Update `maxLen` and move `right` forward.

## Example
Input: `[1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]`, `k = 2`  
Output: `6`

## Time Complexity
`O(n)`

## Space Complexity
`O(1)`
