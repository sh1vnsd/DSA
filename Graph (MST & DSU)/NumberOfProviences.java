import java.util.ArrayList;
import java.util.List;

class DisjointSetUnion {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSetUnion(int n){
        for(int i=0; i<=n; i++){
            parent.add(i);
            rank.add(0);
        }
    }

    public int findUltimateParent(int node){
        if(node == parent.get(node)) return node;

        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int ultimateParent_u = findUltimateParent(u);
        int ultimateParent_v = findUltimateParent(v);

        if(ultimateParent_u == ultimateParent_v) return;

        if(rank.get(ultimateParent_u) < rank.get(ultimateParent_v)){
            parent.set(ultimateParent_u, ultimateParent_v);
        }
        else if(rank.get(ultimateParent_v) < rank.get(ultimateParent_u)){
            parent.set(ultimateParent_v, ultimateParent_u);
        }
        else{
            parent.set(ultimateParent_u, ultimateParent_v);
            int newRank = 1 + rank.get(ultimateParent_v);
            rank.set(ultimateParent_v, newRank);
        }
    }
}

class NumberOfProviences {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        DisjointSetUnion ds = new DisjointSetUnion(V);

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1) {
                    ds.unionByRank(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < V; i++) {
            if (ds.findUltimateParent(i) == i) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        // Create a sample adjacency matrix for testing
        int V = 3; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Sample graph (adjacency matrix)

        adj.get(0).add(1); adj.get(0).add(0); adj.get(0).add(1);
        adj.get(1).add(0); adj.get(1).add(1); adj.get(1).add(0);
        adj.get(2).add(1); adj.get(2).add(0); adj.get(2).add(1);

        // Call the function to find the number of provinces
        int result = numProvinces(adj, V);
        System.out.println("Number of provinces: " + result);
    }
}
