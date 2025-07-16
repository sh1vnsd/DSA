class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        if(word1.length() != word2.length()) return false;

        for(int i = 0; i < word1.length(); i++){
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);

            int idx1 = ch1 - 'a'; 
            int idx2 = ch2 - 'a';

            freq1[idx1]++;
            freq2[idx2]++;
        }

        //1st Point : - The chars in word1 should be same as chars in word2 and vice versa
        for(int i = 0; i < 26; i++){
            if(freq1[i] != 0 && freq2[i] != 0) continue;
            
            if(freq1[i] == 0 && freq2[i] == 0) continue;

            return false;
        }

        //2nd Point : - The freq should be same in both freq1 and freq2 (the order doesnt matter)

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for(int i = 0; i < 26; i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
    }
}
