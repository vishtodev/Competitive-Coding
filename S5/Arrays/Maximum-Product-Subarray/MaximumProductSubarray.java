public class MaximumProductSubarray {

    public static void main(String[] args) {

        int[] arr = {2, 3, -2, 4};

        int n = arr.length;

        int pre = 1;
        int suff = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (pre == 0) {
                pre = 1;
            }

            if (suff == 0) {
                suff = 1;
            }

            pre = pre * arr[i];

            suff = suff * arr[n - i - 1];

            max = Math.max(max, Math.max(pre, suff));
        }

        System.out.println("Maximum Product: " + max);
    }
}
