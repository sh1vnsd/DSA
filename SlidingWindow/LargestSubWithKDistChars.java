import java.util.HashMap;

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        int l = 0, r = 0, maxLen = 0;
        while(r < s.length()){
            map.put(str[r], map.getOrDefault(str[r], 0) + 1);
            if(map.size() <= k){
                maxLen = Math.max(maxLen, r - l + 1);
            }
            else{
                map.put(str[l], map.get(str[l]) - 1);
                if(map.get(str[l]) == 0){
                    map.remove(str[l]);
                }
                l++;
            }
            r++;
        }
        if(map.size() < k) return -1;
        return maxLen;
    }
}
