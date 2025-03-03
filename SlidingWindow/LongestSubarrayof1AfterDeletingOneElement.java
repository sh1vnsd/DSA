class Solution {
    public int longestSubarray(int[] nums) {
	    int l = 0, r = 0, maxLen = 0, zi= -1;
	    while(r < nums.length){
		    if(nums[r] == 0){
			    if(zi != -1){
				    l = zi + 1;
				    zi = r;
			    }
			    else{
				    zi = r;
			    }
		    }
		    int len = r - l + 1;
		    if(zi != -1){
			    len -= 1;
		    }
		    maxLen = Math.max(maxLen, len);
		    r++;
	    }
	    if(zi == -1){
		    return maxLen - 1;
	    }
	    return maxLen;
    }
}
