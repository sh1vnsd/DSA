import java.util.*;

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class PrintShortestPathDijkstras {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> x.first - y.first);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) (1e9));
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        q.add(new Pair(0, 1));
        dist[1] = 0;

        while (!q.isEmpty()) {
            Pair it = q.poll();
            int node = it.second;
            int dis = it.first;

            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int edgeWeight = iter.second;

                if (dist[node] + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dist[node] + edgeWeight;
                    parent[adjNode] = node;
                    q.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if (dist[n] == (int) (1e9)) {
            path.add(-1);
        } else {
            path.add(dist[n]);
        }

        return path;
    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes
        int m = 6; // Number of edges
        int[][] edges = {
            {1, 2, 2},
            {1, 3, 4},
            {2, 3, 1},
            {2, 4, 7},
            {3, 5, 3},
            {4, 5, 1}
        };

        PrintShortestPathDijkstras solution = new PrintShortestPathDijkstras();
        List<Integer> result = solution.shortestPath(n, m, edges);
        System.out.println(result);
    }
}
