//The code is same as Count Partition With Given difference 
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
public int findTargetSumWays(int[] nums, int target) {
    return countPartitions(nums, target);
}
}

