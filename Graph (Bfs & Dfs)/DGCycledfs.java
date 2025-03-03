import java.util.ArrayList;

class DGCycledfs {
    // Function to detect cycle in a directed graph.
    public boolean dfs(int start, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis) {
        vis[start] = 1;
        pathVis[start] = 1;

        for (int it : adj.get(start)) {
            if (vis[it] == 0) {
                if (dfs(it, adj, vis, pathVis)) {
                    return true;
                }
            } else if (pathVis[it] == 1) {
                return true;
            }
        }
        pathVis[start] = 0;
        return false;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(i, adj, vis, pathVis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Define edges for the graph
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); // Cycle: 1 -> 2 -> 3 -> 1

        // Create an instance of the class and check for a cycle
        DGCycledfs graph = new DGCycledfs();
        boolean hasCycle = graph.isCyclic(V, adj);

        // Print the result
        if (hasCycle) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}
