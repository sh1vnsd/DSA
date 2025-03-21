class Solution {
    public int f(int ind, int buy, int[][] dp, int[] prices){
        if(ind >= prices.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind] + f(ind + 1, 0, dp, prices),
                                0 + f(ind + 1, 1, dp, prices));
        }
        else{
            profit = Math.max(prices[ind] + f(ind + 2, 1, dp, prices),
                                0 + f(ind + 1, 0, dp, prices));
        }
        return dp[ind][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(var row : dp){
            Arrays.fill(row, -1);
        }
        return f(0, 1, dp, prices);
    }
}



//Tabulation
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        for(int ind = n - 1; ind >= 0; ind--){
            for(int buy = 0; buy <= 1; buy++){
            int profit = 0;
            if(buy == 1){
                dp[ind][buy] = Math.max(-prices[ind] + dp[ind + 1][0],
                                    0 + dp[ind + 1][1]);
            }
            else{
                dp[ind][buy] = Math.max(prices[ind] + dp[ind + 2][1],
                                    0 + dp[ind + 1][0]);
            }
            }
        }
        return dp[0][1];
    }
}
