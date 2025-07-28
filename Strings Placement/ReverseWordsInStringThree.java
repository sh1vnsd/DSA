import java.util.StringTokenizer;

class Solution {
    public String reverseWords(String s) {
        StringTokenizer tonkenizer = new StringTokenizer(s, " ");
        StringBuilder res = new StringBuilder();

        while(tonkenizer.hasMoreTokens()){
            String word = tonkenizer.nextToken();

            res.append(new StringBuilder(word).reverse());

            if(tonkenizer.hasMoreTokens()){
                res.append(" ");
            }
        }

        return res.toString();
    }
}
