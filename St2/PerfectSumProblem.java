class Solution {
    public int f(int ind, int target, int[] nums, int[][] dp){
        if(ind == 0){
            if(target == 0 && nums[0] == 0) return 2;
            if(target == 0 || nums[0] == target) return 1;
            return 0;
        }
        if(dp[ind][target] != -1) return dp[ind][target];

        
        int notTake = f(ind - 1, target, nums, dp);
        int take = 0;
        if(nums[ind] <= target) take = f(ind - 1, target - nums[ind], nums, dp);

        return dp[ind][target] = take + notTake;
    }
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;

        int[][] dp = new int[n][target + 1];

        for(var row : dp){
            Arrays.fill(row, -1);
        }

        return f(n - 1, target, nums, dp);
    }
}
