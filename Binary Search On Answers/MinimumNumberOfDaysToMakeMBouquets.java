class Solution {
    public static boolean isPossible(int[] arr, int day, int m, int k){
        int count = 0;
        int number = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= day){
                count++;
            }
            else{
                number += (count / k);
                count = 0;
            }
        }
        number += (count / k);

        if(number >= m) return true;
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        
        long val = (long) m * k;
        int mini = bloomDay[0];
        int maxi = bloomDay[0];
        int n = bloomDay.length;

        if(val > n) return -1;

        for(int i = 1; i < bloomDay.length; i++){
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }

        int low = mini, high = maxi;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isPossible(bloomDay, mid, m, k)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}

