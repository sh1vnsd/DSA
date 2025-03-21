import java.util.Arrays;

class Solution {
    public int f(int ind, int buy, int cap, int[][][] dp, int[] prices){
        int n = prices.length;
        if(cap == 0) return 0;
        if(ind == n) return 0;
        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
        
        int profit = 0;
        if(buy == 1){
            return dp[ind][buy][cap] = Math.max(-prices[ind] + f(ind + 1, 0, cap, dp, prices),
                                0 + f(ind + 1, 1, cap, dp, prices));
        }
        else{
            return dp[ind][buy][cap] = Math.max(prices[ind] + f(ind + 1, 1, cap - 1, dp, prices),
                                0 + f(ind + 1, 0, cap, dp, prices));
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        for(var row : dp){
            for(var roww : row){
                Arrays.fill(roww, -1);
            }
        }
        return f(0, 1, 2, dp, prices);
    }
}


//Tabulation

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for(int ind = n - 1; ind >= 0; ind--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= 2; cap++){
                    
                    if(buy == 1){
                        dp[ind][buy][cap] = Math.max(-prices[ind] + dp[ind + 1][0][cap],
                                            0 + dp[ind + 1][1][cap]);
                    }
                    else{
                        dp[ind][buy][cap] = Math.max(prices[ind] + dp[ind + 1][1][cap - 1],
                                            0 + dp[ind + 1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}


//Space Optimization
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][3];
        int[][] curr = new int[2][3];

        for(int ind = n - 1; ind >= 0; ind--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= 2; cap++){
                    
                    if(buy == 1){
                        curr[buy][cap] = Math.max(-prices[ind] + ahead[0][cap],
                                            0 + ahead[1][cap]);
                    }
                    else{
                        curr[buy][cap] = Math.max(prices[ind] + ahead[1][cap - 1],
                                            0 + ahead[0][cap]);
                    }
                }
            }
            ahead = curr;
        }
        return ahead[1][2];
    }
}


//Another Way dp[n][4];
class Solution {
    public int f(int ind, int trans, dp, prices){
        int n = prices.length;
        if(transaction == 4) return 0;
        if(ind == n) return 0;
        if(dp[ind][transaction] != -1) return dp[ind][transaction];
        
        if(transaction % 2 == 0){
            return dp[ind][transaction] = Math.max(-prices[ind] + f(ind + 1, transaction + 1, dp, prices),
                                                    0 + f(ind + 1, transaction, dp, prices));
        }
        else{
            return dp[ind][transaction] = Math.max(prices[ind] + f(ind + 1, transaction + 1, dp, prices),
                                                    0 + f(ind + 1, transaction, dp, prices));
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        for(var row : dp){
            Arrays.fill(row, -1);
        }
        return f(0, 0, dp, prices)
    }
}


//Tabultaion
class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = -prices[0], buy2 = -prices[0];
        int sell1 = 0, sell2 = 0;
        for(int i = 1; i <prices.length; i++){
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, prices[i] + buy1);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, prices[i] + buy2);
        }
        return sell2;
    }
}
