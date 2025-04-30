class Student{
    final String name = "nanu";
    int roll_no;
    String address;
}
public class ClassAttributesAndMethods{
    public static void main(String[] args) {
       Student std1 = new Student(); 
       std1.name = "Shivansh";
       System.out.println(std1.name);

       std1.name = "Raman";
       System.out.println(std1.name);

       Student std2 = new Student();
       std2.name = "Sneha";
       System.out.println(std2.name);
    }
}
