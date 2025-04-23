import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        int prefixSum = 0, len = 0;

        for(int i = 0; i < arr.length; i++){
            prefixSum += arr[i];

            if(prefixSum == k){
                len = Math.max(len, i + 1);
            }
            else if(mpp.containsKey(prefixSum - k)){
                len = Math.max(len, i - mpp.get(prefixSum - k));
            }

            if(!mpp.containsKey(prefixSum)){
                mpp.put(prefixSum, i );
            }
        }

        return len;
    }
}
