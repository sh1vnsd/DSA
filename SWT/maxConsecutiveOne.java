class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, ans = 0;  
        while(r < nums.length){
            if(nums[r] == 0){
                if(k > 0){
                    k--;
                    ans = Math.max(ans, r - l + 1);
                    r++;
                }
                else{
                    if(nums[l] == 0){
                        k++;
                    }
                    l++;
                }
            }
            else{
                ans = Math.max(ans, r - l + 1);
                r++;
            }
        }
        return ans;
    }
}
