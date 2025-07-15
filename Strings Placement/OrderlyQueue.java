class Solution {
    public String orderlyQueue(String s, int k) {


        //Simply sort and return if K > 1
        if(k > 1){
            char[] str = s.toCharArray();
            Arrays.sort(str);
            return new String(str);
        }
        else{
            String min = s;
            
            for(int i = 1; i < s.length(); i++){
                String rotated = s.substring(i) + s.substring(0, i);

                if(rotated.compareTo(min) < 0){
                    min = rotated;
                }
            }
            return min;
        }
    }
}
