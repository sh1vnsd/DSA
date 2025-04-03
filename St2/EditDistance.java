class Solution {
    public int f(int i, int j, int[][] dp, char[] s1, char[] s2){
        if(i < 0) return j + 1;
        if(j < 0) return i + 1; 
        if(dp[i][j] != -1) return dp[i][j];
        if(s1[i] == s2[i]){
            return dp[i][j] = f(i - 1, j - 1, dp, s1, s2);
        }
        else{
            return dp[i][j] = 1 + Math.min(f(i - 1, j, dp, s1, s2), Math.min(f(i, j - 1, dp, s1, s2), f(i - 1, j - 1, dp, s1, s2))); 
        }
    }
    public int minDistance(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int n = s1.length;
        int m = s2.length;

        int[][] dp = new int[n][m];

        for(var row : dp){
            Arrays.fill(row, - 1);
        }

        return f(n - 1, m - 1, dp, s1, s2);

    }
}
