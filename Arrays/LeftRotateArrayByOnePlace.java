import java.util.Scanner;

public class LeftRotateArrayByOnePlace{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int temp = arr[0];

        int index = 0;

        for(int i = 1; i < arr.length; i++){
            arr[index] = arr[i];
            index++;
        }

        arr[index] = temp;

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
