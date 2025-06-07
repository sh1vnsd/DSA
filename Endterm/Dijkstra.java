class Tuple{
    int ro, co, dist;
    Tuple(int ro, int co, int dist){
        this.ro = ro;
        this.co = co;
        this.dist = dist;
    }
}
class Result {    
    static final int[] dRow = {-1, 0, 1, 0};
    static final int[] dCol = {0, 1, 0, -1};
    static int shortestPath(int mat[][], int srcR, int srcC, int destR, int destC, int m, int n){
        if(mat[srcR][srcC] == 0 || mat[destR][destC] == 0) return -1;

        int[][] dist = new int[m][n];
        
        for(var row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[srcR][srcC] = 0;

        PriorityQueue<Tuple> q = new PriorityQueue<>((a, b)-> a.dist - b.dist);
        q.add(new Tuple(srcR, srcC, 0));

        while(!q.isEmpty()){
            int row = q.peek().ro;
            int col = q.peek().co;
            int dis = q.peek().dist;
            q.remove();

            for(int i = 0; i < 4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n
                    && mat[nRow][nCol] == 1 && dis + 1 < dist[nRow][nCol]){
                    dist[nRow][nCol] = 1 + dis;
                    if(nRow == destR && nCol == destC) return 1 + dis;
                    q.add(new Tuple(nRow, nCol, 1 + dis));
                    }
            }
        }
        return -1;
    }
}
