class Result
{
    static int f(int i, int j, char[] s1, char[] s2, int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1[i] == s2[j]){
            return 1 + f(i - 1, j - 1, s1, s2, dp);
        }
        else{
            return Math.max(f(i - 1, j, s1, s2, dp), f(i, j - 1, s1, s2, dp));
        }
    }
  static int longestCommonSubsequence(String str1, String str2){
      char[] s1 = str1.toCharArray();
      char[] s2 = str2.toCharArray();

      int n = s1.length;
      int m = s2.length;

      int[][] dp = new int[n][m];

      for(int[] row : dp){
          Arrays.fill(row, -1);
      }

      return f(n - 1, m - 1, s1, s2, dp);
  }
}
