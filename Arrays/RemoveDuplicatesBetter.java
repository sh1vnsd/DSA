import java.util.*;
public class RemoveDuplicatesBetter{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		for(int i=0; i<size; i++){
			arr[i] = sc.nextInt();
		}
		int i = 0;
		for(int j=1; i<size-1; i++){
			if(arr[i] == arr[j]){
				i++;
				arr[j] = arr[i];
			}
		}

		for(int k=0; k<i+1; k++){
			System.out.print(arr[k]);
		}
	}
}