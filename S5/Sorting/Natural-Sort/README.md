# Natural Sort Order

**Topic:** Sorting  
**Approach:** Regex-based Comparator

## Problem
Sort strings containing text and numbers in natural order. For example, `file2.txt` should come before `file10.txt`.

## Logic
1. The regex `(\\D*)(\\d*)` separates each match into a non-digit group and a digit group.
2. Compare the text groups using `compareTo()`.
3. Convert the digit groups to integers and compare their numeric values.
4. Continue through the matches; use a final string comparison when all matched parts are equal.

## Key methods
- `compare()`: Defines the natural ordering between two strings.
- `Matcher.find()`: Retrieves successive text-and-number groups.
- `Collections.sort()`: Sorts the list using `NaturalOrderComparator`.

## Time Complexity
`O(n log n × L)`

## Space Complexity
`O(n)`
