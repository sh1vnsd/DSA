class Solution {
    public int f(int ind, int prev, int[][] dp, int[] nums){
        if(ind == nums.length) return 0;
        if(dp[ind][prev + 1] != -1) return dp[ind][prev];

        int len = 0 + f(ind + 1, prev, dp, nums);
        if(prev == -1 || nums[ind] > nums[prev]){
            len = Math.max(len, 1 + f(ind + 1, ind, dp, nums));
        }
        return dp[ind][prev + 1] = len;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for(var row : dp){
            Arrays.fill(row, -1);
        }
        return f(0, -1, dp, nums);
    }
}


//Tabulation
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        
        for(int ind = n - 1; ind >= 0; ind--){
            for(int prev = ind - 1; prev >= -1; prev--){
                int len = 0 + dp[ind + 1][prev + 1];
                if(prev == -1 || nums[ind] > nums[prev]){
                    len = Math.max(len, 1 + dp[ind + 1][ind + 1]);
                }
            dp[ind][prev + 1] = len; 
            }
        }
        return dp[0][-1 + 1];
    }
}



//Space Optimization
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];
        
        for(int ind = n - 1; ind >= 0; ind--){
            for(int prev = ind - 1; prev >= -1; prev--){
                int len = 0 + next[prev + 1];
                if(prev == -1 || nums[ind] > nums[prev]){
                    len = Math.max(len, 1 + next[ind + 1]);
                }
            curr[prev + 1] = len; 
            }
            next = curr;
        }
        return next[-1 + 1];
    }
}



//Another Tabulation
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;
        for(int ind = 0; ind < n; ind++){
            for(int prev = 0; prev < ind; prev++){
                if(nums[prev] < nums[ind]){
                    dp[ind] = Math.max(1 + dp[prev], dp[ind]);
                }
            }
            maxi = Math.max(maxi, dp[ind]);
        }
        return maxi;

    }
}
