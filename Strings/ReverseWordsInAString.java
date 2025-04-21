class Solution {
    void reverse(char[] str, int low, int high){
        while(low <= high){
            char temp = str[low];
            str[low] = str[high];
            str[high] = temp;
            low++;
            high--;
        }
    }
    public String reverseWords(String s) {
        int n = s.length();
        char[] str = s.toCharArray();

        int start = 0;
        for(int end = 0; end < n; end++){
            if(str[end] == ' '){
                reverse(str, start, end - 1);
                start = end + 1;
            }
        }
        reverse(str, start, n - 1);
        reverse(str, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        boolean spaceSeen = true;

        for(int i = 0; i < str.length; i++){
            if(str[i] != ' '){
                sb.append(str[i]);
                spaceSeen = false;
            }
            else if(!spaceSeen){ 
                sb.append(' ');
                spaceSeen = true;
            }
        }

        
        int len = sb.length();
        if(sb.charAt(len - 1) == ' '){
            sb.deleteCharAt(len - 1);
        }

        return sb.toString();
    }
}



