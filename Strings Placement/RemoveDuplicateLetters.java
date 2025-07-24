class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();

        StringBuilder res = new StringBuilder();

        boolean[] seen = new boolean[26];
        int[] lastIndex = new int[26];

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            lastIndex[ch - 'a'] = i;
        }

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            int idx = ch - 'a';

            if(seen[idx] == true) continue;

            while(res.length() > 0 && res.charAt(res.length() - 1) > ch && lastIndex[res.charAt(res.length() - 1) - 'a'] > i){
                seen[res.charAt(res.length() - 1) - 'a'] = false;

                res.deleteCharAt(res.length() - 1);
            }

            res.append(ch);
            seen[idx] = true;
        }

        return res.toString();
    }
}
