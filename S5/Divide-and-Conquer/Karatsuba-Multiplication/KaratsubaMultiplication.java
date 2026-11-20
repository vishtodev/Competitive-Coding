public class KaratsubaMultiplication {

    static long karatsuba(long x, long y) {

        // Base condition
        if (x < 10 || y < 10) {
            return x * y;
        }

        // Find the number of digits
        int n = Math.max(
            Long.toString(x).length(),
            Long.toString(y).length()
        );

        int m = n / 2;

        // Calculate 10^m
        long power = (long) Math.pow(10, m);

        // Split both numbers
        long a = x / power;
        long b = x % power;

        long c = y / power;
        long d = y % power;

        // Three recursive multiplications
        long z2 = karatsuba(a, c);
        long z0 = karatsuba(b, d);
        long z1 = karatsuba(a + b, c + d);

        // Calculate the middle part
        long middle = z1 - z2 - z0;

        // Combine the results
        return z2 * power * power
                + middle * power
                + z0;
    }

    public static void main(String[] args) {

        long x = 12;
        long y = 34;

        System.out.println("Product: " + karatsuba(x, y));
    }
}
