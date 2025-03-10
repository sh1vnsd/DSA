import java.util.*;
public class CountNumberOfOnes{
    public static void main(String[] args) {
        int n = 11;
        int count = 0;
        while(n != 0){
            if((n & 1) == 1) count++;
            n = n >> 1;
        }
        System.out.println(count);
    }
}
