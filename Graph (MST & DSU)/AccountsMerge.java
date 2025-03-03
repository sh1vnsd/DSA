//GFG
class DisjointSetUnion{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSetUnion(int n){
        for(int i=0; i<n; i++){
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUltimateParent(int node){
        if(node == parent.get(node)) return node;

        int ultP = findUltimateParent(parent.get(node));
        parent.set(node, ultP);
        return parent.get(node);
    }
    public void unionByRank(int u, int v){
        int ultP_u = findUltimateParent(u);
        int ultP_v = findUltimateParent(v);

        if(ultP_u == ultP_v) return;

        if(rank.get(ultP_u) < rank.get(ultP_v)){
            parent.set(ultP_u, ultP_v);
        }
        else if(rank.get(ultP_v) < rank.get(ultP_u)){
            parent.set(ultP_v, ultP_u);
        }
        else{
            parent.set(ultP_v, ultP_u);
            int newRank = 1 + rank.get(ultP_u);
            rank.set(ultP_u, newRank);
        }
    }
}
class Solution {    
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};
    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        //Your code here
        DisjointSetUnion ds = new DisjointSetUnion(n * m);
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        int len = operators.length;
        
        for(int i=0; i<len; i++){
            int row = operators[i][0];
            int col = operators[i][1];

            if(vis[row][col] == true){
                ans.add(count);
                continue;
            }
            vis[row][col] = true;
            count++;

            for(int ind=0; ind<4; ind++){
                int nRow = row + dRow[ind];
                int nCol = col + dCol[ind];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m 
                    && vis[nRow][nCol] == true){
                    int nodeNo = row * m + col;
                    int adjNodeNo = nRow * m + nCol;
                    if(ds.findUltimateParent(nodeNo) != ds.findUltimateParent(adjNodeNo)){
                        count--;
                        ds.unionByRank(nodeNo, adjNodeNo);
                    }
                }
            }
        ans.add(count);
        }
    return ans;
    }
}
