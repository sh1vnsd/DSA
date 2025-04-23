class Solution {
    public void moveZeroes(int[] arr) {
        int n = arr.length;
        int ind = 0;

        for(int i = 0; i < n; i++){
            if(arr[i] != 0){
                arr[ind] = arr[i];
                ind++;
            }
        }
        
        while(ind < n){
            arr[ind] = 0;
            ind++;
        }
    }
}

