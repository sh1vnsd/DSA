import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
  public int minStoneSum(int[] piles, int k) {
    int totalSum = 0;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    for (var pile : piles) {
      totalSum += pile;
      maxHeap.offer(pile);
    }

    while (k-- > 0) {
      int largest = maxHeap.poll();
      int remove = largest / 2;
      totalSum -= remove;

      maxHeap.offer(largest - remove);
    }
    return totalSum;
  }
}
