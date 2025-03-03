import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, count0 = 0, count1 = 0, maxLen = 0;
        while(r < nums.length){
            if(nums[r] == 0) count0++;
            else count1++;

            while(count0 != count1 && l < r){
                if(nums[l] == 0) count0--;
                else count1--;
                left++;
            }
            if(count0 == count1){
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            }
        }
        return maxLen;
    }
}
