import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
	    char[] str = s.toCharArray();
	    int maxLen = 0;
	    for(int i=0; i<s.length(); i++){
		    HashMap<Character, Boolean> map = new HashMap<>();
		    String sub = "";
		    for(int j=i; j<s.length(); j++){
			    if(map.containsKey(str[j]) == true) break;
			    sub += str[j];
			    map.put(str[j], true);
			    int len = j - i + 1;
			    maxLen = Math.max(maxLen, len);
		    }
	    }
	    return maxLen;
    }
}
