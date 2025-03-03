public class nqueen {
    static boolean isValid(char grid[][], int row, int col) { 
        // UP
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == 'Q') return false;
        }
        // UPPER RIGHT
        for (int i = row - 1, j = col + 1; i >= 0 && j < grid.length; i--, j++) {
            if (grid[i][j] == 'Q') return false;
        }
        // UPPER LEFT
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (grid[i][j] == 'Q') return false;
        }
        return true;
    }

    static void printGrid(char grid[][]) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void placeQueen(char grid[][], int row, int n) {
        if (row >= n) {
            printGrid(grid);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(grid, row, col)) {
                grid[row][col] = 'Q';
                placeQueen(grid, row + 1, n);
                grid[row][col] = '_';
            }
        }
    }

    public static void main(String[] args) {
        char grid[][] = {
            {'_', '_', '_', '_'},
            {'_', '_', '_', '_'},
            {'_', '_', '_', '_'},
            {'_', '_', '_', '_'}
        };
        int n = grid.length;
        placeQueen(grid, 0, n);
    }
}
