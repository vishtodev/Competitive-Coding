# Move Hyphen to the Beginning

**Topic:** Strings  
**Approach:** In-place character array traversal

## Problem
Move all hyphens in a character array to the beginning while preserving the relative order of the other characters.

## Logic
1. Start two indices at the last position.
2. Traverse the array from right to left using `j`.
3. Copy each non-hyphen character to position `i`, then decrement `i`.
4. Fill all remaining positions at the beginning with hyphens.

## Example
Input: `Code-4-lyf`  
Output: `--Code4lyf`

## Time Complexity
`O(n)`

## Space Complexity
`O(1)`
