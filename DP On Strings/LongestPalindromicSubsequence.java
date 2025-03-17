class Solution {
    public int lcs(int ind1, int ind2, char[] str1, char[] str2, int n, int m, int[][] dp){
        if(ind1 < 0 || ind2 < 0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(str1[ind1] == str2[ind2]) return dp[ind1][ind2] = 1 + lcs(ind1 - 1, ind2 - 1, str1, str2, n, m, dp);
        return Math.max( lcs(ind1 - 1, ind2, str1, str2, n, m, dp), lcs(ind1, ind2 - 1, str1, str2, n, m, dp));
    }
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        char[] str1 = s.toCharArray();
        char[] str2 = rev.toCharArray();
        int n = str1.length;
        int m = str2.length;

        int[][] dp = new int[n][m];
        for(var row : dp){
            Arrays.fill(row, -1);
        }
        return lcs(n - 1, m - 1, str1, str2, n, m, dp);
    }
}


//Tabluation
class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        char[] str1 = s.toCharArray();
        char[] str2 = rev.toCharArray();
        int n = str1.length;
        int m = str2.length;

        int[][] dp = new int[n + 1][m + 1];

        for(int j = 0; j < m; j++) dp[0][j] = 0;
        for(int i = 0; i < n; i++) dp[i][0] = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1[i - 1] == str2[j - 1]) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }
}

