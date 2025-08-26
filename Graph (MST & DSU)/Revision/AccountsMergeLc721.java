import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class DisjointSet {
  int[] rank;
  int[] parent;

  DisjointSet(int n) {
    rank = new int[n];
    parent = new int[n];

    for (int i = 0; i < n; i++) {
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
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    int n = accounts.size();
    DisjointSet ds = new DisjointSet(n);

    Map<String, Integer> mapMailNode = new HashMap<>();

    for (int i = 0; i < n; i++) {
      for (int j = 1; j < accounts.get(i).size(); j++) {
        String mail = accounts.get(i).get(j);
        if (mapMailNode.containsKey(mail) == false) {
          mapMailNode.put(mail, i);
        } else {
          ds.unionByRank(i, mapMailNode.get(mail));
        }
      }
    }

    ArrayList<String>[] mergedMail = new ArrayList[n];

    for (int i = 0; i < n; i++)
      mergedMail[i] = new ArrayList<>();

    for (var it : mapMailNode.entrySet()) {
      String mail = it.getKey();

      // node will always be a ultimate parent
      int node = ds.findUPar(it.getValue());

      mergedMail[node].add(mail);
    }

    List<List<String>> ans = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      // If node does not have any merged mails
      if (mergedMail[i].size() == 0)
        continue;

      Collections.sort(mergedMail[i]);

      List<String> temp = new ArrayList<>();

      temp.add(accounts.get(i).get(0));

      for (var it : mergedMail[i]) {
        temp.add(it);
      }

      ans.add(temp);
    }
    return ans;
  }
}
