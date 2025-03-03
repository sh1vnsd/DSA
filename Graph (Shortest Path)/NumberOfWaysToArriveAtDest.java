import java.util.*;

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class NumberOfWaysToArriveAtDest {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int m = roads.length;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));
        int[] ways = new int[n];
        Arrays.fill(ways, 0);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((x, y) -> x.first - y.first);
        q.add(new Pair(0, 0));
        int mod = (int) (1e9 + 7);

        while (!q.isEmpty()) {
            Pair it = q.poll();
            int dis = it.first;
            int node = it.second;

            for (Pair adjIt : adj.get(node)) {
                int adjNode = adjIt.first;
                int edgeWeight = adjIt.second;

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    q.add(new Pair(dis + edgeWeight, adjNode));
                    ways[adjNode] = ways[node];
                } else if (dis + edgeWeight == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }



    public static void main(String[] args) {
        NumberOfWaysToArriveAtDest solution = new NumberOfWaysToArriveAtDest();
        int n = 7;
        int[][] roads = {
            {0, 6, 7},
            {0, 1, 2},
            {1, 2, 3},
            {1, 3, 3},
            {6, 3, 3},
            {3, 5, 1},
            {6, 5, 1},
            {2, 5, 1},
            {0, 4, 5},
            {4, 6, 2}
        };
        System.out.println("Number of ways to arrive at destination: " + solution.countPaths(n, roads));
    }
}
