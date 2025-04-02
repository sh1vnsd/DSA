class Solution {
    public int minDistance(String word1, String word2) {
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();

        int n = str1.length;
        int m = str2.length;

        int[][] dp = new int[n + 1][m + 1];

        for(int j = 0; j < m; j++) dp[0][j] = 0;
        for(int i = 0; i < n; i++) dp[i][0] = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1[i - 1] == str2[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return n + m - 2 * (dp[n][m]);
    }
}
