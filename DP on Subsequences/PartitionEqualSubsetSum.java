class Solution {
    public Boolean isSubsetSum(int arr[], int target) {
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


    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) totalSum += nums[i];
        if(totalSum % 2 != 0) return false;

        return isSubsetSum(nums, totalSum / 2);
    }
}
