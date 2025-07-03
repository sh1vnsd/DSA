import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {

        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        
        for(int i = n - 1; i >= 0; i--){

            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                ans.add(-1);
            }
            else{
                ans.add(st.peek());
            }

            st.push(arr[i]);
        }

        Collections.reverse(ans);
        return ans;
    }
}
