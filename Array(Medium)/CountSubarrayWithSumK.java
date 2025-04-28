class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        int prefixSum = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);

        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];

            if(mpp.containsKey(prefixSum - k)){
                cnt += mpp.get(prefixSum - k);
            }

            mpp.put(prefixSum, mpp.getOrDefault(prefixSum, 0) + 1);
        }

        return cnt;
    }
}
