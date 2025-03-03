class DisjointSetUnionBySize{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSetUnionBySize(int n){
        for(int i=0; i<=n; i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int findUpar(int node){
        if(node == parent.get(node)) return node; //ultimate parent

        int ulp = findUpar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;

        for(int i=0; i<n; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSetUnionBySize ds = new DisjointSetUnionBySize(maxRow + maxCol + 1);
        HashMap<Integer, Integer> stoneNode = new HashMap<>();

        for(int i=0; i<n; i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            stoneNode.put(nodeRow, 1);
            stoneNode.put(nodeCol, 1);
        }

        int count = 0;
        for(var it : stoneNode.entrySet()){
            if(ds.findUpar(it.getKey()) == it.getKey()){
                count++;
            }
        }
        return n - count;
    }
}