import java.util.Scanner;

public class ZeroBasedJosephus {

    // Returns the survivor's position using 0-based indexing (0 to n - 1).
    static int josephus(int n, int k) {
        if (n == 1)
            return 0;

        return (josephus(n - 1, k) + k) % n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        System.out.print("Enter elimination interval: ");
        int k = sc.nextInt();

        if (n < 1 || k < 1) {
            System.out.println("Both n and k must be at least 1.");
        } else {
            System.out.println("Survivor position (0-based): " + josephus(n, k));
        }

        sc.close();
    }
}
