import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

    heap.addAll(map.keySet());

    int[] ans = new int[k];
    int i = 0;
    while (k-- > 0) {
      int peek = heap.poll();
      ans[i] = peek;
      i++;
    }

    return ans;
  }
}
