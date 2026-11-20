# Hamiltonian Cycle

**Topic:** Backtracking  
**Graph representation:** Adjacency Matrix

## Problem
Determine whether an undirected graph contains a Hamiltonian Cycle: a cycle that visits every vertex exactly once and returns to the starting vertex.

## Backtracking logic
1. Fix vertex `0` as the starting vertex.
2. Try each remaining vertex at the current path position.
3. `isSafe()` checks that an edge exists from the previous vertex and that the candidate has not already been used.
4. Add a safe vertex and recursively fill the next position.
5. If the choice cannot lead to a solution, reset `path[pos] = -1` and try another vertex.
6. Once all vertices are included, check whether the last vertex has an edge back to vertex `0`.

## Important methods
- `isSafe()`: Checks adjacency and avoids repeated vertices.
- `hamCycleUtil()`: Builds the path recursively and backtracks when necessary.
- `hamCycle()`: Initializes the path with vertex `0` and starts the search.

## Time Complexity
`O(n!)`

## Space Complexity
`O(n)` auxiliary
