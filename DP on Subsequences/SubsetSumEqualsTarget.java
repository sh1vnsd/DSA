import java.util.Arrays;

class Solution {
    static boolean f(int ind, int target, int[] arr, int n, int[][] dp){
        if(target == 0) return true;
        if(ind == 0) return (arr[0] == target) ? 1 : 0;
        if(dp[ind][target] != -1) return dp[ind][target] == 1;
        
        boolean notTake = f(ind - 1, target, arr, n, dp);
        boolean take = false;
        if(arr[ind] <= target) take = f(ind - 1, target - arr[ind], arr, n, dp);

        dp[ind][target] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }
    static Boolean isSubsetSum(int arr[], int target) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n+1][target + 1];
        for(var row : dp){
            Arrays.fill(row, -1);
        }
        return f(n - 1, target, arr, n, dp);
    }
}

//Tabulation 
class Solution {

    static Boolean isSubsetSum(int arr[], int target) {
        // code here
        int n = arr.length;
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
        return dp[n-1][target];
    }
}

//Space Optimization
class Solution {

    static Boolean isSubsetSum(int arr[], int target) {
        // code here
        int n = arr.length;
        boolean[] prev = new boolean[target + 1];
        boolean[] curr = new boolean[target + 1];
        
        prev[0] = curr[0] = true;
        if(arr[0] <=target) prev[arr[0]] = true;
        
        for(int ind = 1; ind < n; ind++) {
            for(int tar = 0; tar <= target; tar++) {
                
                boolean notTake = prev[tar];
                boolean take = false;
                
                if(arr[ind] <= tar) take = prev[tar - arr[ind]];
                curr[tar] = take || notTake;
            }
            prev = curr.clone();
        }
        return prev[target];
    }
}
