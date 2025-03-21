class Solution {
    public int f(int ind, int buy, int fee, int[][] dp, int[] prices){
        if(ind == prices.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];

        if(buy == 1){
            return dp[ind][buy] = Math.max(-prices[ind] + f(ind + 1, 0, fee, dp, prices),
                                                0 + f(ind + 1, 1, fee, dp, prices)); 
        }
        else{
            return dp[ind][buy] = Math.max((prices[ind] - fee) + f(ind + 1, 1, fee, dp, prices),
                                                0 + f(ind + 1, 0, fee, dp, prices));
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(var row : dp){
            Arrays.fill(row, -1);
        }
        return f(0, 1, fee, dp, prices);
    }
}


//Tabultaion
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for(int ind = n - 1; ind >= 0; ind--){
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 1){
                    dp[ind][buy] = Math.max(-prices[ind] + dp[ind + 1][0],
                                                0 + dp[ind + 1][1]);
                }
                else{
                    dp[ind][buy] = Math.max((prices[ind] - fee) + dp[ind + 1][1],
                                                0 + dp[ind + 1][0]);
                }
            }
        }
        return dp[0][1];
    }
}


//Space Optimization
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] curr = new int[2];
        for(int ind = n - 1; ind >= 0; ind--){
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 1){
                    curr[buy] = Math.max(-prices[ind] + ahead[0],
                                                0 + ahead[1]);
                }
                else{
                    curr[buy] = Math.max((prices[ind] - fee) + ahead[1],
                                                0 + ahead[0]);
                }
            }
            ahead = curr;
        }
        return ahead[1];
    }
}

