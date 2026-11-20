# N-Queen Problem — Backtracking

**Topic:** Recursion and Backtracking

## Problem

Place `N` queens on an `N × N` chessboard so that no two queens attack each other. No two queens may share a row, column, or diagonal.

This implementation finds one valid solution.

## Optimised safety-check trick

Instead of scanning the board for every candidate cell, use three Boolean arrays:

| Array | Meaning | Index |
|---|---|---|
| `col[]` | Occupied columns | `c` |
| `diag1[]` | Main diagonals | `row - c + N - 1` |
| `diag2[]` | Anti-diagonals | `row + c` |

Why the diagonal formulas work:

- Cells on the same main diagonal have the same `row - col` value. Adding `N - 1` makes the index non-negative.
- Cells on the same anti-diagonal have the same `row + col` value.
- Both diagonal arrays need `2 * N - 1` entries.

## Backtracking approach

1. Place exactly one queen in the current row.
2. Try each column.
3. Check whether the column and both diagonals are free.
4. Mark the board and tracking arrays, then recurse to the next row.
5. If the recursive call fails, undo the placement and try the next column.
6. If `row == N`, all queens have been placed successfully.

## Example

For `N = 4`, one valid output is:

```text
0 1 0 0
0 0 0 1
1 0 0 0
0 0 1 0
```

Here, `1` represents a queen and `0` represents an empty cell.

## Complexity

- **Time:** `O(N!)` upper bound for row-by-row placement with constant-time column/diagonal checks.
- **Auxiliary space:** `O(N)` for recursion and the three tracking arrays.
- **Board storage:** `O(N²)`.

This program stops after finding the first solution; it does not enumerate all possible solutions.

## Interview memory trick

**N-Queen = 3 checks + place + recurse + undo**

- Column index: `c`
- Main diagonal: `row - c + N - 1`
- Anti-diagonal: `row + c`
