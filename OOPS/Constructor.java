class Students{
    int id;
    int age;

    Students(int id, int age){
        this.id = id;
        this.age = age;
        System.out.println("Parameterized Constructor Called");
    }

    Students(int id, String name, int age){
        System.out.println("Second Parameterized Constructor Called");
    }

    Students(){
        System.out.println("Default Constructor Called");
    }
}
public class Constructor{
    public static void main(String[] args) {

        Students obj = new Students(1374, 21);
        Students obj1 = new Students(1374, "Shivansh", 21);
        Students obj2 = new Students();

    }
}
