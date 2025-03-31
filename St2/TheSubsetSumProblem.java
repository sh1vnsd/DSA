class Result
{
  static int subsetSum(int a[], int n, int sum){
      int[][] dp = new int[n + 1][sum + 1];

      for(int i = 0; i < n; i++) dp[i][0] = 1;
      if(a[0] <= sum) dp[0][a[0]] = 1;

      for(int i = 1; i < n; i++){
          for(int j = 1; j <= sum; j++){
              int notTake = dp[i - 1][j];
              int take = 0;
              if(a[i] <= j) take = dp[i - 1][j - a[j]];
          }
          dp[i][j] = (take | notTake);
      }
      return dp[n - 1][sum];
  }
}
