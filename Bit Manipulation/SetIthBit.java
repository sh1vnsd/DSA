import java.util.Scanner;

public class SetIthBit{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int i = sc.nextInt();

        int shift = 1 << i;

        int res = n | shift;

        System.out.println(res);
    }
}
