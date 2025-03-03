import java.util.ArrayList;
import java.util.List;

class EventualSafeStates {
    public boolean dfs(int start, List<List<Integer>> adj, int[] vis, int[] pathVis, int[] check) {
        vis[start] = 1;
        pathVis[start] = 1;
        check[start] = 0;

        for (int it : adj.get(start)) {
            if (vis[it] == 0) {
                if (dfs(it, adj, vis, pathVis, check)) 
                    return true;
            } else if (pathVis[it] == 1) {
                return true;
            }
        }
        check[start] = 1;
        pathVis[start] = 0;
        return false;
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, vis, pathVis, check);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i] == 1) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    public static void main(String[] args) {
        int V = 7; // Number of vertices
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Define edges for the graph
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(0);
        adj.get(4).add(2);
        adj.get(5).add(6);

        // Create a solution instance and find eventual safe nodes
        EventualSafeStates solution = new EventualSafeStates();
        List<Integer> safeNodes = solution.eventualSafeNodes(V, adj);

        // Print the safe nodes
        System.out.println("Eventual Safe Nodes: " + safeNodes);
    }
}
