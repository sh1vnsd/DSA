import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = (int)(1e9 + 7);

        int n = arr.length;
        long[] left = new long[n];
        long[] right = new long[n];

        Stack<Integer> st = new Stack<>();

        // Next Smaller Element or Equal to right
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            right[i] = st.isEmpty() ? n - i : st.peek() - i;

            st.push(i);
        }

        st.clear();

        // Previous Smaller Element to left
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            left[i] = st.isEmpty() ? i + 1 : i - st.peek();

            st.push(i);
        }

        long total = 0;

        for(int i = 0; i < n; i++){
            total = (total + arr[i] * left[i] % mod * right[i] % mod) % mod;
        }

        return (int) total;
    }
}

