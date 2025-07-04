import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;

        for(int i = 0; i < n; i++){
            if(asteroids[i] > 0){
                st.push(asteroids[i]);
            }
            else{
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])){
                    st.pop();
                }

                if(!st.isEmpty() && st.peek() == Math.abs(asteroids[i])){
                    st.pop();
                }

                else if(st.isEmpty() || st.peek() < 0){
                    st.push(asteroids[i]);
                }
            }

         }
        ArrayList<Integer> a = new ArrayList<>(st);

        int[] ans = new int[a.size()];

        for(int i = 0; i < a.size(); i++){
            ans[i] = a.get(i);
        }
        return ans;
    }
}
