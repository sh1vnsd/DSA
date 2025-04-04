public class PalindromeCheck {
    public static void main(String[] args) {
       String s = "abc";  

       int n = s.length();
       int i = 0, j = n - 1;

       int flag = 0;
       while(i < j){
           if(s.charAt(i) == s.charAt(j)){
               i++;
               j--;
           }
           else{
               flag = 1;
               break;
           }
       }
       if(flag == 1) {
           System.out.println("Not a palindrome");
       }
       else{
           System.out.println("Palindrome");
       }
    }
}
