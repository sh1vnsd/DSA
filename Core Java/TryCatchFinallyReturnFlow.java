//public class TryCatchFinallyReturnFlow{
//    public static int m1(){
//        try{
//            return 1;
//        }
//        catch (Exception ex){
//            return 2;
//        }
//        finally {
//            return 3;
//        }
//    }
//
//    public static void main(String[] args) {
//       System.out.println(m1());
//    }
//}
// Output = 3;

//
//public class TryCatchFinallyReturnFlow{
//    public static int m1(){
//        try{
//            return 1;
//        }
//        catch (Exception ex){
//            return 2;
//        }
//}
//
//    public static void main(String[] args) {
//       System.out.println(m1());
//    }
//}
//Output = 1;

public class TryCatchFinallyReturnFlow{
    public static int m1(){
        try{
            System.out.println(10/0);
            return 1;
        }
        catch (Exception ex){
            return 2;
        }
        finally {
            return 3;
        }
}

    public static void main(String[] args) {
       System.out.println(m1());
    }
}

