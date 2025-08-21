import java.util.PriorityQueue;

class Solution {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (var it : nums) {
      minHeap.offer(it);

      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    return minHeap.peek();
  }
}
