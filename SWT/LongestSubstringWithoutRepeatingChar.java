class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        char[] str = s.toCharArray();
        int l = 0, r = 0, maxLen = 0;
        while(r < str.length){
            if(hash[str[r]] != -1){
                if(hash[str[r]] >= l){
                    l = hash[str[r]] + 1;
                }
            }
            maxLen = Math.max(maxLen, r - l + 1);
            hash[str[r]] = r;
            r++;
        }
        return maxLen;
    }
}
