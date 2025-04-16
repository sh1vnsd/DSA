public class ImprovedNaivePatternForDistinct {
    public static void patSearching(String txt, String pat){
        int n = txt.length();
        int m = pat.length();

        for(int i = 0; i <= n - m; ){
            int j;
            for( j = 0; j < m; j++)
                if(pat.charAt(j) != txt.charAt(i + j))
                    break;

            if(j == m) System.out.print(i + " ");

            //First char is not matching
            if(j == 0){
                i++;
            }
            //There is a mis match after a few matches
            else{
                i = (i + j);
            }
        }
    }
    public static void main(String[] args) {
        String txt = "ABCABCD";
        String pat = "ABCD";

        patSearching(txt, pat);
    }
}
