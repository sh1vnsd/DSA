class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        int sSkip = 0;
        int tSkip = 0;

        while(i >= 0 || j >= 0){

            while(i >= 0){
                if(s.charAt(i) == '#'){
                    sSkip++;
                    i--;
                }
                else if(sSkip > 0){
                    sSkip--;
                    i--;
                }
                else{
                    break;
                }
            }

            while(j >= 0){

                if(t.charAt(j) == '#'){
                    tSkip++;
                    j--;
                }
                else if(tSkip > 0){
                    tSkip--;
                    j--;
                }
                else{
                    break;
                }
            }
            char first = i < 0 ? '$' : s.charAt(i);
            char second = j < 0 ? '$' : t.charAt(j);
            
            if(first != second) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
}
