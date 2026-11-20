public class MaximumEquilibriumSum {

    public static void main(String[] args) {

        int[] arr = {5, 1, 1, -3, 7};

        long maxSum = Long.MIN_VALUE;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {

            long leftSum = 0;
            long rightSum = 0;

            // Calculate sum of elements to the left of index i
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }

            // Calculate sum of elements to the right of index i
            for (int j = i + 1; j < arr.length; j++) {
                rightSum += arr[j];
            }

            // The centre element arr[i] is excluded from both sums
            if (leftSum == rightSum) {
                maxSum = Math.max(maxSum, leftSum);
                found = true;
            }
        }

        if (found) {
            System.out.println("Maximum Equilibrium Sum: " + maxSum);
        } else {
            System.out.println("No Equilibrium Index");
        }
    }
}
