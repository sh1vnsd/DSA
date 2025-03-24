import java.util.ArrayList;

class Solution {
    public int f(int i, int j, ArrayList<Integer> cutList, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int mini = (int)(1e9);
        for(int ind = i; ind <= j; ind++){
            int cost = (cutList.get(j + 1) - cutList.get(i - 1)) + f(i, ind - 1, cutList, dp) + f(ind + 1, j, cutList, dp);
            mini = Math.min(cost, mini);
        }
        return dp[i][j] = mini;
    }
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> cutList = new ArrayList<>();
        cutList.add(0);
        for(var it : cuts){
            cutList.add(it);
        }
        cutList.add(n);
        Collections.sort(cutList);

        int c = cutList.size();
        int[][] dp = new int[c][c];
        for(var row : dp){
            Arrays.fill(row, -1);
        }
        return f(1, c - 2, cutList, dp);
    }
}
