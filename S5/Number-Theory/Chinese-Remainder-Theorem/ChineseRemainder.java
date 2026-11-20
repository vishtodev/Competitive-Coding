public class ChineseRemainder {

    // Brute-force CRT: finds the smallest positive x
    // satisfying x % div[i] == rem[i] for every i.
    static int chineseRemainder(int size, int[] div, int[] rem) {

        int x = 1;

        while (true) {

            int j;

            for (j = 0; j < size; j++) {

                if (x % div[j] != rem[j]) {
                    break;
                }
            }

            if (j == size) {
                return x;
            }

            x++;
        }
    }

    public static void main(String[] args) {

        int[] div = {3, 5, 7};
        int[] rem = {2, 3, 2};

        int result = chineseRemainder(div.length, div, rem);

        System.out.println("Smallest solution: " + result);
    }
}
