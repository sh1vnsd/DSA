import java.util.*;

class RedundantConnection {
    private int[] rank;
    private int[] parent;

    public int find(int node){
        if(node == parent[node]){
            return parent[node];
        }
        return parent[node] = find(parent[node]);
    }
    
    public void unionByRank(int u, int v){
        int rootU = find(u);
        int rootV = find(v);

        if(rootU == rootV) return;

        if(rank[rootU] < rank[rootV]){
            parent[rootU] = rootV; 
        }
        else if(rank[rootV] < rank[rootU]){
            parent[rootV] = rootU;
        }
        else{
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        rank = new int[n+1];
        parent = new int[n+1];
        
        for(int i=0; i<=n; i++){
            parent[i] = i;
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(find(u) == find(v)){
                return edge;
            }
            
            unionByRank(u, v);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        
        RedundantConnection solution = new RedundantConnection();
        int[] result = solution.findRedundantConnection(edges);
        
        System.out.println("Redundant edge: " + Arrays.toString(result));
    }
}
