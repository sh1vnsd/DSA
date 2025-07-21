class Solution {
    public int largestVariance(String s) {
        int[] count = new int[26];

        for(var ch : s.toCharArray()){
            count[ch - 'a'] = 1;
        }

        int res = 0;

        for(char first = 'a'; first <= 'z'; first++){
            for(char second = 'a'; second <= 'z'; second++){

                if(count[first - 'a'] == 0 || count[second - 'a'] == 0) continue;

                int firstCount = 0; //F1
                int secondCount = 0; //F2
                
                boolean pastSecond = false;

                for(var ch : s.toCharArray()){

                    if(ch == first) firstCount++;
                    if(ch == second) secondCount++;

                    if(secondCount > 0){
                        res = Math.max(res, firstCount - secondCount);
                    }

                    else{
                        if(pastSecond == true){
                            res = Math.max(res, firstCount - 1);
                        }
                    }

                    if(secondCount > firstCount){
                        firstCount = 0;
                        secondCount = 0;
                        pastSecond = true;
                    }
                }
            }
        }

        return res;
    }
}
