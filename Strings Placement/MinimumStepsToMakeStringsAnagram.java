class Solution {
    public int minSteps(String s, String t) {
        int n = s.length();

        int[] freq = new int[26];

        for(int i = 0; i < n; i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        int res = 0;

        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                res += freq[i];
            }
        }

        return res;
    }
}
