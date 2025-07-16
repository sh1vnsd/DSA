class Solution {
    public boolean check(String s, char start, char end){

        for(var ch : s.toCharArray()){
            if(ch < start && ch > end){
                return true;
            }
        }
        return false;
    }
    public boolean detectCapitalUse(String word) {
        
        if(check(word, 'A', 'Z') || check(word, 'a', 'z') || check(word.substring(1), 'a', 'z')){
            return true;
        }

        return false;
    }
}
