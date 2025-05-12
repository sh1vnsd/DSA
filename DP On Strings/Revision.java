public class Revision{
    public int lcs(int i, int j, int[][] dp, char[] str1, char[] str2){
        if(i == 0 || j == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(str1[i] == str2[j]){
            return dp[i][j] = 1 + lcs(i - 1, j - 1, dp, str1, str2);
        }
        else{
            return dp[i][j] = Math.max(lcs(i - 1, j, dp, str1, str2), lcs(i, j - 1, dp, str1, str2));
        }
    }
    public int longestPalindrome(String s){
        String rev = new StringBuilder(s).reverse().toString(); 
        char[] str1 = s.toCharArray();
        char[] str2 = rev.toCharArray();

        int n = str1.length;
        int m = str2.length;

        int[][] dp = new int[n + 1][m + 1];

        for(var row : dp){
            Arrays.fill(row, -1);
        }
        
        return lcs(n - 1, m - 1, dp, str1, str2);
    }
}
