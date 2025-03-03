import java.util.*;
public class GenerateAllSubWithSumLessThanK {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		for(int i=0; i<size; i++){
			arr[i] =  sc.nextInt();
		}
		int k = sc.nextInt();
		int maxLen = 0;
		for(int i=0; i<size; i++){
			int sum = 0;
			for(int j=i; j<size; j++){
				sum = sum + arr[j];
				if(sum <= k){
					maxLen = Math.max(maxLen,sum);
				}
				else if(sum >= k) break;
			}
		}
		System.out.println(maxLen);
	} 
} 

