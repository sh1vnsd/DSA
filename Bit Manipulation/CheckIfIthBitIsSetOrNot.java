import java.util.Scanner;

public class CheckIfIthBitIsSetOrNot{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int i = sc.nextInt();

        if(((n >> i) & 1) == 1){
            System.out.println("Set");
        }
        else{
            System.out.println("Not - Set");
        }
    }
}
