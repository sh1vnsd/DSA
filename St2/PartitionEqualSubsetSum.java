class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int totalSum = 0;
        for(var it : nums){
            totalSum += it;
        }

        if(totalSum % 2 != 0) return false;

        int target = totalSum / 2;

        boolean[][] dp = new boolean[n][target + 1];

        for(int i = 0; i < n; i++) dp[i][0] = true;
        if(nums[0] <= target) dp[0][nums[0]] = true;

        for(int ind = 1; ind < n; ind++){
            for(int tar = 0; tar <= target; tar++){
                boolean notTake = dp[ind - 1][tar];
                boolean take = false;

                if(nums[ind] <= tar) take = dp[ind - 1][tar - nums[ind]];

                dp[ind][tar] = (notTake || take);
            }
        }
        return dp[n - 1][target];
    }
}
