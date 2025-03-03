import java.util.*;

class Pair {
    int node, distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class PrimsAlgo {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        int[] vis = new int[V];
        q.add(new Pair(0, 0));
        int sum = 0;

        while(!q.isEmpty()){
            int node = q.peek().node;
            int wt = q.peek().distance;
            q.remove();

            if(vis[node] == 1) continue; //Agar vis hai toh kuch mat kro loop aage chlao
            //If asked to give the mst edges then add here
            vis[node] = 1;
            sum += wt;

            for(int i=0; i<adj.get(node).size(); i++){
                int adjNode = adj.get(node).get(i)[0];
                int edgeWeight = adj.get(node).get(i)[1];
                
                if(vis[adjNode] == 0){
                    q.add(new Pair(adjNode, edgeWeight));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int V = 5, E = 6;

        // Create adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (node1, node2, weight)
        adj.get(0).add(new int[]{1, 2});
        adj.get(0).add(new int[]{3, 6});
        adj.get(1).add(new int[]{0, 2});
        adj.get(1).add(new int[]{2, 3});
        adj.get(1).add(new int[]{3, 8});
        adj.get(2).add(new int[]{1, 3});
        adj.get(2).add(new int[]{3, 5});
        adj.get(2).add(new int[]{4, 7});
        adj.get(3).add(new int[]{0, 6});
        adj.get(3).add(new int[]{1, 8});
        adj.get(3).add(new int[]{2, 5});
        adj.get(4).add(new int[]{2, 7});

        PrimsAlgo solution = new PrimsAlgo();
        int mstWeight = solution.spanningTree(V, E, adj);
        System.out.println("Weight of the Minimum Spanning Tree: " + mstWeight);
    }
}
