public class EuclideanAlgorithm {

    static int gcd(int a, int b) {

        // Base condition
        if (b == 0) {
            return a;
        }

        // Recursive call
        return gcd(b, a % b);
    }

    public static void main(String[] args) {

        int a = 48;
        int b = 18;

        System.out.println("GCD: " + gcd(a, b));
    }
}
