import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(var digit : num.toCharArray()){
            while(!st.isEmpty() && k > 0 && st.peek() > digit){
                st.pop();
                k--;
            }
            st.push(digit);
        }

        while(k > 0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : st){
            sb.append(c);
        }

        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
