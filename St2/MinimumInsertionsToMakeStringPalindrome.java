class Solution {
    public int minInsertions(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        char[] str1 = s.toCharArray();
        char[] str2 = rev.toCharArray();

        int n = str1.length;
        int m = str2.length;

        int[][] dp = new int[n + 1][m + 1];

        for(int j = 0; j < n; j++) dp[0][j] = 0;
        for(int i = 0; i < m; i++) dp[i][0] = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1[i - 1] == str2[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return n - dp[n][m];
    }
}
