class Solution {
    int f(int ind, int target, int[] arr, int[][] dp, int d){
        if(ind == 0){
            if(target == 0 && arr[0] == 0) return 2;
            if(target == 0 || arr[0] == target) return 1;
            return 0;
        }
        if(dp[ind][target] != -1) return dp[ind][target];

        int notTake = f(ind - 1, target, arr, dp, d);
        int take = 0;
        if(arr[ind] <= target) take = f(ind - 1, target - arr[ind], arr, dp, d);

        dp[ind][target] = take + notTake;

        return dp[ind][target];
    }
    int countPartitions(int[] arr, int d) {
        int n = arr.length;

        int totalSum = 0;
        for(int it : arr){
            totalSum += it;
        }

        int target = (totalSum - d) / 2;

        if((totalSum - d) < 0) return 0;
        if((totalSum - d) % 2 != 0) return 0;

        int[][] dp = new int[n][target + 1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return f(n - 1, target, arr, dp, d);
    }
}
