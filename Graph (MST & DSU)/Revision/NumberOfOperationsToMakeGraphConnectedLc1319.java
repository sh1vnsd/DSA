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
  public int makeConnected(int n, int[][] connections) {
    DisjointSet ds = new DisjointSet(n);
    int countExtra = 0;
    int m = connections.length;

    for (int i = 0; i < m; i++) {
      int u = connections[i][0];
      int v = connections[i][1];
      if (ds.findUPar(u) == ds.findUPar(v)) {
        countExtra++;
      } else {
        ds.unionByRank(u, v);
      }
    }

    int compo = 0;
    for (int i = 0; i < n; i++) {
      if (ds.parent.get(i) == i) {
        compo++;
      }
    }

    int ans = compo - 1;
    if (countExtra >= ans) {
      return ans;
    } else {
      return -1;
    }
  }
}
