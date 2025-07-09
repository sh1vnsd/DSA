class Solution {
    public int sumOfDivision(int[] arr, int d){
        int n = arr.length;

        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += Math.ceil((double)(arr[i]) / (double)(d));
        }

        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int maxi = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
        }

        int low = 1, high = maxi;
        
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(sumOfDivision(nums, mid) <= threshold){
                high = mid - 1;
            }
            else{
                low = mid + 1; 
            }
        }
        return low;
    }
}
