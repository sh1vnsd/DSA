//gfg (Top-Down)
class Solution {
    int cost(int ind, int[] dp, int[] height){
        if(ind == 0) return 0;
        if(dp[ind] != -1) return dp[ind];
        int left = cost(ind - 1, dp, height) + Math.abs(height[ind] - height[ind-1]);
        int right = Integer.MAX_VALUE;
        if(ind > 1) right = cost(ind - 2, dp, height) + Math.abs(height[ind] - height[ind - 2]);
        return dp[ind] = Math.min(left, right);
    }
    int minCost(int[] height) {
        // code here
        int[] dp = new int[height.length];
        for(int i=0; i<height.length; i++){
            dp[i] = -1;
        }
        return cost(height.length - 1, dp, height);
    }
}

//Tabulation(Bottom - Up)
class Solution {
    int minCost(int[] height) {
        // code here
        int[] dp = new int[height.length];
        for(int i=0; i<height.length; i++){
            dp[i] = -1;
        }
        dp[0] = 0;
        for(int i=1; i<height.length; i++){
            int first = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
            int second = Integer.MAX_VALUE;
            if(i > 1) second = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            dp[i] = Math.min(first, second);
        }
        return dp[height.length - 1];
    }
}
//Space Optimized
class Solution {
    int minCost(int[] height) {
        // code here
        int prev = 0;
        int prev2 = 0;
        for(int i=1; i<height.length; i++){
            int first = prev + Math.abs(height[i] - height[i - 1]);
            int second = Integer.MAX_VALUE;
            if(i > 1) second = prev2 + Math.abs(height[i] - height[i - 2]);
            int curi = Math.min(first, second);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}

