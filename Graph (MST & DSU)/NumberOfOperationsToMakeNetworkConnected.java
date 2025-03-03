//leetcode
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
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int size = connections.length;
        int countExtra = 0;
        DisjointSetUnion ds = new DisjointSetUnion(n);

        for(int i=0; i<size; i++){
            int u = connections[i][0];
            int v = connections[i][1];

            if(ds.findUltimateParent(u) == ds.findUltimateParent(v)){
                countExtra++;
            }
            else{
                ds.unionByRank(u, v);
            }
        }
        
        int countC = 0; //Components
        for(int i=0; i<n; i++){
            if(ds.findUltimateParent(i) == i) countC++;
        }
        if(countExtra >= countC - 1) return countC - 1;
        return -1;
    }
}