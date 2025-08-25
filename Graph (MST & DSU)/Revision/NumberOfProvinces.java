import java.util.ArrayList;

class DisjointSet {
  List<Integer> rank = new ArrayList<>();
  List<Integer> parent = new ArrayList<>();

  DisjointSet(int n) {
    for (int i = 0; i < n; i++) {
      rank.add(0);
      parent.add(i);
    }
  }

  public int findUPar(int node) {
    if (node == parent.get(node)) {
      return node;
    }
    int ulP = findUPar(parent.get(node));
    parent.set(node, ulP);
    return parent.get(node);
  }

  public void unionByRank(int u, int v) {
    int ulpU = findUPar(u);
    int ulpV = findUPar(v);

    if (ulpU == ulpV)
      return;

    if (rank.get(ulpU) < rank.get(ulpV)) {
      parent.set(ulpU, ulpV);
    } else if (rank.get(ulpV) < rank.get(ulpU)) {
      parent.set(ulpV, ulpU);
    } else {
      parent.set(ulpV, ulpU);
      rank.set(ulpU, rank.get(ulpU) + 1);
    }
  }
}

class Solution {
  public int findCircleNum(int[][] isConnected) {
    int V = isConnected.length;
    DisjointSet ds = new DisjointSet(V);

    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        if (isConnected[i][j] == 1) {
          ds.unionByRank(i, j);
        }
      }
    }

    int count = 0;
    for (int i = 0; i < V; i++) {
      if (ds.parent.get(i) == i)
        count++;
    }

    return count;
  }
}
