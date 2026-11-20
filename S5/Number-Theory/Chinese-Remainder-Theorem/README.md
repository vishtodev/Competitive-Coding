# Chinese Remainder Theorem (CRT) — Brute Force

**Topic:** Number Theory

## Problem

Given divisors `div[]` and corresponding remainders `rem[]`, find the smallest positive integer `x` such that:

```text
x % div[i] == rem[i]
```

for every index `i`.

## Approach

This implementation uses brute force:

1. Start with `x = 1`.
2. Check every remainder condition using `x % div[j]`.
3. If a condition fails, stop checking the current `x`.
4. If all conditions pass (`j == size`), return `x`.
5. Otherwise increment `x` and repeat.

## Java Code

See `ChineseRemainder.java`.

## Example

Input:

```java
int[] div = {3, 5, 7};
int[] rem = {2, 3, 2};
```

The conditions are:

```text
x % 3 = 2
x % 5 = 3
x % 7 = 2
```

Output:

```text
Smallest solution: 23
```

## Complexity Analysis

Let:
- `M` = the smallest positive solution found.
- `k` = number of divisor/remainder pairs.

- **Time Complexity:** `O(M × k)` — in the worst case, up to `M` candidates are tested, and each candidate checks up to `k` conditions.
- **Auxiliary Space Complexity:** `O(1)` — only a constant number of extra variables are used.

## Important Notes

- This is a simple brute-force implementation and can be slow when the smallest solution is large.
- It assumes a solution exists. If the congruences are inconsistent, this unbounded search will not terminate.
- The code uses `int`; very large solutions may require `long` and a more efficient CRT algorithm.
