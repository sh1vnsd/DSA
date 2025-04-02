class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int n = s1.length;
        int m = s2.length;

        int[][] dp = new int[n + 1][m + 1];

        for(int j = 0; j < m; j++) dp[0][j] = 0;
        for(int i = 0; i < n; i++) dp[i][0] = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1[i - 1] == s2[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = n, j = m;

        String ans = "";

        while(i > 0 && j > 0){
            if(s1[i - 1] == s2[j - 1]){
                ans += s1[i - 1];
                i--;
                j--;
            }
            else if(dp[i - 1][j] > dp[i][j - 1]){
                ans += s1[i - 1];
                i--;
            }
            else{
                ans += s2[j - 1];
                j--;
            }
        }

        while(i > 0){
            ans += s1[i - 1];
            i--;
        }

        while(j > 0){
            ans += s2[j - 1];
            j--;
        }
        String rev = new StringBuilder(ans).reverse().toString();
        return rev;
    }
}
