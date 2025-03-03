class Solution {
    public int maxMoney(int ind, int[] dp, int[] nums){
        if(ind == 0) return nums[ind];
        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];

        int pick = nums[ind] + maxMoney(ind - 2, dp, nums);
        int notPick = 0 + maxMoney(ind - 1, dp, nums);

        return dp[ind] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxMoney(nums.length - 1, dp, nums);
    }
}

//Tabulation (Bottom - Up)
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            int take = nums[i];
            if(i > 1){
                take += dp[i - 2];
            } 
            int notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[nums.length - 1];
    }
}

//Space Opti
class Solution {
    public int rob(int[] nums) {
        int prev = nums[0], prev2 = 0;
        for(int i=1; i<nums.length; i++){
            int take = nums[i];
            if(i > 1){
                take += prev2;
            } 
            int notTake = prev;
            int curri = Math.max(take, notTake);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
}
