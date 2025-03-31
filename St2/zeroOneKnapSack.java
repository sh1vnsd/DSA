class Result
{
    static int f(int ind, int W, int[] val, int[] weight, int[][] dp){
        if(ind == 0){
            if(weight[ind] <= W) return val[ind];
            else return 0;
        }
        if(dp[ind][W] != -1) return dp[ind][W];

        int notTake = 0 + f(ind - 1, W, val, weight, dp);
        int take = 0;
        if(weight[ind] <= W) take = val[ind] + f(ind - 1, W - weight[ind], val, weight, dp);
        
        return dp[ind][W] = Math.max(notTake, take);
    }
  static int zeroOneKnapsack(int val[], int weight[], int n, int capacity){
      int[][] dp = new int[n][capacity + 1];

      for(int[] row : dp){
          Arrays.fill(row, -1);
      }

      return f(n - 1, capacity, val, weight, dp);
  }
}
