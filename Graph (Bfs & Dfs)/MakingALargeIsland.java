//Leetcode
class Pair {
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};
    public int bfs(int ro, int co, int[][] grid, boolean[][] vis, int island){
        vis[ro][co] = true;
        grid[ro][co] = island;
        int n = grid.length;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(ro, co));
        int size = 1;

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int i=0; i<4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n
                    && vis[nRow][nCol] == false && grid[nRow][nCol] == 1){
                    grid[nRow][nCol] = island;
                    vis[nRow][nCol] = true;
                    q.add(new Pair(nRow, nCol));
                    size++;
                }
            }
        }
        return size;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        Map<Integer, Integer> mpp = new HashMap<>(); //map to store the size of a island
        int maxSize = 0;
        int island = 2;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && vis[i][j] == false){
                    int size = bfs(i, j, grid, vis, island);
                    mpp.put(island, size);
                    maxSize = Math.max(maxSize, size);
                    island++;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    Set<Integer> neighbor = new HashSet<>();

                    int total = 1;

                    for(int k=0; k<4; k++){
                        int nRow = i + dRow[k];
                        int nCol = j + dCol[k];

                        if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n
                            && grid[nRow][nCol] != 0){
                            neighbor.add(grid[nRow][nCol]);
                        }
                    }
                    for(int id : neighbor){
                        total += mpp.get(id);
                    }
                    maxSize = Math.max(maxSize, total);
                }
            }
        }
        return maxSize;
    }
}