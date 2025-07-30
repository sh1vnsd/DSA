public class TestImmutableString{

    public static void main(String[] args) {
        String s = "java";

        s.concat(" core"); //This will create a new object with diff. ref.

        System.out.println(s);

        String password = "pwd"; 
        password.concat("123");

        //Lets say 5 references are using this password
        //now if we change anything in this password all 5 references will be tempered
        //It's a kind of a security breach
        //Thats why they made String immutable
    }
}
