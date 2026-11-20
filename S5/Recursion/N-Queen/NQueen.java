public class NQueen {

    static int N = 4;

    // Track occupied columns and diagonals
    static boolean[] col = new boolean[N];
    static boolean[] diag1 = new boolean[2 * N - 1];
    static boolean[] diag2 = new boolean[2 * N - 1];

    static int[][] board = new int[N][N];

    static boolean solve(int row) {

        // All queens have been placed
        if (row == N)
            return true;

        for (int c = 0; c < N; c++) {

            int d1 = row - c + N - 1;
            int d2 = row + c;

            // Check column and both diagonals
            if (!col[c] && !diag1[d1] && !diag2[d2]) {

                board[row][c] = 1;
                col[c] = diag1[d1] = diag2[d2] = true;

                if (solve(row + 1))
                    return true;

                // Backtrack: undo the placement
                board[row][c] = 0;
                col[c] = diag1[d1] = diag2[d2] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        if (solve(0)) {
            for (int[] row : board) {
                for (int x : row)
                    System.out.print(x + " ");
                System.out.println();
            }
        } else {
            System.out.println("No solution");
        }
    }
}
