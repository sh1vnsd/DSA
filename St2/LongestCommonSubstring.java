class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int n = str1.length;
        int m = str2.length;

        int[][] dp = new int[n + 1][m + 1];

        for(int j = 0; j < m; j++) dp[0][j] = 0;
        for(int i = 0; i < n; i++) dp[i][0] = 0;

        int ans = 0;

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(str1[i] == str2[j]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
