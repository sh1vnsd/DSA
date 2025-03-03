public class sudoku {
    static void printGrid(int board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isValid(int board[][], int row, int col, int num) {
        // Check row
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == num) return false;
        }
        // Check column
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][col] == num) return false;
        }

        // Check 3x3 subgrid
        int newi = (row / 3) * 3;
        int newj = (col / 3) * 3;
        for (int i = newi; i < newi + 3; i++) {
            for (int j = newj; j < newj + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }

    static boolean solveSudoku(int board[][]) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) return true;
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int board[][] = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        if (solveSudoku(board)) {
            printGrid(board); // Print solved board
        } else {
            System.out.println("No solution exists");
        }
    }
}
