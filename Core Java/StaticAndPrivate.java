class Parent {
    public static void m2(){
        System.out.println("Parent static m2()");
    }

    private void test(){

    }
}

class Child extends Parent{
    
    //@Override will give compilation error here
    public static void m2(){
        System.out.println("Child static m2()");
    }

    //We wont get the option to override the private method
}

public class StaticAndPrivate{
    public static void main(String[] args) {
       Parent.m2(); 
       Child.m2();
    }
}
