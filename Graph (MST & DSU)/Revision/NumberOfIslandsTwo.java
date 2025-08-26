import java.util.ArrayList;

class DisjointSet {
  int[] rank;
  int[] parent;

  DisjointSet(int n) {
    rank = new int[n];
    parent = new int[n];

    for(int i = 0; i < n; i++){
      parent[i] = i;
    }
  }

  public int findUPar(int node) {
    if (node == parent[node]) {
      return node;
    }
    int ulP = findUPar(parent[node]);
    parent[node] = ulP;
    return parent[node];
  }

  public void unionByRank(int u, int v) {
    int ulpU = findUPar(u);
    int ulpV = findUPar(v);

    if (ulpU == ulpV)
      return;

    if (rank[ulpU] < rank[ulpV]) {
      parent[ulpU] = ulpV;
    } else if (rank[ulpV] < rank[ulpU]) {
      parent[ulpV] = ulpU;
    } else {
      parent[ulpV] = ulpU;
      rank[ulpU]++;
    }
  }
}

class Solution {
  public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
    DisjointSet ds = new DisjointSet(rows * cols);
    int[][] vis = new int[rows][cols];
    int cnt = 0;

    List<Integer> ans = new ArrayList<>();

    int len = operators.length;

    for (int i = 0; i < len; i++) {
      int row = operators[i][0];
      int col = operators[i][1];

      if (vis[row][col] == 1) {
        ans.add(cnt);
        continue;
      }

      vis[row][col] = 1;
      cnt++;

      int[] dRow = { -1, 0, 1, 0 };
      int[] dCol = { 0, 1, 0, -1 };

      for (int ind = 0; ind < 4; ind++) {
        int newR = row + dRow[ind];
        int newC = col + dCol[ind];

        if (newR >= 0 && newR < rows && newC >= 0 && newC < cols) {
          if (vis[newR][newC] == 1) {
            int nodeNo = row * cols + col;
            int newNodeNo = newR * cols + newC;

            if (ds.findUPar(nodeNo) != ds.findUPar(newNodeNo)) {
              cnt--;
              ds.unionByRank(nodeNo, newNodeNo);
            }
          }
        }
      }
      ans.add(cnt);
    }
    return ans;
  }
}
