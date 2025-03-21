class Solution {
    public int f(int ind, int buy, int[][] dp, int[] prices){
        if(ind == n) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind] + f(ind + 1, 0, dp, prices),
                                0 + f(ind + 1, 1, dp, prices));
        }
        else{
            profit = Math.max(prices[ind] + f(ind + 1, 1, dp, prices),
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


//Tabultaion
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;
        for(int ind = n - 1; ind >= 0; ind--){
            for(int buy = 0; buy <= 1; buy++){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max(-prices[ind] + dp[ind + 1][0], 0 + dp[ind + 1][1]); 
                }
                else{
                    profit = Math.max(prices[ind] + dp[ind + 1][1], 0 + dp[ind + 1][0]);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][1];
    }
}


//Space Optimization
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] curr = new int[2];
        ahead[0] = ahead[1] = 0;
        for(int ind = n - 1; ind >= 0; ind--){
            for(int buy = 0; buy <= 1; buy++){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max(-prices[ind] + ahead[0], 0 + ahead[1]); 
                }
                else{
                    profit = Math.max(prices[ind] + ahead[1], 0 + ahead[0]);
                }
                curr[buy] = profit;
            }
            ahead = curr;
        }
        return ahead[1];
    }
}

