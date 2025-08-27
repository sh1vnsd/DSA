import java.util.Scanner;

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

  public int findUltimateParent(int node) {
    if (node == parent[node]) {
      return node;
    }
    int ultimateParent = findUltimateParent(parent[node]);
    parent[node] = ultimateParent;
    return parent[node];
  }

  public void unionByRank(int u, int v) {
    int ultimateU = findUltimateParent(u);
    int ultimateV = findUltimateParent(v);

    if (ultimateU == ultimateV)
      return;

    if (rank[ultimateU] < rank[ultimateV]) {
      parent[ultimateU] = ultimateV;
    } else if (rank[ultimateV] < rank[ultimateU]) {
      parent[ultimateV] = ultimateU;
    } else {
      parent[ultimateV] = ultimateU;
      rank[ultimateU]++;
    }
  }
}

public class RainWater {

  // Function to return the total number of puddles
  public static int puddleCount(DisjointSet ds, int[][] grid) {
    int n = grid.length;

    int count = 0;
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        if (grid[row][col] == 0)
          continue;
        int nodeNo = row * n + col;
        if (ds.parent[nodeNo] == nodeNo) {
          count++;
        }
      }
    }
    return count;
  }

  // Function to check if x1,y1,x2,y2 belongs to same puddle
  public static void checkSamePuddle(DisjointSet ds, int[][] grid, int row1, int col1, int row2, int col2) {
    int n = grid.length;

    if (grid[row1][col1] == 0 || grid[row2][col2] == 0)
      return;

    int nodeNo = row1 * n + col1;
    int anotherNodeNo = row2 * n + col2;

    if (ds.findUltimateParent(nodeNo) == ds.findUltimateParent(anotherNodeNo)) {
      System.out.println("(" + row1 + "," + col1 + ") and (" + row2 + "," + col2 + ") belongs to the same puddle");
    }
  }

  // Function to form puddle
  public static void check(DisjointSet ds, int[][] grid, int row, int col) {
    int n = grid.length;

    if (grid[row][col] == 1)
      return;

    grid[row][col] = 1;

    int[] dRow = { -1, 0, 1, 0 };
    int[] dCol = { 0, 1, 0, -1 };

    for (int i = 0; i < 4; i++) {
      int nRow = row + dRow[i];
      int nCol = col + dCol[i];

      if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && grid[nRow][nCol] == 1) {
        int nodeNo = row * n + col;
        int adjNodeNo = nRow * n + nCol;

        ds.unionByRank(nodeNo, adjNodeNo);
      }
    }
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int[][] grid = {
        { 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0 }
    };

    int n = grid.length;
    DisjointSet ds = new DisjointSet(n * n);

    // int[][] droplets = {
    // { 0, 0 },
    // { 0, 4 },
    // { 4, 0 },
    // { 4, 4 }
    // };
    //
    // int[][] queryGrid = {
    // { 0, 0, 0, 1 },
    // { 0, 0, 1, 0 },
    // { 0, 1, 1, 1 },
    // { 1, 0, 1, 1 },
    // { 2, 2, 2, 3 },
    // { 3, 2, 2, 3 }
    // };

    while (true) {
      System.out.println("Enter droplets: ");
      int row = sc.nextInt();
      int col = sc.nextInt();

      check(ds, grid, row, col);

      while (true) {
        System.out.println("Enter Same Puddle Check Queries or -1 to skip: ");
        int r1 = sc.nextInt();
        if (r1 == -1)
          break;

        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        checkSamePuddle(ds, grid, r1, c1, r2, c2);
      }
      int c = puddleCount(ds, grid);
      System.out.println("Total number of puddles: " + c);
    }

  }
}
