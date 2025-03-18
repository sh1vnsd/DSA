class Solution {
    public int f(int ind1, int ind2, int[][] dp, char[] str1, char[] str2){
        if(ind2 < 0) return 1;
        if(ind1 < 0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(str1[ind1] == str2[ind2]){
            return dp[ind1][ind2] = f(ind1 - 1, ind2 - 1, dp, str1, str2) + f(ind1 - 1, ind2, dp, str1, str2);
        }
            return dp[ind1][ind2] = f(ind1 - 1, ind2, dp, str1, str2);
    }
    public int numDistinct(String s, String t) {
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n][m];
        for(var row : dp){
            Arrays.fill(row, -1);
        }

        return f(n - 1, m - 1, dp, str1, str2);
    }
}

//Tabulation
class Solution {
    public int numDistinct(String s, String t) {
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++) dp[i][0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1[i - 1] == str2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else{
                dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[n][m];
    }
}

