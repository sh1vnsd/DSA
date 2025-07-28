public class FinalFinallyAndFinalize{
    private final int a = 10;

    public void m1(){
        // a = 20; //cannot reassign

        try{
            System.out.println("try block");
        } 
        finally{
            System.out.println("finally block");
            //clean streams..
        }
    }

    protected void finalize() throws Throwable {
        System.out.println("Finalize method called....");
    }

    public static void main(String[] args) {
        FinalFinallyAndFinalize demo = new FinalFinallyAndFinalize();
        demo.m1();

        demo = null;

        System.gc();
    }
}
