class Solution {
    public int f(int ind, int target, int[] nums, int[][] dp) {
        if (ind == 0) {
            if(target == 0 && nums[0] == 0) return 2;
            if(target == 0 || nums[0] == target) return 1;
            return 0;
        }

        if (dp[ind][target] != -1) return dp[ind][target];

        int notPick = f(ind - 1, target, nums, dp);
        int pick = 0;
        if (nums[ind] <= target) pick = f(ind - 1, target - nums[ind], nums, dp);

        return dp[ind][target] = pick + notPick;
    }

    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for (var row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, target, nums, dp);
    }
    int countPartitions(int[] arr, int d) {
        // code here
        int totalSum = 0;
        int n = arr.length;
        for(var it : arr) {
            totalSum += it;
        }
        if(totalSum - d < 0 || (totalSum - d) % 2 != 0) return 0;
        return perfectSum(arr, (totalSum - d) / 2);

    }
}

//Tabulation
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        // Base case: Empty subset always exists for sum = 0
        dp[0][0] = 1;

        // Special case for the first element
        if (nums[0] == 0) dp[0][0] = 2; // Because [ ] and [0] both count
        else if (nums[0] <= target) dp[0][nums[0]] = 1;

        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int notPick = dp[i - 1][j]; // Exclude current element
                int pick = (nums[i] <= j) ? dp[i - 1][j - nums[i]] : 0; // Include it if possible

                dp[i][j] = notPick + pick;
            }
        }

        return dp[n - 1][target];
    }


//Space Optimization
class Solution {
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[] prev = new int[target + 1];
        int[] curr = new int[target + 1];

        if(nums[0] == 0) prev[0] = 2;
        else prev[0] = 1;
        //if num[0] = 0
        if(nums[0] != 0 && nums[0] <= target) prev[nums[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int notPick = prev[j]; // Exclude current element
                int pick = (nums[i] <= j) ? prev[j - nums[i]] : 0; // Include it if possible

                curr[j] = notPick + pick;
            }
            prev = curr.clone();
        }

        return prev[target];
    }
    int countPartitions(int[] arr, int d) {
        // code here
        int totalSum = 0;
        int n = arr.length;
        for(var it : arr) {
            totalSum += it;
        }
        if(totalSum - d < 0 || (totalSum - d) % 2 != 0) return 0;
        return perfectSum(arr, (totalSum - d) / 2);

    }
}
