class Solution {
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0, cnt = 0, maxCnt = 0;

        while(i < arr.length){
            
            if(arr[i] <= dep[j]){
                cnt++;
                i++;
            }
            else{
                cnt--;
                j++;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }
}
