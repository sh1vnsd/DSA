import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();

        int longest = 1;

        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }

        for(var it : set){
            if(set.contains(it - 1) == false){
                int cnt = 1;
                int x = it;
                while(set.contains(x + 1)){
                    cnt++;
                    x++;
                }

                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}
