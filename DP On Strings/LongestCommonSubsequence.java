class Solution {
    public int lcs(int ind1, int ind2, int[][] dp, char[] str1, char[] str2){
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(str1[ind1] == str2[ind2]) return dp[ind1][ind2] = 1 + lcs(ind1 - 1, ind2 - 1, dp, str1, str2);
        return dp[ind1][ind2] = Math.max( lcs(ind1 - 1, ind2, dp, str1, str2), lcs(ind1, ind2 - 1, dp, str1, str2));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        int n = str1.length;
        int m = str2.length;

        int[][] dp = new int[n][m];
        for(var row : dp){
            Arrays.fill(row, -1);
        }
        return lcs(n - 1, m - 1, dp, str1, str2);
    }
}


//Tabulation 
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        int n = str1.length;
        int m = str2.length;
        int[][] dp = new int[n + 1][m + 1];
        
        for(int j = 0; j <= m; j++) dp[0][j] = 0;
        for(int i = 0; i <= n; i++) dp[i][0] = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1[i - 1] == str2[j - 1]) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }
}

