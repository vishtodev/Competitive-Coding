class Main {

    static void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        int n = nums.length;

        k = k % n;

        // Right Rotation
        int[] right = nums.clone();

        reverseArray(right, 0, n - 1);
        reverseArray(right, 0, k - 1);
        reverseArray(right, k, n - 1);

        System.out.print("Right Rotation: ");
        for (int i = 0; i < n; i++) {
            System.out.print(right[i] + " ");
        }

        // Left Rotation
        int[] left = nums.clone();

        reverseArray(left, 0, k - 1);
        reverseArray(left, k, n - 1);
        reverseArray(left, 0, n - 1);

        System.out.print("\nLeft Rotation: ");
        for (int i = 0; i < n; i++) {
            System.out.print(left[i] + " ");
        }
    }
}
