class Solution {
    public int f(int i, int j, int[][] dp, char[] str1, char[] str2){
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;
        if(dp[i][j] != -1) return dp[i][j];

        if(str1[i] == str2[j]){
            return dp[i][j] = f(i - 1, j - 1, dp, str1, str2);
        }
                        //Insert                                Delete                       Replace
        return dp[i][j] = 1 + Math.min(f(i, j - 1, dp, str1, str2), Math.min(f(i - 1, j, dp, str1, str2), f(i - 1, j - 1, dp, str1, str2)));
    }
    public int minDistance(String word1, String word2) {
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];

        for(var row : dp){
            Arrays.fill(row, -1);
        }
        return f(n - 1, m - 1, dp, str1, str2);
    }
}


//Tabulation
