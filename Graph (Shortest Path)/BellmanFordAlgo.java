import java.util.Arrays;

class BellmanFordAlgo {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here


        int[] dist = new int[V];
        Arrays.fill(dist, (int)(1e8));

        dist[src] = 0;

        for(int i=0; i<V-1; i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if(dist[u] != (int)(1e8) && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Nth relaxation to check negative cycle
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if(dist[u] != (int)(1e8) && dist[u] + wt < dist[v]){
                    int[] temp = new int[1];
                    temp[0] = -1;
                    return temp;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int[][] edges = {
            {0, 1, -1},
            {0, 2, 4},
            {1, 2, 3},
            {1, 3, 2},
            {1, 4, 2},
            {3, 2, 5},
            {3, 1, 1},
            {4, 3, -3}
        };
        int src = 0; // Source vertex

        int[] result = bellmanFord(V, edges, src);

        if (result.length == 1 && result[0] == -1) {
            System.out.println("Negative weight cycle detected");
        } else {
            System.out.println("Shortest distances from source " + src + ":");
            for (int i = 0; i < result.length; i++) {
                System.out.println("Vertex " + i + ": " + result[i]);
            }
        }
    }
}
