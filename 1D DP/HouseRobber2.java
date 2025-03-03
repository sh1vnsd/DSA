class Solution {
    public int helper(int[] nums, int start, int end) {
    int prev = nums[start], prev2 = 0;
    for(int i=start + 1; i <= end; i++){
        int take = nums[i];
        if(i > 1){
            take += prev2;
        } 
        int notTake = prev;
        int curri = Math.max(take, notTake);
        prev2 = prev;
        prev = curri;
    }
    return prev;
}
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        //Excluding Last and First;
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }
}
