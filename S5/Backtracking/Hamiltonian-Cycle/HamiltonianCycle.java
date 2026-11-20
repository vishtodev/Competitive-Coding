import java.util.Scanner;

public class HamiltonianCycle {

    // Check whether a vertex can be added at the current path position
    static boolean isSafe(int vertex, int[][] graph, int[] path, int pos) {

        // The new vertex must be adjacent to the previously added vertex
        if (graph[path[pos - 1]][vertex] == 0) {
            return false;
        }

        // The vertex must not already be present in the path
        for (int i = 0; i < pos; i++) {
            if (path[i] == vertex) {
                return false;
            }
        }

        return true;
    }

    // Recursively build the Hamiltonian cycle using backtracking
    static boolean hamCycleUtil(int[][] graph, int[] path, int pos, int n) {

        // All vertices are included; check whether the last vertex connects to the first
        if (pos == n) {
            return graph[path[pos - 1]][path[0]] == 1;
        }

        // Try every vertex except vertex 0, which is already the starting vertex
        for (int v = 1; v < n; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;

                if (hamCycleUtil(graph, path, pos + 1, n)) {
                    return true;
                }

                // Backtrack: remove this vertex and try another candidate
                path[pos] = -1;
            }
        }

        return false;
    }

    // Initialize the path and start the recursive search
    static int[] hamCycle(int[][] graph) {
        int n = graph.length;
        int[] path = new int[n];

        for (int i = 0; i < n; i++) {
            path[i] = -1;
        }

        // Fix vertex 0 as the starting vertex
        path[0] = 0;

        if (!hamCycleUtil(graph, path, 1, n)) {
            return new int[]{-1};
        }

        return path;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter the adjacency matrix (row by row):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int[] path = hamCycle(graph);

        if (path[0] == -1) {
            System.out.println("Solution does not Exist");
        } else {
            System.out.print("Hamiltonian Cycle: ");
            for (int i = 0; i < path.length; i++) {
                System.out.print(path[i] + " -> ");
            }
            System.out.println(path[0]);
        }

        sc.close();
    }
}
