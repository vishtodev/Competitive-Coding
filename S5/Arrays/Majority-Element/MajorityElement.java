import java.util.*;

public class MajorityElement {

    public static void main(String[] args) {

        int[] arr = {2, 2, 1, 2, 3, 2, 2};

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count the frequency of each element
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        boolean found = false;

        // Check whether any element appears more than n / 2 times
        for (int num : map.keySet()) {
            if (map.get(num) > arr.length / 2) {
                System.out.println("Majority Element: " + num);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No Majority Element");
        }
    }
}
