//testing git
class Solution {
    public int climb(int ind, int[] dp){
        if(ind == 0) return 1;
        if(ind == 1) return 1;
        if(dp[ind] != -1) return dp[ind];
        int left = climb(ind - 1, dp);
        int right = climb(ind - 2, dp);
        return dp[ind] = left + right;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climb(n, dp);
    }
}
