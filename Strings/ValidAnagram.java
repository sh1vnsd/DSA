class Solution {
    static final int CHAR = 256;
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        int n = s.length();
        int m = t.length();

        if(n != m) return false;
        
        int[] count = new int[CHAR];

        for(int i = 0; i < n; i++){
            count[s1[i]]++;
            count[s2[i]]--;
        }
        for(int i = 0; i < CHAR; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
}

