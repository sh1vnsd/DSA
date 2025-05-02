class A{
    void methodA(){
        System.out.println("Method Of A Class");
    }
}

class B extends A{
    void methodB(){
        System.out.println("Method Of B Class");
    }
}

class C extends B{
    void methodC(){
        System.out.println("Method of C Class");
    }
}
public class MultiLevelInheritance{
    public static void main(String[] args) {
        C obj1 = new C();

        obj1.methodC();
        System.out.println();

        obj1.methodB();
        System.out.println();

        obj1.methodA();
    }
}
