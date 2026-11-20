import java.util.*;

public class LeadersInArray {

    static void findLeaders(int[] arr) {

        int n = arr.length;

        if (n == 0) {
            return;
        }

        int maxRight = arr[n - 1];

        List<Integer> leaders = new ArrayList<>();

        // The rightmost element is always a leader
        leaders.add(maxRight);

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {

            if (arr[i] > maxRight) {
                leaders.add(arr[i]);
                maxRight = arr[i];
            }
        }

        // Restore left-to-right order
        Collections.reverse(leaders);

        System.out.println(leaders);
    }

    public static void main(String[] args) {

        int[] arr = {16, 17, 4, 3, 5, 2};

        findLeaders(arr);
    }
}
