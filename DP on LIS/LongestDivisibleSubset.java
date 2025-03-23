class Solution {
    public int f(int ind, int prev, int[][] dp, int[] nums){
        if(ind == nums.length) return 0;
        if(dp[ind][prev + 1] != -1) return dp[ind][prev + 1];

        int len = 0 + f(ind + 1, prev, dp, nums);
        if(prev == -1 || nums[ind] % nums[prev] == 0){
            len = Math.max(len, 1 + f(ind + 1, ind, dp, nums));
        }
        return dp[ind][prev + 1] = len;
    }
    public int largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] dp = new int[n][n + 1];

        for(var row : dp){
            Arrays.fill(row, -1);
        }
        return f(0, -1, dp, nums);
    }
} .
