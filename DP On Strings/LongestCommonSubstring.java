class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int[][] dp = new int[str1.length + 1][str2.length + 1];
        for(int j = 0; j < str2.length; j++) dp[0][j] = 0;
        for(int i = 0; i < str1.length; i++) dp[i][0] = 0;
        int ans = 0;

        for(int i = 1; i <= str1.length; i++){
            for(int j = 1; j <= str2.length; j++){
                if(str1[i - 1] == str2[j - 1]){
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
