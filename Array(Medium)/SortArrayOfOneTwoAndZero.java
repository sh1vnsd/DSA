class Solution {
     public void swap(int low, int high, int[] arr){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
    public void sortColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while(mid <= high){
            if(arr[mid] == 0){
                swap(low, mid, arr);
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(mid, high, arr);
                high--;
            }
        }
    }
}

