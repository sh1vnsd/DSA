import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      int size = sc.nextInt();
      int[] nums = new int[size];

      for(int i=0; i<size; i++){
      	nums[i] = sc.nextInt();
      } 

      int target = sc.nextInt();

      Map<Integer, Integer> mp = new HashMap<>();

      for(int i=0; i<size; i++){
      	int comp = target - nums[i];
      	if(mp.containsKey(comp)){
      		System.out.println(comp + " " + nums[i]);
      		return;
      	}
      	mp.put(nums[i], i);
      }
      System.out.println("No pair found");
  }
}

