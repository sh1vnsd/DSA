public class StringObject{
    public static void main(String[] args) {
        
        //Q -> how many object created here
        String s1 = new String("shivansh");
        //1 object because of new key word stored in heap
        //2 object because of literal stored in SCP (String pool) 
        
        
        String s2 = "shivansh";

        //Total object count is 2
        
        System.out.println(s1 == s2); //False because s1 is heap and s2 is pool
        //To prove it
        System.out.println(s1.intern().hashCode() == s2.hashCode());
    }
} 

