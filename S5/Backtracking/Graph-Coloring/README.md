# Graph Coloring (M-Coloring)

- **Topic:** Backtracking
- **Supporting structure:** Graph represented using an adjacency matrix

## Problem
Given an undirected graph and a number of colors `m`, determine whether every vertex can be colored using at most `m` colors such that adjacent vertices have different colors.

## Approach
1. Start with vertex 0 and an unassigned color array (`0 means unassigned).
2. Try each color from `1` to `m`.
3. Use `isSafe()` to check whether any adjacent vertex already has that color.
4. If safe, assign the color and recursively process the next vertex.
5. If a later vertex cannot be colored, reset the current vertex to `0` and try another color (**backtracking**).
6. If all vertices are colored, a valid assignment is found.

## Key methods
- `isSafe(v, graph, color, c)`: Checks whether color `c` can be assigned to vertex `v`.
- `graphColoringUtil(...)`: Recursive backtracking function.
- `graphColoring(m)`: Starts the coloring attempt with `m` colors.
- `main()`: Tries `m = 1` through `V` and stops at the first successful coloring, so this example finds the minimum number needed.

## PPT example

The graph has 4 vertices and this adjacency matrix:

```text
0 1 1 1
1 0 1 0
1 1 0 1
1 0 1 0
```

The program tries 1 color, then 2, then 3. It fails with 1 and 2 colors, and succeeds with 3:

| Vertex | Assigned color |
|---:|---:|
| 0 | 1 |
| 1 | 2 |
| 2 | 3 |
| 3 | 2 |

## Complexity
For a fixed `m`:
- **Time:** `O(V × m^V)` worst case — up to `m` choices per vertex, with an `O(V)` safety check.
- **Auxiliary space:** `O(V)` for the color array and recursion stack.
- **Graph storage:** `O(V²)` for the adjacency matrix.

## Interview note
This is the **backtracking** solution, not the separate greedy graph-coloring approach. The GFG version also solves the fixed-`m` coloring problem using backtracking, but validates a completed coloring rather than checking each proposed color with `isSafe()` before recursing.
