import java.util.HashSet;

class DisjointSet {
  int[] rank;
  int[] parent;
  int[] size;

  DisjointSet(int n) {
    rank = new int[n];
    parent = new int[n];
    size = new int[n];

    for (int i = 0; i < n; i++) {
      parent[i] = i;
      size[i] = 1;
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

  public void unionBySize(int u, int v) {
    int ulpU = findUPar(u);
    int ulpV = findUPar(v);

    if (ulpU == ulpV)
      return;

    if (size[ulpU] < size[ulpV]) {
      parent[ulpU] = ulpV;
      size[ulpV] += size[ulpU];
    } else if (size[ulpV] < size[ulpU]) {
      parent[ulpV] = ulpU;
      size[ulpU] += size[ulpV];
    } else {
      parent[ulpV] = ulpU;
      size[ulpU] += size[ulpV];
    }
  }

  public int getSize(int node) {
    return size[findUPar(node)];
  }
}

class Solution {
  public int largestIsland(int[][] grid) {
    int n = grid.length;
    DisjointSet ds = new DisjointSet(n * n);

    // Connecting the components
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        if (grid[row][col] == 0)
          continue;

        int[] dRow = { -1, 0, 1, 0 };
        int[] dCol = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
          int nRow = row + dRow[i];
          int nCol = col + dCol[i];

          if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && grid[nRow][nCol] == 1) {
            int nodeNo = row * n + col;
            int adjNodeNo = nRow * n + nCol;

            ds.unionBySize(nodeNo, adjNodeNo);
          }
        }
      }
    }

    // Converting zero's to one
    int mx = 0;
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        if (grid[row][col] == 1)
          continue;

        int[] dRow = { -1, 0, 1, 0 };
        int[] dCol = { 0, 1, 0, -1 };
        HashSet<Integer> components = new HashSet<>();
        for (int i = 0; i < 4; i++) {
          int nRow = row + dRow[i];
          int nCol = col + dCol[i];

          if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < n) {
            if (grid[nRow][nCol] == 1) {
              components.add(ds.findUPar(nRow * n + nCol));
            }
          }
        }

        int sizeTotal = 1;
        for (var comp : components) {
          sizeTotal += ds.getSize(comp);
        }
        mx = Math.max(mx, sizeTotal);
      }
    }
    for (int i = 0; i < n * n; i++) {
      mx = Math.max(mx, ds.getSize(i));
    }
    return mx;
  }
}
