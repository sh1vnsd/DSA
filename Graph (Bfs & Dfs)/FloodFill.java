class FloodFill {
    private static void dfs(int[][] img, int row, int col, int color, int[][] ans, int[] dRow, int[] dCol, int iniColor) {
        ans[row][col] = color;
        int n = img.length;
        int m = img[0].length;
        for (int i = 0; i < dRow.length; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                    && ans[nRow][nCol] == iniColor && ans[nRow][nCol] != color) {
                dfs(img, nRow, nCol, color, ans, dRow, dCol, iniColor);
            }
        }
    }

    public static int[][] floodFill(int[][] img, int sr, int sc, int color) {
        int iniColor = img[sr][sc];
        int[][] ans = img; // Copy of initial grid
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        dfs(img, sr, sc, color, ans, dRow, dCol, iniColor);
        return ans;
    }

    public static void main(String[] args) {
        FloodFill solution = new FloodFill();
        int[][] img = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1; // Starting row
        int sc = 1; // Starting column
        int color = 2; // New color to fill

        int[][] result = FloodFill.floodFill(img, sr, sc, color);

        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
