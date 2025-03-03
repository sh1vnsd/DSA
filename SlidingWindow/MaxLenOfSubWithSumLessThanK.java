//import java.util.*;
//public class MaxLenOfSubWithSumLessThanK{
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int size = sc.nextInt();
//		int[] arr = new int[size];
//		for(int i=0; i<size; i++){
//			arr[i] = sc.nextInt();
//		}
//
//		int k = sc.nextInt();
//		int l = 0, r = 0, sum = 0, maxLen = 0;
//		while(r < size){
//			sum += arr[r];
//			while(sum >= k){
//				sum -= arr[l];
//				l++;
//			}
//				maxLen = Math.max(maxLen, r - l + 1);
//				r++;
//		}
//		System.out.println(maxLen);
//	}
//}

//Optimal Solution
import java.util.*;
public class MaxLenOfSubWithSumLessThanK{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		for(int i=0; i<size; i++){
			arr[i] = sc.nextInt();
		}

		int k = sc.nextInt();
		int l = 0, r = 0, sum = 0, maxLen = 0;
		while(r < size){
			sum += arr[r];
			if(sum >= k){ //removed while and added if 
				sum -= arr[l];
				l++;
			}
				maxLen = Math.max(maxLen, r - l + 1);
				r++;
		}
		System.out.println(maxLen);
	}
}

 
