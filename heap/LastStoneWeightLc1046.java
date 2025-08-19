import java.util.PriorityQueue;

class Solution {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    while (maxHeap.size() > 1) {
      int x = maxHeap.poll();
      int y = maxHeap.poll();

      int rem = x - y;

      maxHeap.offer(rem);
    }

    return maxHeap.peek();
  }
}
