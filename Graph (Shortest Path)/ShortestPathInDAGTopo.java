import java.util.*;

class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class ShortestPathInDAGTopo {
    public void topoSort(int start, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st) {
        vis[start] = 1;
        for (int i = 0; i < adj.get(start).size(); i++) {
            int v = adj.get(start).get(i).first;
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }
        st.push(start);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }

        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = (int) (1e9);
        }

        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.pop();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                if (dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == (int) (1e9)) {
                dist[i] = -1; // Mark unreachable nodes as -1
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 10; // Number of vertices
        int E = 9;  // Number of edges
        int[][] edges = {
            {0, 2, 6},
            {0, 3, 7},
            {1, 4, 9},
            {2, 5, 4},
            {3, 7, -1},
            {4, 6, -2},
            {5, 6, 3},
            {6, 8, 5},
            {7, 9, 0}
        };

        ShortestPathInDAGTopo solution = new ShortestPathInDAGTopo();
        int[] result = solution.shortestPath(V, E, edges);

        System.out.println("Shortest distances from source (0):");
        for (int dist : result) {
            System.out.print(dist + " ");
        }
    }
}
