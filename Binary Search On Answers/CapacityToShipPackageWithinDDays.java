class Solution {
    public int daysReq(int[] arr, int cap){
        int days = 1, load = 0;

        for(int i = 0; i < arr.length; i++){
            if(load + arr[i] > cap){
                days++;
                load = arr[i];
            }
            else{
                load += arr[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0], high = 0;
        for(int i = 0; i < weights.length; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        int n = weights.length;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(daysReq(weights, mid) <= days){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}
