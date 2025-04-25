import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        int maxi = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--){
            if(arr[i] > maxi){
                maxi = Math.max(maxi, arr[i]);
                ans.add(arr[i]);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}

