class Solution {
    public int maxProfit(int[] a) {
        int mini = a[0], profit = 0;
        for(int i = 0; i < a.length; i++){
            int cost = a[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, a[i]);
        }
        return profit;
    }
}
