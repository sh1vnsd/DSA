class Solution {
    public static boolean canWePlace(int[] arr, int dist, int cows){
        int cntCows = 1, last = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] - last >= dist){
                cntCows++;
                last = arr[i]; 
            }
            if(cntCows >= cows) return true;
        }
        return false;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);

        int low = 0, high = stalls[n - 1] - stalls[0];
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canWePlace(stalls, mid, k)){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
}
