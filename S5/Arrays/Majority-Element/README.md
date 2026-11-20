# Majority Element

**Topic:** Arrays  
**Approach:** HashMap

## Problem
Find the element that appears strictly more than `n / 2` times in the array. If no such element exists, report that there is no majority element.

## Logic
1. Use a HashMap to count the frequency of each element.
2. Traverse the map and check whether any frequency is greater than `arr.length / 2`.
3. Print the majority element if found; otherwise, print that no majority element exists.

## Time Complexity
`O(n)` average

## Space Complexity
`O(n)`
