import java.util.Arrays;

class Solution {
    public boolean f(int i, int j, int[][] dp, char[] str1, char[] str2){
        if(j < 0 && i < 0) return true;
        if(j < 0 && i >= 0) return false;
        if(i < 0 && j >= 0){
            for(int k = 0; k < j; k++){
                if(str1[k] != "*") return false;
            }
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j];

        if(str1[i] == str2[j] || str2[j] == "?"){
            return dp[i][j] = f(i - 1, j - 1, dp, str1, str2);
        }
        if(str2[j] == "*"){
            return dp[i][j] = f(i - 1, j, dp, str1, str2) | f(i, j - 1, dp, str1, str2);
        }
        return dp[i][j] = false;
    }
    public boolean isMatch(String s, String p) {
        char[] str1 = s.toCharArray();
        char[] str2 = p.toCharArray();
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n][m];
        for(var row : dp){
            Arrays.fill(row, -1);
        }
        return f(n - 1, m - 1, dp, str1, str2);
    }
}
