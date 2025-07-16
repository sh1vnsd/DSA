class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;

        int k = strs[0].length();

        int cnt = 0;

        for(int i = 0; i < k; i++){
            for(int j = 1; j < n; j++){

                if(strs[j].charAt(i) < strs[j - 1].charAt(i)){
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}
