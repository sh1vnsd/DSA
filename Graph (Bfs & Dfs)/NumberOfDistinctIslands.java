import java.util.*;

class Pair {
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class NumberOfDistinctIslands {
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public void dfs(int row, int col, int[][] vis,
                    int[][] grid, ArrayList<String> vec, int row0, int col0){ //row0 and col0 are base coordinates
        vis[row][col] = 1;
        vec.add((row - row0) + "," + (col - col0)); 
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<4; i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                dfs(nRow, nCol, vis, grid, vec, row0, col0);
            }
        }
    }

    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> st = new HashSet<>(); 
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i, j, vis, grid, vec, i, j);
                    st.add(vec);
                }
            }
        }
        return st.size();
    }

    public static void main(String[] args) {
        NumberOfDistinctIslands solution = new NumberOfDistinctIslands();

        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}
        };

        int result = solution.countDistinctIslands(grid);
        System.out.println("Number of distinct islands: " + result);
    }
}