public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        int left = 0;
        int right = 0;
        int zeros = 0;
        int maxLen = 0;

        while (right < arr.length) {

            // Include the current right element
            if (arr[right] == 0) {
                zeros++;
            }

            // Shrink the window while it contains more than k zeros
            while (zeros > k) {
                if (arr[left] == 0) {
                    zeros--;
                }
                left++;
            }

            // Update the maximum valid window length
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);

            right++;
        }

        System.out.println("Maximum Length: " + maxLen);
    }
}
