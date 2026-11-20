public class GraphColoringBacktracking {
    final int V = 4; // Number of vertices

    int[][] graph = {
        {0, 1, 1, 1},
        {1, 0, 1, 0},
        {1, 1, 0, 1},
        {1, 0, 1, 0}
    };

    // Print the assigned color of every vertex
    void printSolution(int[] color) {
        System.out.println("Solution Exists: Following are the assigned colors:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " ---> Color " + color[i]);
        }
    }

    // Check whether color c can be assigned to vertex v
    boolean isSafe(int v, int[][] graph, int[] color, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && color[i] == c) {
                return false;
            }
        }
        return true;
    }

    // Recursively assign colors to the vertices
    boolean graphColoringUtil(int[][] graph, int m, int[] color, int v) {
        if (v == V) {
            return true; // All vertices have been assigned valid colors
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, color, c)) {
                color[v] = c;

                if (graphColoringUtil(graph, m, color, v + 1)) {
                    return true;
                }

                color[v] = 0; // Backtrack: reset the color assignment
            }
        }
        return false;
    }

    // Check whether the graph can be colored using m colors
    boolean graphColoring(int m) {
        int[] color = new int[V]; // Initially all vertices are unassigned (0)

        if (!graphColoringUtil(graph, m, color, 0)) {
            System.out.println("Solution does not exist for " + m + " colors");
            return false;
        }

        printSolution(color);
        return true;
    }

    // Try increasing numbers of colors until a valid coloring is found
    public static void main(String[] args) {
        GraphColoringBacktracking gc = new GraphColoringBacktracking();

        for (int m = 1; m <= gc.V; m++) {
            System.out.println("Trying with " + m + " color(s):");
            if (gc.graphColoring(m)) {
                break;
            }
        }
    }
}
