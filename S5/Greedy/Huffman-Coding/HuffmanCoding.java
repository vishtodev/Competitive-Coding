import java.util.PriorityQueue;
import java.util.Comparator;

class HuffmanNode {
    int frequency;
    char character;
    HuffmanNode left;
    HuffmanNode right;

    HuffmanNode(int frequency, char character) {
        this.frequency = frequency;
        this.character = character;
        this.left = null;
        this.right = null;
    }
}

class ImplementComparator implements Comparator<HuffmanNode> {
    @Override
    public int compare(HuffmanNode x, HuffmanNode y) {
        return Integer.compare(x.frequency, y.frequency);
    }
}

public class HuffmanCoding {

    public static void printCode(HuffmanNode root, String code) {
        if (root == null) {
            return;
        }

        // A leaf node represents an original character.
        if (root.left == null && root.right == null) {
            System.out.println(root.character + " : " + code);
            return;
        }

        printCode(root.left, code + "0");
        printCode(root.right, code + "1");
    }

    public static void main(String[] args) {
        char[] characters = {'A', 'B', 'C', 'D'};
        int[] frequencies = {5, 1, 6, 3};

        if (characters.length != frequencies.length || characters.length == 0) {
            throw new IllegalArgumentException("Characters and frequencies must be non-empty and have equal lengths.");
        }

        PriorityQueue<HuffmanNode> queue =
                new PriorityQueue<>(new ImplementComparator());

        for (int i = 0; i < characters.length; i++) {
            if (frequencies[i] < 0) {
                throw new IllegalArgumentException("Frequencies cannot be negative.");
            }
            queue.add(new HuffmanNode(frequencies[i], characters[i]));
        }

        // Repeatedly combine the two nodes with the lowest frequencies.
        while (queue.size() > 1) {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();

            HuffmanNode merged = new HuffmanNode(
                    left.frequency + right.frequency, '\0');
            merged.left = left;
            merged.right = right;

            queue.add(merged);
        }

        // Handle the single-character case (its code is conventionally 0).
        HuffmanNode root = queue.poll();
        if (root.left == null && root.right == null) {
            System.out.println(root.character + " : 0");
        } else {
            printCode(root, "");
        }
    }
}
