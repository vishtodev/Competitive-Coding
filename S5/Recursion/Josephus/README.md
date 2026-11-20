# Josephus Problem

## Problem statement

There are **n people standing in a circle**. Starting from a chosen position, we count people and eliminate every **k-th person**. Counting continues around the circle, skipping eliminated people, until only one person remains.

The goal is to find the **position of the survivor**.

This folder contains two recursive implementations of the same problem. The only difference is the numbering convention:

- **0-based:** positions are numbered from `0` to `n - 1`.
- **1-based:** positions are numbered from `1` to `n`.

## Files

| File | Indexing | Base case | Recurrence |
|---|---|---|---|
| `ZeroBasedJosephus.java` | 0 to n - 1 | `J(1, k) = 0` | `J(n, k) = (J(n - 1, k) + k) % n` |
| `OneBasedJosephus.java` | 1 to n | `J(1, k) = 1` | `J(n, k) = (J(n - 1, k) + k - 1) % n + 1` |

## Understanding the recurrence

After the first person is eliminated, the remaining circle contains `n - 1` people. We solve that smaller problem recursively and then map its survivor position back to the original circle of `n` people.

### 1. 0-based version

Let `J(n, k)` represent the survivor's position when people are numbered from `0` to `n - 1`.

**Base case:** If only one person remains, that person is at position `0`.

```text
J(1, k) = 0
J(n, k) = (J(n - 1, k) + k) % n
```

The `+ k` shifts the survivor's position from the reduced circle to the original circle. Modulo `n` keeps the result within the valid range `0` to `n - 1`.

### 2. 1-based version

Let `J(n, k)` represent the survivor's position when people are numbered from `1` to `n`.

**Base case:** If only one person remains, that person is at position `1`.

```text
J(1, k) = 1
J(n, k) = (J(n - 1, k) + k - 1) % n + 1
```

The final `+ 1` converts the modulo result back to a 1-based position.

### Relationship between the versions

The two implementations describe the same survivor with different labels:

```text
1-based answer = 0-based answer + 1
0-based answer = 1-based answer - 1
```

## Example walkthrough

Take `n = 5` and `k = 2`. Number the people `1, 2, 3, 4, 5` and eliminate every second person:

1. Person 2 is eliminated.
2. Person 4 is eliminated.
3. Person 1 is eliminated.
4. Person 5 is eliminated.
5. Person 3 survives.

So:

- **1-based answer:** `3`
- **0-based answer:** `2` (the same person, numbered from zero)

Both programs should therefore produce the same survivor after converting between indexing conventions.

## How to run

Compile and run either file from this directory:

### 0-based

```bash
javac ZeroBasedJosephus.java
java ZeroBasedJosephus
```

Example input:

```text
5
2
```

Expected survivor position: `2`.

### 1-based

```bash
javac OneBasedJosephus.java
java OneBasedJosephus
```

Example input:

```text
5
2
```

Expected survivor position: `3`.

## Complexity analysis

For each call with `n > 1`, the function makes one recursive call with `n - 1`.

- **Time complexity:** `O(n)` — there are n recursive calls.
- **Auxiliary space complexity:** `O(n)` — the recursion call stack can grow to n frames.

These implementations are intended for learning recursion and the recurrence relation. Very large `n` can cause a Java `StackOverflowError` because the recursion depth is linear.

## Interview preparation: key points

1. **What is the Josephus Problem?** A circular elimination problem that asks for the last remaining person's position.
2. **Why is recursion suitable?** The problem with n people can be reduced to the same problem with n - 1 people.
3. **What is the base case?** One person remains, so the survivor's position is known.
4. **Why use modulo?** It wraps a position around the circle and keeps it in the valid index range.
5. **Why are there two formulas?** They use different indexing conventions: 0-based and 1-based.
6. **What is the complexity?** O(n) time and O(n) recursion-stack space.

**Interview tip:** First clarify whether the question expects a 0-based or 1-based answer. The survivor is the same person, but the returned index differs by one.
