import java.util.Scanner;

public class OneBasedJosephus {

    // Returns the survivor's position using 1-based indexing (1 to n).
    static int josephus(int n, int k) {
        if (n == 1)
            return 1;

        return (josephus(n - 1, k) + k - 1) % n + 1;
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
            System.out.println("Survivor position (1-based): " + josephus(n, k));
        }

        sc.close();
    }
}
