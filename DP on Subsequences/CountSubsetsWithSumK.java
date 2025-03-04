class Solution {
    public int f(int ind, int target, int[] nums, int[][] dp) {
        if (ind == 0) {
            if (target == 0) return 1 + (nums[0] == 0 ? 1 : 0);
            return (nums[0] == target) ? 1 : 0;
        }

        if (dp[ind][target] != -1) return dp[ind][target];

        int notPick = f(ind - 1, target, nums, dp);
        int pick = 0;
        if (nums[ind] <= target) pick = f(ind - 1, target - nums[ind], nums, dp);

        return dp[ind][target] = pick + notPick;
    }

    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for (var row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, target, nums, dp);
    }
}

//Tabultaion

class Solution {
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for(int i = 0; i < n; i++) dp[i][0] = 1;
        
        if (nums[0] == 0) dp[0][0] = 2; 
        else if (nums[0] <= target) dp[0][nums[0]] = 1;

        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int notPick = dp[i - 1][j]; 
                int pick = 0;
                if(nums[i] <= j) pick = dp[i - 1][j - nums[i]];
                dp[i][j] = notPick + pick;
            }
        }

        return dp[n - 1][target];
    }
}
