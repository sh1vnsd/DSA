import java.util.ArrayDeque;
import java.util.Queue;

class Pair{
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Result {
    static final int[] dRow = {-1, 0, 1, 0};
    static final int[] dCol = {0, 1, 0, -1};

    static void bfs(int r, int c, int[][] mat, boolean[][] vis, int m, int n){
        vis[r][c] = true;
        Queue<Pair> q = new ArrayDeque<>();

        q.add(new Pair(r, c));

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int i = 0; i < 4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n
                    && vis[nRow][nCol] == false && mat[nRow][nCol] == 1){
                    vis[nRow][nCol] = true;
                    q.add(new Pair(nRow, nCol));
                    }
            }
        }
    }

  static int countIslands(int mat[][], int m, int n){
      boolean[][] vis = new boolean[m][n];

      int count = 0;
      for(int i = 0; i < m; i++){
          for(int j = 0; j < n; j++){
              if(mat[i][j] == 1 && vis[i][j] == false){
                  bfs(i, j, mat, vis, m, n);
                  count++;
              }
          }
      } 
      return count;
  }   
}
