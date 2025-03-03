class Pair {
    int first, second, third;
    Pair(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Pair> q = new PriorityQueue<Pair>((x, y) -> x.first - y.first);

        int[][] dist = new int[n][m];
        for(int[] row : dist){
            Arrays.fill(row, (int)(1e9));
        }

        dist[0][0] = 0;
        q.add(new Pair(0, 0, 0));

        while(!q.isEmpty()){
            Pair it = q.poll();
            int diff = it.first;
            int row = it.second;
            int col = it.third;

            if(row == n-1 && col == m-1) return diff;

            for(int i=0; i<4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                int newEffort = Math.abs(heights[row][col] - heights[nRow][nCol], diff);
                if(newEffort < dist[nRow][nCol]){
                    dist[nRow][nCol] = newEffort;
                    pq.add(new Pair(newEffort, nRow, nCol));
                }
            }
        }
    }
    return 0;
}
}