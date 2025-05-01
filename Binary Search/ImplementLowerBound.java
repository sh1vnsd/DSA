class Solution {
    int lowerBound(int[] arr, int target) {
        // code here
        int n = arr.length;
        int low = 0, high = n - 1, ans = n;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(arr[mid] >= target){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return ans;
    }
}
