import java.util.*;
public class MaxConsecutiveOnes{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        int l = 0, r = 0, maxLen = 0;
        while(r < size){
            if(arr[r] == 0){
                if(k > 0){
                    k--;
                    maxLen = Math.max(maxLen, r - l + 1);
                    r++;
                }
                else{
                    if(arr[l] == 0){
                        k++;
                    }
                    l++;
                }
            }
            else{
               maxLen = Math.max(maxLen, r - l + 1);
               r++;
            }
        }
        System.out.println(maxLen);
    }
}
