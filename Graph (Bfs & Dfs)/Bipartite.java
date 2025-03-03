import java.util.*;

class Bipartite {
    public boolean check(int start, int V, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        color[start] = 0;

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            for(int it : adj.get(node)){
                if(color[it] == -1){
                    color[it] = 1 - color[node];
                    q.add(it);
                }
            }
        }
        return true;
    }

    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] color = new int[V];
        for(int i=0; i<V; i++) color[i] = -1;

        for(int i=0; i<V; i++){
            if(color[i] == -1){
                if(check(i, V, adj, color) == false){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int V = 4; // Number of vertices
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph: Add edges
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(0);
        adj.get(0).add(3);

        Bipartite obj = new Bipartite();
        boolean result = obj.isBipartite(adj);

        if (result) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
