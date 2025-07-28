class Parent{
    public void m1(){
        System.out.println("Parent m1()");
    }

    public static void m2(){
        System.out.println("Parent static m2()");
    }
}

class Child extends Parent{

    //If m1 here doesnt exist then it will go to the parent class and find m1 over there and print it
    @Override
    public void m1(){
        System.out.println("Child m1()");
    }
}
public class DynamicMethodDispatch{
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.m1();
    }
} 
