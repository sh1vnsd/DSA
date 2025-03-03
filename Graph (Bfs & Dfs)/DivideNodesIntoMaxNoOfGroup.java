import java.util.*;

class DivideNodesIntoMaxNoOfGroup {
    private int[] color;
    private ArrayList<ArrayList<Integer>> adj;
    private int n;

    public int bfsForAllNodes(List<Integer> component) {
        int maxDepth = 0;
        for (int start : component) {
            Queue<Integer> q = new ArrayDeque<>();
            int[] depth = new int[n];
            Arrays.fill(depth, -1);
            q.add(start);
            depth[start] = 0;

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int iter : adj.get(node)) {
                    if (depth[iter] == -1) {
                        depth[iter] = 1 + depth[node];
                        maxDepth = Math.max(maxDepth, depth[iter]);
                        q.add(iter);
                    }
                }
            }
        }
        return maxDepth + 1;
    }

    public boolean isBipartite(int start, int c, List<Integer> component) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        color[start] = c;
        component.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int iter : adj.get(node)) {
                if (color[iter] == -1) {
                    color[iter] = 1 + color[node];
                    q.add(iter);
                    component.add(iter);
                } else if (color[iter] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int magnificentSets(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0] - 1, v = edges[i][1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        color = new int[n];
        Arrays.fill(color, -1);

        List<List<Integer>> components = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                List<Integer> component = new ArrayList<>();
                if (!isBipartite(i, 0, component)) {
                    return -1;
                }
                components.add(component);
            }
        }

        int total = 0;
        for (List<Integer> comp : components) {
            total += bfsForAllNodes(comp);
        }
        return total;
    }

    public static void main(String[] args) {
        DivideNodesIntoMaxNoOfGroup solution = new DivideNodesIntoMaxNoOfGroup();
        int n = 6;
        int[][] edges = { {1, 2}, {1, 4}, {1, 5}, {2, 6}, {2, 3}, {4, 6} };
        int result = solution.magnificentSets(n, edges);
        System.out.println("Result: " + result);
    }
}