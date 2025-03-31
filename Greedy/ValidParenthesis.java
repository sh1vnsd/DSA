class Solution {
    public boolean checkValidString(String s) {
        char[] str = s.toCharArray();
        int n = str.length;

        int min = 0, max = 0;
        
        for(int i = 0; i < n; i++){
            if(str[i] == '('){
                min++;
                max++;
            }
            else if(str[i] == ')'){
                min--;
                max--;
            }
            else {
                min--;
                max++;
            }
            
            if(min < 0) min = 0;
            if(max < 0) return false;
        }
        return min == 0;
    }
}

