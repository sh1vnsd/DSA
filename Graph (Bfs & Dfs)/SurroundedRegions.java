import java.util.*;
class Pair {
    int first, second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class SurroundedRegions {
    private static final int[] dRow = {-1, 0, 1, 0};
    private static final int[] dCol = {0, 1, 0, -1};

    private void bfs(int ro, int co, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        grid[ro][co] = 'T';

      Queue<Pair> q = new ArrayDeque<Pair>();
        q.add(new Pair(ro, co));

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for (int i = 0; i < dRow.length; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 'O') {
                    grid[nRow][nCol] = 'T';
                    q.add(new Pair(nRow, nCol));
                }
            }
        }
    }

    public void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int row = 0; row < n; row++) {
            if (grid[row][0] == 'O') bfs(row, 0, grid); // First column
            if (grid[row][m - 1] == 'O') bfs(row, m - 1, grid); // Last column
        }

        for (int col = 0; col < m; col++) {
            if (grid[0][col] == 'O') bfs(0, col, grid); // First row
            if (grid[n - 1][col] == 'O') bfs(n - 1, col, grid); // Last row
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 'O') {
                    grid[row][col] = 'X';
                } else if (grid[row][col] == 'T') {
                    grid[row][col] = 'O';
                }
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions solution = new SurroundedRegions();

        // Example board
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'O', 'X', 'O', 'X'},
            {'X', 'X', 'X', 'X'}
        };

        // Print board before solving
        System.out.println("Before:");
        printBoard(board);

        // Solve the problem
        solution.solve(board);

        // Print board after solving
        System.out.println("\nAfter:");
        printBoard(board);
    }

    // Utility method to print the board
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
