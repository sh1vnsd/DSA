class Solution {
    int maxLen(int arr[]) {
        // code here
        int n = arr.length;
        int prefixSum = 0;
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            prefixSum += arr[i];
            
            if(prefixSum == 0){
                len = Math.max(len, i + 1);
            }
            else if(map.containsKey(prefixSum)){
                len = Math.max(len, i - map.get(prefixSum));
            }
            
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, i);
            }
            
        }
        return len;
    }
}
