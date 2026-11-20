import java.util.*;

public class SimpleSieve {

    public static void main(String[] args) {

        int n = 20;

        boolean[] prime = new boolean[n + 1];

        // Initially mark all numbers as prime
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        // Mark multiples of each prime as non-prime
        for (int i = 2; i * i <= n; i++) {

            if (prime[i]) {

                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++) {

            if (prime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
