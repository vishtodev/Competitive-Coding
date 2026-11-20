# Natural Sort Order

**Topic:** Sorting

Natural sorting places numeric parts of strings in numerical order instead of comparing every character lexicographically.

For example, ordinary string sorting can place `Files10` before `Files2`, while numerical-aware sorting gives:

```text
Files1
Files2
Files3
Files10
Files20
```

## 1. Simple Natural Sort

File: `NaturalSortSimple.java`

Use this short comparator when every filename contains exactly one numeric section.

```java
Arrays.sort(files, (a, b) -> {
    int num1 = Integer.parseInt(a.replaceAll("[^0-9]", ""));
    int num2 = Integer.parseInt(b.replaceAll("[^0-9]", ""));

    return Integer.compare(num1, num2);
});
```

### Understand the code

- `replaceAll("[^0-9]", "")` removes every character that is not a digit.
- `Integer.parseInt()` converts the remaining digits into an integer.
- `Integer.compare(num1, num2)` compares the extracted numbers.

### What does Integer.compare() return?

- Negative value: first number is smaller, so the first string comes before the second.
- Zero: both numbers are equal.
- Positive value: first number is larger, so the first string comes after the second.

For ascending order, compare in this order:

```java
Integer.compare(num1, num2)
```

For descending order, reverse the arguments:

```java
Integer.compare(num2, num1)
```

Prefer `Integer.compare()` over subtracting the values (`num1 - num2`), because subtraction can overflow for large integers.

**Limitation:** This simple approach assumes one numeric section per filename. It combines all digits, so it is not suitable for names with multiple independent numeric sections, such as `file2part10`.

## 2. General Natural Sort

File: `NaturalSortExample.java`

Use the regex-based comparator when filenames contain multiple text and number sections. It compares each text and numeric part in sequence.

## Complexity

For sorting `n` strings of average length `L`:

- Time: approximately `O(n log n × L)`
- Sorting space: depends on the sorting implementation; the comparator itself uses constant auxiliary space per comparison.
