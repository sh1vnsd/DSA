import java.util.*;
class Pair {
int distance, node;

Pair(int distance, int node) {
    this.distance = distance;
    this.node = node;
}
}
class Dijkstras {


ArrayList<Integer> dijkstra(ArrayList<ArrayList<Pair>> adj, int src) {
PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> x.distance - y.distance);
int[] dist = new int[adj.size()];
Arrays.fill(dist, (int) (1e9)); 

q.add(new Pair(0, src));
dist[src] = 0;

while (!q.isEmpty()) {
    Pair curr = q.poll();
    int currDist = curr.distance;
    int node = curr.node;

    for (Pair neighbour : adj.get(node)) {
        int adjNode = neighbour.node;
        int edgeWeight = neighbour.distance;

        if (currDist + edgeWeight < dist[adjNode]) {
            dist[adjNode] = currDist + edgeWeight;
            q.add(new Pair(dist[adjNode], adjNode));
        }
    }
}

ArrayList<Integer> result = new ArrayList<>();
for (int d : dist) {
    result.add(d);
}
return result;
}

public static void main(String[] args) {
Dijkstras obj = new Dijkstras();

ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
int V = 3; // Number of vertices

for (int i = 0; i < V; i++) {
    adj.add(new ArrayList<>());
}

// Edges: [[1, 1], [2, 6]], [[2, 3], [0, 1]], [[1, 3], [0, 6]]
adj.get(0).add(new Pair(1, 1));
adj.get(0).add(new Pair(6, 2));
adj.get(1).add(new Pair(3, 2));
adj.get(1).add(new Pair(1, 0));
adj.get(2).add(new Pair(3, 1));
adj.get(2).add(new Pair(6, 0));

int src = 2; // Source node

ArrayList<Integer> result = obj.dijkstra(adj, src);

System.out.println(result);
}
}
