class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int curr = 0;
        int res = 0;

        for(var it : bank){
            for(var count : it.toCharArray()){
                if(count == '1') curr++;
            }

            res = res + (curr * prev); 
            if(curr != 0){
                prev = curr;
                curr = 0;
            }
        }

        return res;
    }
}
