import java.util.ArrayDeque;
import java.util.Queue;

class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Oil {
    static final int[] dRow = {-1, 0, 1, 0};
    static final int[] dCol = {0, 1, 0, -1};

    public static void bfs(int r, int c, int[][] grid, boolean[][] vis) {
        vis[r][c] = true;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(r, c));

        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                        vis[nRow][nCol] == false && grid[nRow][nCol] != 0) {
                    grid[nRow][nCol] = 0;
                    vis[nRow][nCol] = true;
                    q.add(new Pair(nRow, nCol));
                }
            }
        }
    }

    public static void floodFill(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == false && grid[i][j] == 0) {
                    bfs(i, j, grid, vis);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 0},
            {3, 4, 5},
            {0, 1, 1}
        };

        floodFill(grid);

        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}

