import java.util.PriorityQueue;

class KthLargest {

  // Min heap
  PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  int K;

  public KthLargest(int k, int[] nums) {
    K = k;
    for (var it : nums) {
      minHeap.offer(it);

      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
  }

  public int add(int val) {
    minHeap.offer(val);

    if (minHeap.size() > K) {
      minHeap.poll();
    }

    return minHeap.peek();
  }
}
