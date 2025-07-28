class Solution {
    public int countHomogenous(String s) {
        int n = s.length();
        int len = 0;
        long res = 0;
        int MOD = (int)(1e9 + 7);

        for(int i = 0; i < n; i++) {
            if(i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                len++;
            } else {
                len = 1;
            }

            res = (res + len) % MOD;
        }

        return (int)res; 
    }
}

