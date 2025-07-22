class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        //Start from half for bigger test cases (i.e from n / 2)
        for(int l = n / 2; l >= 1; l--){

            if(n % l == 0){
                
                //How many times to append?
                int times = n / l;

                String pattern =  s.substring(0, l);
                StringBuilder newStr = new StringBuilder();

                while(times-- > 0){
                    newStr.append(pattern);
                }

                if(newStr.toString().equals(s)){
                    return true;
                }
            }
        }

        return false;
    }
}
