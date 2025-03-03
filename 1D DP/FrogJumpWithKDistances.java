//gfg (Top - Down);
class Solution {
    public int cost(int ind, int[] arr, int k, int[] dp){
        if(ind == 0) return 0;
        if(dp[ind] != -1) return dp[ind];
        int minSteps = Integer.MAX_VALUE;
        int jumps = 0;
        for(int j=1; j<=k; j++){
           if(ind - j >= 0){
               jumps = cost(ind - j, arr, k, dp) + Math.abs(arr[ind] - arr[ind - j]);
           } 
           minSteps = Math.min(jumps, minSteps);
        }
        return minSteps;
    }
    public int minimizeCost(int k, int arr[]) {
        // code here
        int[] dp = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            dp[i] = -1;
        }
        return cost(arr.length - 1, arr, k, dp);
    }
}

//Tabulation (Bottom - Up)
class Solution {
public int minimizeCost(int k, int arr[]) {
    // code here
    int[] dp = new int[arr.length];
    for(int i=0; i<arr.length; i++){
        dp[i] = -1;
    }
    dp[0] = 0;
    int jumps = 0;
    for(int i=1; i<arr.length; i++){
        int minSteps = Integer.MAX_VALUE;
        for(int j=1; j<=k; j++){
            if(i - j >= 0){
             jumps = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
            }
            minSteps = Math.min(jumps, minSteps);
        }
        dp[i] = minSteps;
    }
    return dp[arr.length - 1];
}
}

