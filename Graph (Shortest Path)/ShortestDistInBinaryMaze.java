//-->GFG SOLUTION
// import java.util.*;

// class Pair {
//     int first, second, third;
//     Pair(int first, int second, int third) {
//         this.first = first;
//         this.second = second;
//         this.third = third;
//     }
// }

// class ShortestDistInBinaryMaze {
//     static int[] dRow = {-1, 0, 1, 0};
//     static int[] dCol = {0, 1, 0, -1};

//     int shortestPath(int[][] grid, int[] source, int[] destination) {
//         if (source[0] == destination[0] && source[1] == destination[1]) return 0;

//         int n = grid.length;
//         int m = grid[0].length;
//         Queue<Pair> q = new ArrayDeque<>();
//         int[][] dist = new int[n][m];

//         for (int i = 0; i < n; i++) {
//             Arrays.fill(dist[i], (int) (1e9));
//         }
//         dist[source[0]][source[1]] = 0;
//         q.add(new Pair(0, source[0], source[1]));

//         while (!q.isEmpty()) {
//             Pair it = q.poll();
//             int dis = it.first;
//             int r = it.second;
//             int c = it.third;

//             for (int i = 0; i < 4; i++) {
//                 int nRow = r + dRow[i];
//                 int nCol = c + dCol[i];

//                 if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
//                         && grid[nRow][nCol] == 1 && dis + 1 < dist[nRow][nCol]) {
//                     dist[nRow][nCol] = dis + 1;
//                     if (nRow == destination[0] && nCol == destination[1]) return dis + 1;
//                     q.add(new Pair(dis + 1, nRow, nCol));
//                 }
//             }
//         }
//         return -1;
//     }


//     public static void main(String[] args) {
//         int[][] grid = {
//             {1, 1, 1, 1},
//             {1, 0, 1, 1},
//             {1, 1, 1, 1},
//             {0, 0, 1, 1}
//         };
//         int[] source = {0, 0};       // Starting point
//         int[] destination = {3, 2}; // Ending point

//         ShortestDistInBinaryMaze solution = new ShortestDistInBinaryMaze();
//         int result = solution.shortestPath(grid, source, destination);

//         System.out.println("The shortest path length is: " + result);
//     }
// }


//Leetcode Solution

import java.util.*;

class Pair {
    int first, second, third;
    Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class ShortestDistInBinaryMaze {
    static int[] dRow = {-1, 0, 1, 0, 1, -1, -1, 1};
    static int[] dCol = {0, 1, 0, -1, 1, 1, -1, -1};

    int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int n = grid.length;
        int m = grid[0].length;

        if (n == 1 && m == 1 && grid[0][0] == 0) return 1;

        Queue<Pair> q = new ArrayDeque<>();
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) (1e9));
        }
        dist[0][0] = 0;
        q.add(new Pair(1, 0, 0));

        while (!q.isEmpty()) {
            Pair it = q.poll();
            int dis = it.first;
            int r = it.second;
            int c = it.third;

            for (int i = 0; i < 8; i++) {
                int nRow = r + dRow[i];
                int nCol = c + dCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                        && grid[nRow][nCol] == 0 && dis + 1 < dist[nRow][nCol]) {
                    dist[nRow][nCol] = dis + 1;
                    if (nRow == n - 1 && nCol == m - 1) return dis + 1;
                    q.add(new Pair(dis + 1, nRow, nCol));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 0, 0},
            {0, 1, 0, 1},
            {0, 0, 0, 1},
            {1, 1, 0, 0}
        };

        ShortestDistInBinaryMaze solution = new ShortestDistInBinaryMaze();
        int result = solution.shortestPathBinaryMatrix(grid);

        System.out.println("The shortest path in the binary matrix is: " + result);
    }
}
