# Natural Sort Order

**Topic:** Sorting

## 1. Simple Natural Sort

File: NaturalSortSimple.java

Use this shorter version when each filename contains only one numeric section, such as file01.txt, file02.txt, and file10.txt.

The key code is:

    Arrays.sort(files, Comparator.comparingInt(
            s -> Integer.parseInt(s.replaceAll("\\D", ""))
    ));

- replaceAll("\\D", "") removes non-digit characters.
- Integer.parseInt() converts the remaining number into an integer.
- Comparator.comparingInt() sorts filenames by that number.

**Limitation:** This combines all digits in a filename, so it is not suitable for filenames with multiple independent number sections, such as file2part10.

## 2. General Natural Sort

File: NaturalSortExample.java

Use the Regex-based Comparator when filenames contain multiple text and number sections. It compares each text and numeric part in sequence.

## Time Complexity
O(n log n × L)

## Space Complexity
O(n)
