class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];  
        char[] str = s.toCharArray();
        int l = 0, r = 0, maxLen = 0, maxFreq = 0;

        while (r < str.length) {
            freq[str[r] - 'A']++;
            maxFreq = Math.max(maxFreq, freq[str[r] - 'A']);

            
            if ((r - l + 1) - maxFreq <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            } else {
                freq[str[l] - 'A']--;
                l++;
            }
            
            r++;
        }
        return maxLen;
    }
}

