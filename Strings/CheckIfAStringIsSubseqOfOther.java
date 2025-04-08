public class CheckIfAStringIsSubseqOfOther{
    public static void main(String[] args){
        String s1 = "ABCDE";
        String s2 = "AED";
        int n = s1.length();
        int m = s2.length();
        
        int i = 0, j = 0;

        while(i < n && j < m){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        if(j == m) System.out.println("Is a Subsequence");
        else System.out.println("Is not a Subsequence");
    }
}
