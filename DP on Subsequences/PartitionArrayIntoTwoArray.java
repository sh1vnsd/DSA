//Code 360
class Solution {
    public static int minSubsetSumDifference(int[] arr, int n) {
        int totalSum = 0;
        for(int i = 0; i < arr.length; i++){
            totalSum += arr[i];
        }
        int target = totalSum;
        boolean[][] dp = new boolean[n+1][target + 1];

        for(int i = 0; i < n; i++) dp[i][0] = true;
        if(arr[0] <= target) dp[0][arr[0]] = true;

        for(int ind = 1; ind < n; ind++) {
            for(int tar = 0; tar <= target; tar++) {

                boolean notTake = dp[ind - 1][tar];
                boolean take = false;

                if(arr[ind] <= tar) take = dp[ind - 1][tar - arr[ind]];
                dp[ind][tar] = take || notTake;
            }
        }
        //dp[n-1][col->0...totalSum];
        int mini = (int)(1e9);
        for(int s1 = 0; s1 <= totalSum / 2; s1++){
            if(dp[n - 1][s1] == true){
                mini = Math.min(mini, Math.abs( (totalSum - s1) - s1));
            }
        }
        return mini;
    }
}

