class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        
        int maxInd = 0;
        int sum = 0;
        if(nums[0] == 0 && n == 1){
            return true;
        }
        if(nums[0] == 0 && n > 1) return false;
        for(int i = 0; i < n; i++){
            if(i > maxInd) return false;
            sum = nums[i] + i;
            maxInd = Math.max(maxInd, sum);
        } 
        return true;
    }
}

