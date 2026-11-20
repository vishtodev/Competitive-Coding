public class RatMaze {

    static int N = 4;

    static boolean solveMaze(int[][] maze, int x, int y, int[][] sol) {

        // Check whether cell is safe
        if (x < 0 || x >= N || y < 0 || y >= N || maze[x][y] == 0) {
            return false;
        }

        // Destination reached
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }

        // Mark current cell
        sol[x][y] = 1;

        // Move Down
        if (solveMaze(maze, x + 1, y, sol))
            return true;

        // Move Right
        if (solveMaze(maze, x, y + 1, sol))
            return true;

        // Backtracking
        sol[x][y] = 0;

        return false;
    }

    public static void main(String[] args) {

        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        int[][] sol = new int[N][N];

        if (solveMaze(maze, 0, 0, sol)) {

            System.out.println("Solution:");

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(sol[i][j] + " ");
                }
                System.out.println();
            }

        } else {
            System.out.println("Solution doesn't exist");
        }
    }
}