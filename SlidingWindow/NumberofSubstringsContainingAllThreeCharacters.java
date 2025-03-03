class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastSeen = {-1, -1, -1};
        int count = 0;
        char[] str = s.toCharArray();
        for(int i=0; i<str.length; i++){
            lastSeen[str[i] - 'a'] = i;
            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                int min = Math.min(lastSeen[0], lastSeen[1]);
                count += (1 + Math.min(min, lastSeen[2]));
            }
        }
        return count;
    }
}
