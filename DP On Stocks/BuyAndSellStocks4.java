class Solution {
    public int f(int ind, int trans, int[][] dp, int[] prices, int k){
        if(ind == prices.length || trans == k * 2) return 0;
        if(dp[ind][trans] != -1) return dp[ind][trans];

        if(trans % 2 == 0){
            return dp[ind][trans] = Math.max(-prices[ind] + f(ind + 1, trans + 1, dp, prices, k),
                                                0 + f(ind + 1, trans, dp, prices, k)); 
        }
        else {
            return dp[ind][trans] = Math.max(prices[ind] + f(ind + 1, trans + 1, dp, prices, k),
                                                0 + f(ind + 1, trans, dp, prices, k));
        }
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][k*2];

        for(var row : dp){
            Arrays.fill(row, -1);
        }
        return f(0, 0, dp, prices, k);
    }
}


//Tabulation
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][k*2 + 1];

        for(int ind = n - 1; ind >= 0; ind--){
            for(int trans = k*2 - 1; trans >= 0; trans--){
            if(trans % 2 == 0){
                 dp[ind][trans] = Math.max(-prices[ind] + dp[ind + 1][trans + 1],
                                                    0 + dp[ind + 1][trans]); 
            }
            else {
                 dp[ind][trans] = Math.max(prices[ind] + dp[ind + 1][trans + 1],
                                                    0 + dp[ind + 1][trans]);
            }
            }
        }
        return dp[0][0];
    }
}



//Space Optimization
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] after = new int[k * 2 + 1];
        int[] curr = new int[k * 2 + 1];

        for(int ind = n - 1; ind >= 0; ind--){
            for(int trans = k*2 - 1; trans >= 0; trans--){
            if(trans % 2 == 0){
                 curr[trans] = Math.max(-prices[ind] + after[trans + 1],
                                                    0 + after[trans]); 
            }
            else {
                 curr[trans] = Math.max(prices[ind] + after[trans + 1],
                                                    0 + after[trans]);
            }
            }
            after = curr;
        }
        return after[0];
    }
}

