import java.util.*;

public class NaturalSortSimple {

    public static void main(String[] args) {

        String[] files = {
            "file10.txt", "file02.txt", "file01.txt"
        };

        Arrays.sort(files, Comparator.comparingInt(
                s -> Integer.parseInt(s.replaceAll("\\D", ""))
        ));

        System.out.println(Arrays.toString(files));
    }
}
