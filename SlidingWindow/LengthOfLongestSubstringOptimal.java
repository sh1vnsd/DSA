import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
	    char[] str = s.toCharArray();
	    int[] hash = new int[256];
	    Arrays.fill(hash, -1);
	    int n = s.length();
	    int l = 0, r = 0, maxLen = 0, len = 0;
	    while(r < n){
		    if(hash[str[r]] != -1){
			    if(hash[str[r]] >= l){
				    l = hash[str[r]] + 1;
			    }
		    }
		    len = r - l + 1;
		    maxLen = Math.max(maxLen, len);
		    hash[str[r]] = r;
		    r++;
	    }
	    return maxLen; 
    }
}
