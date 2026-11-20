import java.util.Arrays;

public class NaturalSortSimple {

    public static void main(String[] args) {

        String[] files = {
            "Files10", "Files2", "Files1", "Files20", "Files3"
        };

        Arrays.sort(files, (a, b) -> {
            int num1 = Integer.parseInt(a.replaceAll("[^0-9]", ""));
            int num2 = Integer.parseInt(b.replaceAll("[^0-9]", ""));

            return Integer.compare(num1, num2);
        });

        System.out.println(Arrays.toString(files));
    }
}
