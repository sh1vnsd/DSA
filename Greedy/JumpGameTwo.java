class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0, l = 0, r = 0;
        if(nums[0] == 0 && n == 1) return 0;
        if(nums[0] == 0 && n > 1) return 0;
        while(r < n - 1){
            int farthest = 0;

            for(int i = l; i <= r; i++){
                farthest = Math.max(nums[i] + i, farthest);
            }
            jumps += 1;
            l = r + 1;
            r = farthest;
        }
        return jumps;
    }
}

