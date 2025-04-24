import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> mpp = new HashMap<>();
        int cnt = 0;

        for(int i = 0; i < n; i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        for(int it : mpp.keySet()){
            if(mpp.get(it) > n / 2){
                return it;
            }

            return -1;
        }
    }
}


//Morse Voting Algo
class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0, ele = 0;

        for(int i = 0; i < nums.length; i++){
            if(cnt == 0){
                cnt = 1;
                ele = nums[i];
            }
            else if(ele == nums[i]){
                cnt++;
            }
            else{
                cnt--;
            }
        }

        int cnt1 =  0;
        for(int i = 0; i < nums.length; i++){
            if(ele == nums[i]) cnt1++;
        }

        if(cnt1 > (nums.length / 2)) return ele;
        return -1;
    }
}
